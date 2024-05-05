package com.hospital.global.exceptionHandling;

import java.util.NoSuchElementException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class HospitalGlobalAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(NoSuchElementException.class) //400 - bad request
	public ResponseEntity<String> handleEmptyInput(NoSuchElementException emptyInputFormatException) {
		return new ResponseEntity<String>("Input Field Check, Please look it", HttpStatusCode.valueOf(400));
	}
	
	
	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(HttpMediaTypeNotAcceptableException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
	
		return new ResponseEntity<Object>("Input Field Check, Please look it", HttpStatusCode.valueOf(400));
	}
}
