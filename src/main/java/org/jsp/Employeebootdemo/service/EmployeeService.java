package org.jsp.Employeebootdemo.service;

import java.util.List;
import java.util.Optional;

import org.jsp.Employeebootdemo.dao.EmployeeDao;
import org.jsp.Employeebootdemo.dto.Employee;
import org.jsp.Employeebootdemo.dto.ResponseStructure;
import org.jsp.Employeebootdemo.exception.IdNotFoundException;
import org.jsp.Employeebootdemo.exception.InvalidCredentialException;
import org.jsp.Employeebootdemo.exception.InvalidCredentialException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeDao dao;
	public ResponseEntity<ResponseStructure<Employee>> saveEmployeeResponseEntity(Employee emp) {
			ResponseStructure<Employee> structure=new ResponseStructure<Employee>();
			structure.setMessage("employee saved succefully");
			structure.setBody(dao.saveEmployee(emp));
			structure.setCode(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Employee>>(	structure,HttpStatus.CREATED);
		}
		public ResponseEntity<ResponseStructure<Employee>> updateEmployee(Employee emp) {
			ResponseStructure<Employee> structure=new ResponseStructure<Employee>();
			structure.setMessage("employee updated succefully");
			structure.setBody(dao.updateEmployee(emp));
			structure.setCode(HttpStatus.ACCEPTED.value());
			return  new ResponseEntity<ResponseStructure<Employee>>(structure,HttpStatus.ACCEPTED);
		}
		public ResponseEntity<ResponseStructure<Employee>> findEmployee(int id) {
			ResponseStructure<Employee> structure=new ResponseStructure<Employee>();
			Optional<Employee> recievedEmployee=dao.findEmployee(id);
			if( recievedEmployee.isPresent()) {
				structure.setBody(recievedEmployee.get());
			structure.setCode(HttpStatus.OK.value());
			structure.setMessage("employee present");
			return new ResponseEntity<ResponseStructure<Employee>>(structure,HttpStatus.OK);
		}
			throw new IdNotFoundException();
		}
		
		public ResponseEntity<ResponseStructure<String>> deleteEmployee(int id) {
			ResponseStructure<String> structure=new ResponseStructure<String>();
			Optional<Employee>  recievedUser=dao.findEmployee(id);
			if( recievedUser.isPresent()) {
				dao.deleteEmployee(id);
				structure.setBody("employee deleted");
			structure.setCode(HttpStatus.OK.value());
			structure.setMessage("employee present");
			return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.OK);
		}
			structure.setBody("employee not deleted");
			structure.setMessage("employee not found");
			structure.setCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
		}
		public ResponseEntity<ResponseStructure<Employee>> verifyEmployee(long phone,String password){
			ResponseStructure<Employee> structure=new ResponseStructure<Employee>();
			Optional<Employee>  recievedEmployee=dao.verifyEmployee(phone,password);
			if( recievedEmployee.isPresent()) {
				structure.setBody(recievedEmployee.get());
				structure.setCode(HttpStatus.OK.value());
				structure.setMessage("employee verified succefully");
				return new ResponseEntity<ResponseStructure<Employee>>(structure,HttpStatus.OK);
			}
			throw new InvalidCredentialException();
		}
		public ResponseEntity<ResponseStructure<Employee>> verifyEmployee(int id,String password){
			ResponseStructure<Employee> structure=new ResponseStructure<Employee>();
			Optional<Employee>  recievedEmployee=dao.verifyEmployee(id,password);
			if( recievedEmployee.isPresent()) {
				structure.setBody(recievedEmployee.get());
				structure.setCode(HttpStatus.OK.value());
				structure.setMessage("employee verified succefully");
				return new ResponseEntity<ResponseStructure<Employee>>(structure,HttpStatus.OK);
			}
			throw new InvalidCredentialException();
		}
		public ResponseEntity<ResponseStructure<Employee>> fetchEmployeebyDesig(Employee emp){
			ResponseStructure<Employee> structure=new ResponseStructure<Employee>();
			Optional<Employee> recievedEmployee=dao.fetchEmployeebyDesig(emp);
			if( recievedEmployee.isPresent()) {
				structure.setBody(recievedEmployee.get());
			structure.setCode(HttpStatus.OK.value());
			structure.setMessage("employee fetched by designation");
			return new ResponseEntity<ResponseStructure<Employee>>(structure,HttpStatus.OK);
		}
			throw new InvalidCredentialException();
		}
		public ResponseEntity<ResponseStructure<Employee>> fetchEmployeebyDept(Employee emp){
			ResponseStructure<Employee> structure=new ResponseStructure<Employee>();
			Optional<Employee> recievedEmployee=dao.fetchEmployeebyDept(emp);
			if( recievedEmployee.isPresent()) {
				structure.setBody(recievedEmployee.get());
			structure.setCode(HttpStatus.OK.value());
			structure.setMessage("employee fetchedby department");
			return new ResponseEntity<ResponseStructure<Employee>>(structure,HttpStatus.OK);
		}
			throw new InvalidCredentialException();
		}
		
		
}
