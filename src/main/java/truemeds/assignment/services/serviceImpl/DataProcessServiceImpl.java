package truemeds.assignment.services.serviceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import truemeds.assignment.entities.OutputDetails;
import truemeds.assignment.repositories.DataProcessingRepo;
import truemeds.assignment.repositories.OutputDataRepo;
import truemeds.assignment.services.DataProcessService;

@Service
public class DataProcessServiceImpl implements DataProcessService {

	public static final Logger log = LogManager.getLogger(DataProcessServiceImpl.class);

	public static int count = 0;

	@Autowired
	private DataProcessingRepo dataProcessingRepo;

	@Autowired
	private OutputDataRepo outputDataRepo;

	@Override
	public void processData() {
		try {
			List<String> inputValues = new ArrayList<>();
			inputValues = dataProcessingRepo.fetchAllValues();
			for (String value : inputValues) {
				countDuplicateRemoval(value);
			}
		} catch (Exception ex) {
			log.error("Exception: {}", ex);

		}
	}

	private void countDuplicateRemoval(String inputvalue) {

		count = 0;
		String cleaned = removeDuplicates(inputvalue, ' ');
		updateData(inputvalue, cleaned, count);

	}

	private String removeDuplicates(String intputValue, char lastRemoved) {

		if (intputValue.length() == 0 || intputValue.length() == 1)
			return intputValue;

		if (intputValue.charAt(0) == intputValue.charAt(1)) {
			count++;
			lastRemoved = intputValue.charAt(0);
			while (intputValue.length() > 1 && intputValue.charAt(0) == intputValue.charAt(1)) {
				intputValue = intputValue.substring(1, intputValue.length());
			}
			intputValue = intputValue.substring(1, intputValue.length());
			return removeDuplicates(intputValue, lastRemoved);
		}

		String remStr = removeDuplicates(intputValue.substring(1, intputValue.length()), lastRemoved);

		if (remStr.length() != 0 && remStr.charAt(0) == intputValue.charAt(0)) {
			lastRemoved = intputValue.charAt(0);

			count++;
			return remStr.substring(1, remStr.length());
		}

		if (remStr.length() == 0 && lastRemoved == intputValue.charAt(0))
			return remStr;
		return (intputValue.charAt(0) + remStr);
	}

	private void updateData(String originalString, String cleanedString, int steps) {

		OutputDetails output = new OutputDetails();
		output.setOriginalString(originalString);
		output.setCleanedString(cleanedString);
		output.setNumberOfSteps(steps);
		output.setCreatedOn(LocalDateTime.now());

		outputDataRepo.save(output);

	}

}
