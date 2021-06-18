package truemeds.assignment.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dhamini_kataria_java_output_data")
public class OutputDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "original_string")
	private String originalString;
	
	@Column(name = "cleaned_string")
	private String cleanedString;
	
	@Column(name = "number_of_steps")
	private int numberOfSteps;

	@Column(name = "created_on")
	private LocalDateTime createdOn;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOriginalString() {
		return originalString;
	}

	public void setOriginalString(String originalString) {
		this.originalString = originalString;
	}

	public String getCleanedString() {
		return cleanedString;
	}

	public void setCleanedString(String cleanedString) {
		this.cleanedString = cleanedString;
	}

	public int getNumberOfSteps() {
		return numberOfSteps;
	}

	public void setNumberOfSteps(int numberOfSteps) {
		this.numberOfSteps = numberOfSteps;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime localDateTime) {
		this.createdOn = localDateTime;
	}

	
}
