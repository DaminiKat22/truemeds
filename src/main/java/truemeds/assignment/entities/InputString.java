package truemeds.assignment.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "input_details")
public class InputString {
	
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "input_string")
	private String inputString;
	

}
