package org.jsp.Employeebootdemo.exception;


import org.jsp.Employeebootdemo.dto.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class EmployeebootdemoExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleIdNotFoundExceptionEntity(IdNotFoundException e){
		ResponseStructure<String>structure=new ResponseStructure<>();
		structure.setMessage(e.getMessage());
		structure.setBody("employee not found");
		structure.setCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
		@ExceptionHandler(InvalidCredentialException.class)
		public ResponseEntity<ResponseStructure<String>> handleInvalidCredentialException(InvalidCredentialException e){
			ResponseStructure<String>structure=new ResponseStructure<>();
			structure.setMessage(e.getMessage());
			structure.setBody("Invalid phone or email or password");
			structure.setCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
		}
}
