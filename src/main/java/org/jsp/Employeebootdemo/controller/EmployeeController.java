package org.jsp.Employeebootdemo.controller;



import org.jsp.Employeebootdemo.dto.Employee;
import org.jsp.Employeebootdemo.dto.ResponseStructure;
import org.jsp.Employeebootdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	@Autowired
	 private EmployeeService service;
		
		@PostMapping("/emps")
		public ResponseEntity<ResponseStructure< Employee>> saveEmployee(@RequestBody  Employee emp) {
			return service.saveEmployeeResponseEntity(emp);
		}
		@PutMapping("/emps")
		public ResponseEntity<ResponseStructure<Employee>> updateEmployee(@RequestBody  Employee emp) {
			return service.updateEmployee(emp);
		}
		@GetMapping("/emps/{id}")
		public ResponseEntity<ResponseStructure<Employee>> findEmployee(@PathVariable int id) {
			return service.findEmployee(id);
		}
		@DeleteMapping("/emps/{id}")
		public ResponseEntity<ResponseStructure<String>> deleteEmployee(@PathVariable int id) {
			return service.deleteEmployee(id);
		}
		@GetMapping("/emps/fetch-desig")
		public ResponseEntity<ResponseStructure<Employee>> fetchEmployeebyDesig(@RequestBody Employee emp){
			return service.fetchEmployeebyDesig(emp);
		}
		@GetMapping("/emps/fetch-dept")
		public ResponseEntity<ResponseStructure<Employee>> fetchEmployeebyDept(@RequestBody Employee emp){
			return service.fetchEmployeebyDept(emp);
		}
		@PostMapping("/emps/verify-phone")
		public ResponseEntity<ResponseStructure<Employee>> verifyUser(@RequestParam long phone,@RequestParam String password){
			return service.verifyEmployee(phone, password);
		}
		@GetMapping("/emps/verify-id")
		public ResponseEntity<ResponseStructure<Employee>> verifyUser(@RequestParam int id,@RequestParam String password){
			return service.verifyEmployee(id,password);
		}
	}


