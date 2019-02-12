package com.lzp.project.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.lzp.project.domain.LzpJSONResult;

@ControllerAdvice
public class LzpExceptionHandler {

	public static final String LZP_ERROR_VIEW = "error";
	
	//@ExceptionHandler(value= Exception.class)
//	public Object errorHandler(HttpServletRequest request,
//			HttpServletResponse response,Exception e){
//		e.printStackTrace();
//		
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("exception",e);
//		mav.addObject("url",request.getRequestURL());
//		mav.setViewName(LZP_ERROR_VIEW);
//		return mav;
//	}
	@ExceptionHandler(value= Exception.class)
	public Object errorHandler(HttpServletRequest request,
			HttpServletResponse response, Exception e) {
		e.printStackTrace();
		if(isAjax(request)){
			return LzpJSONResult.errorException(e.getMessage());
		}else {
			ModelAndView mav = new ModelAndView();
			mav.addObject("exception",e);
			mav.addObject("url",request.getRequestURL());
			mav.setViewName(LZP_ERROR_VIEW);
			return mav;
		}
	}
	/**
	 * 判断当前的是否是ajax请求
	 * @param httpRequest
	 * @return
	 */
	public static boolean isAjax(HttpServletRequest httpRequest){
		return (httpRequest.getHeader("X-Requested-With") != null 
				&& "XMLHttpRequest".equals(httpRequest.getHeader("X-Requested-With").toString()));
	}
}
