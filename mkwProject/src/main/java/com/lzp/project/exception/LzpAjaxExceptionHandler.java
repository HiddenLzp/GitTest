package com.lzp.project.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.lzp.project.domain.LzpJSONResult;

//@RestControllerAdvice
public class LzpAjaxExceptionHandler {

	//Ajax异常处理
	//@ExceptionHandler(value = Exception.class)
	public LzpJSONResult defaultErrorHandler(
			HttpServletRequest req,Exception e
			){
		e.printStackTrace();
		return LzpJSONResult.errorException(e.getMessage());
	}
}
