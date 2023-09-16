package org.jsp.Employeebootdemo.dao;


import java.util.Optional;

import org.jsp.Employeebootdemo.dto.Employee;
import org.jsp.Employeebootdemo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {
	@Autowired
	private EmployeeRepository repository;
	public Employee saveEmployee(Employee emp) {
		return repository.save(emp);
	}
	
public Employee updateEmployee(Employee emp) {
	return repository.save(emp);
}
public Optional<Employee> findEmployee(int id){
	return repository.findById(id);
}

public void deleteEmployee(int id) {
	repository.deleteById(id);
}
public Optional<Employee> fetchEmployeebyDept(Employee emp){
	return repository.fetchEmployeebyDept(emp);
}
public Optional<Employee> fetchEmployeebyDesig(Employee emp){
	return repository.fetchEmployeebyDesig(emp);
}

public Optional<Employee> verifyEmployee(long phone,String password)
{
	return repository.verifyEmployee(phone, password);
}
public Optional<Employee> verifyEmployee(int id,String password)
{
	return repository.verifyEmployee(id, password);
}
}
