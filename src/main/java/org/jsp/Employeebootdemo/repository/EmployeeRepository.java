package org.jsp.Employeebootdemo.repository;

import java.util.Optional;

import org.jsp.Employeebootdemo.dto.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	@Query("select e from Employee e where e.phone=?1 and e.password=?2")
	public Optional<Employee> verifyEmployee(long phone,String password);

	@Query("select e from Employee e where e.id=?1 and e.password=?2")
	public Optional<Employee> verifyEmployee(int id,String password);
	
	@Query("select e from Employee e where e.designation=?1")
	public Optional<Employee> fetchEmployeebyDesig(Employee emp);
	
	@Query("select e from Employee e where e.dept=?1")
	public Optional<Employee> fetchEmployeebyDept(Employee emp);

}