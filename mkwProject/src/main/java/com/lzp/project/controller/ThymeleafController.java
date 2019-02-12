package com.lzp.project.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lzp.project.domain.User;

@Controller
@RequestMapping("th")
public class ThymeleafController {

	@RequestMapping("/index")
	public String index(ModelMap map){
		map.addAttribute("name", "thymeleaf-lzp");
		
		User u = new User();
		u.setAge(19);
		u.setName("superadmin");
		u.setBirthday(new Date());
		u.setDesc("<font color='red'>他正在努力！</font>");
		
		map.addAttribute("user",u);
		
		User u1 = new User();
		u1.setAge(16);
		u1.setName("张三");
		u1.setBirthday(new Date());
		
		User u2 = new User();
		u2.setAge(17);
		u2.setName("张四");
		u2.setBirthday(new Date());
		
		User u3 = new User();
		u3.setAge(18);
		u3.setName("张五");
		u3.setBirthday(new Date());
		
		User u4 = new User();
		u4.setAge(19);
		u4.setName("张六");
		u4.setBirthday(new Date());
		
		List<User> userList = new ArrayList<>();
		userList.add(u1);
		userList.add(u2);
		userList.add(u3);
		userList.add(u4);
		
		map.addAttribute("userList",userList);
		return "thymeleaf/index";
	}
	
	@RequestMapping("test")
	public String test(ModelMap map){
		map.addAttribute("name", "thymeleaf-lzp");
		return "thymeleaf/test";
	}
	
	@RequestMapping("center")
	public String center(){
		return "thymeleaf/center/center";
	}
	
	@PostMapping("postform")
	public String postform(User u){
		System.out.println(u.getName());
		return "redirect:/th/index";
	}
}
