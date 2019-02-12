package com.lzp.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lzp.project.domain.LzpJSONResult;

@Controller
@RequestMapping("err")
public class ErrorController {

	@RequestMapping("/error")
	public String error(){
		int a = 1 /0 ;
		return "thymeleaf/error";
	}
	@RequestMapping("/ajaxerror")
	public String ajaxerror(){
		return "thymeleaf/ajaxerror";
	}
	
	@RequestMapping("/getAjaxerror")
	@ResponseBody
	public LzpJSONResult getAjaxerror(){
		int a = 1 /0;
		return LzpJSONResult.ok();
	}
}
