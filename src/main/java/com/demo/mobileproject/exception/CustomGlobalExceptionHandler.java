package com.demo.mobileproject.exception;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class CustomGlobalExceptionHandler {

	Logger logger = LogManager.getLogger(CustomGlobalExceptionHandler.class);

	@ExceptionHandler(value = Exception.class)
	public String handleException(Exception e, Model model) {
		logger.error(String.format("Exception:\t[%s]", e));

		int statusCode = 0;
		String subTitle = "Sorry!";
		String message = "";
		
		if (e instanceof NullPointerException || e instanceof SQLException) {
			statusCode = 500;
			message = "something went wrong on our end. We are currently trying to fix problem.";
		} else if (e instanceof DataAccessException || e instanceof DataIntegrityViolationException) {	// databaseError
			statusCode = 409;
			message = e.getMessage();

		} else if (e instanceof HttpMessageNotReadableException) {
			// bad request
			statusCode = 400;
			subTitle = "Bad Request!";
			message = e.getMessage();

		} else if (e instanceof AccessDeniedException) {
			statusCode = 403;
			message = "your access is refused due to security reasons of our server and also our sensitive data.";

		} else if (e instanceof NoHandlerFoundException){
			statusCode = 404 ;
			subTitle = "Oops! Page Not Be Found.";
			message = "Sorry but the page you are looking for does not exist, have been removed. name changed or is temporarily unavailable";
			
		} else {
			statusCode = 0 ;
			subTitle = "Woops!";
			message = "Something went wrong";
			
		}

		model.addAttribute("statusCode",statusCode );
		model.addAttribute("subtitle",subTitle);
		model.addAttribute("message",message);
		
		return "errorPage";
	}
}