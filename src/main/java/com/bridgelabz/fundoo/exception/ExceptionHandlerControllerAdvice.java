package com.bridgelabz.fundoo.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice extends ResponseEntityExceptionHandler{


	@ExceptionHandler(UserDoesNotExistException.class)
	public ResponseEntity<ExceptionResponse> existresponse(UserDoesNotExistException exception) {
		ExceptionResponse exceptionresponse = new ExceptionResponse(exception.getMessage(),
				HttpStatus.UNAUTHORIZED.value());

		return new ResponseEntity<ExceptionResponse>(exceptionresponse, HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(UserAllreadyPresentException.class)
	public ResponseEntity<ExceptionResponse> presentresponse(UserAllreadyPresentException exception) {
		ExceptionResponse exceptionresponse = new ExceptionResponse(exception.getMessage(),
				HttpStatus.ALREADY_REPORTED.value());

		return new ResponseEntity<ExceptionResponse>(exceptionresponse, HttpStatus.ALREADY_REPORTED);
	}

	@ExceptionHandler(RessetPasswordException.class)
	public ResponseEntity<ExceptionResponse> resetpasswordresponse(RessetPasswordException exception) {
		ExceptionResponse exceptionresponse = new ExceptionResponse(exception.getMessage(),
				HttpStatus.NOT_MODIFIED.value());

		return new ResponseEntity<ExceptionResponse>(exceptionresponse, HttpStatus.NOT_MODIFIED);
	}

	@ExceptionHandler(InvalidEmailException.class)
	public ResponseEntity<ExceptionResponse> emailresponse(InvalidEmailException exception) {
		ExceptionResponse exceptionresponse = new ExceptionResponse(exception.getMessage(),
				HttpStatus.NOT_FOUND.value());

		return new ResponseEntity<ExceptionResponse>(exceptionresponse, HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		// return super.handleMethodArgumentNotValid(ex, headers, status, request);
		 List<String> details = new ArrayList<>();
	        for(ObjectError error : ex.getBindingResult().getAllErrors()) {
	            details.add(error.getDefaultMessage());
	        }
	        ErrorResponse error = new ErrorResponse("Validation Failed", details);
	        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
	
	}

	
	/*
	 * @ExceptionHandler(UserException.class) public
	 * ResponseEntity<ExceptionResponse> emailresponse(RuntimeException exception) {
	 * ExceptionResponse exceptionresponse = new
	 * ExceptionResponse(exception.getMessage(), HttpStatus.BAD_REQUEST.value());
	 * 
	 * return new ResponseEntity<ExceptionResponse>(exceptionresponse,
	 * HttpStatus.BAD_REQUEST); }
	 */
	

	/*
	 * @ExceptionHandler(UserDoesNotExistException.class)
	 * 
	 * @ResponseStatus(value = HttpStatus.NOT_FOUND) public @ResponseBody
	 * ExceptionResponse getResponse(UserDoesNotExistException exception,
	 * HttpServletRequest request) { ExceptionResponse response = new
	 * ExceptionResponse();
	 * 
	 * response.setMessage(exception.getMessage());
	 * //response.setRequested_uri(request.getRequestURI());
	 * 
	 * return response; }
	 */

	/*
	 * @ExceptionHandler(UserPresentException.class)
	 * 
	 * @ResponseStatus(value = HttpStatus.BAD_REQUEST) public @ResponseBody
	 * ExceptionResponse getResult(UserPresentException exception,
	 * HttpServletRequest request) { ExceptionResponse response= new
	 * ExceptionResponse();
	 * 
	 * response.setMessage(exception.getMessage());
	 * response.setRequested_uri(request.getRequestURI());
	 * 
	 * return response; }
	 */
}
