package org.zerock.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.log4j.Log4j;
//@ControllerAdvice : Controller(Servlet)+ 공통모듈 수행내용(AOP)
@ControllerAdvice
@Log4j
public class CommonExceptionAdvice {
	//예외발생시 동작
	@ExceptionHandler(Exception.class)
	public String except(Exception ex, Model model) {
		log.info("Exception:--------"+ex.getMessage());
		model.addAttribute("exception", ex);
		log.error(model);
		return "error_page";//views/error_page.jsp
		
	}
	//Not Found예외인 경우 수행
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handle404(NoHandlerFoundException ex) { //404:file not found
	
		return "custom404"; //views/custom040.jsp
		
	}
	
	
	
}









