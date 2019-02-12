package com.lzp.project.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration//代表我们会引用资源文件
@ConfigurationProperties(prefix = "com.lzp")
@PropertySource(value = "classpath:resources.properties")//资源文件地址
public class Resource {

	private String name;
	private String email;
	private String language;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
}
