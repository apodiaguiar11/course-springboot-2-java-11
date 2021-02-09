package com.educandoweb.source.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.educandoweb.source.services.exceptions.ResourceNotFoundException;

//Annotation para interceptar as exceções que acontecerem para que esse objeto
//possa executar um possível tratamento
@ControllerAdvice
public class ResourceExceptionHandler {

	//Com essa annotation, esse método irá interceptar qualquer exceção do tipo ResourceNotFoundException
	//que foi lançada e vai fazer o tratamento que estiver dentro desse método.
	//Aqui seria o tratamento personalizado
	@ExceptionHandler(ResourceNotFoundException.class)	
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request ){
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
}
