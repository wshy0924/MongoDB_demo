package com.ggeit.pay.inf;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.ggeit.pay.entity.User;

public interface UserServiceInf {

	//void insert(String name, String age);
	void updateUserbyname(String name, String age);
	//void insert(Map<String,Object> reqmap);
	void insert(Map<String, Object> reqmap, String collectionName);
	//Object findall();
	String find();
}
