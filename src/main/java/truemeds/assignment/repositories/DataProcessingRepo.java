package truemeds.assignment.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import truemeds.assignment.entities.InputString;


@Repository
public interface DataProcessingRepo extends JpaRepository<InputString, Integer>{
	
	@Query("SELECT new java.lang.String(input.inputString) from "
			+ " InputString input")
	List<String> fetchAllValues();

}
