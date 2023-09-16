package org.jsp.Employeebootdemo.exception;

public class InvalidCredentialException extends RuntimeException{
	@Override
	public String getMessage() {
		return "Invalid credential";
	}
}
