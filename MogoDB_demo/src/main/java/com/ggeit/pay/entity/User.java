package com.ggeit.pay.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class User {

	private String name;
	private String age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
}
