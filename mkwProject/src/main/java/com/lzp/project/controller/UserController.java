package com.lzp.project.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lzp.project.domain.LzpJSONResult;
import com.lzp.project.domain.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private Resource resource;
	
	@RequestMapping("/hello")
	public String test1(){
		return "123";
	}
	
	@RequestMapping("/getResource")
	public LzpJSONResult getResource(){
		Resource bean = new Resource();
		BeanUtils.copyProperties(resource, bean);
		return LzpJSONResult.ok(bean);
	}
}
