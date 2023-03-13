package Saksoft.crudoperations.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import Saksoft.crudoperations.entity.ErrorMessage;

@ControllerAdvice
@ResponseStatus
public class MyControllerAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity <ErrorMessage> employeeNotFoundException(EmployeeNotFoundException ex, WebRequest request ) {
		
		ErrorMessage message=new ErrorMessage(HttpStatus.NOT_FOUND,ex.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
	}
}
