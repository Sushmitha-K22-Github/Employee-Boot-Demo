package org.jsp.Employeebootdemo.exception;

public class IdNotFoundException extends RuntimeException{
	@Override
	public String getMessage() {
		return "Invalid Id";
	}
}
