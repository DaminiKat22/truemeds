package truemeds.assignment.controller;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import truemeds.assignment.services.DataProcessService;

@RestController
@RequestMapping("/truemeds")
public class DataProcessController {
	
	@Autowired
	private DataProcessService dataProcessService;
	
	public static final Logger log = LogManager.getLogger(DataProcessController.class);
	
   @GetMapping("/processData")
	public void getCount() {
	   try {
		  dataProcessService.processData();
		   
	   }catch(Exception ex) {
		   log.error("Exception: {}",ex);
	   }
		
		
	}


}
