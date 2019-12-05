package be.ehb.demo.model;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeDAO extends CrudRepository<Employee, Integer> {

    Iterable<Employee> findByNaam(String naam);
}
