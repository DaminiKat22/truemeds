package truemeds.assignment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import truemeds.assignment.entities.OutputDetails;

@Repository
public interface OutputDataRepo extends JpaRepository<OutputDetails, Integer> {
	

}
