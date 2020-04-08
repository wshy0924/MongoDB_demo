package com.ggeit.pay.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.ggeit.pay.controller.DataController;
import com.ggeit.pay.entity.DiseaseInfo;
import com.ggeit.pay.entity.User;
import com.ggeit.pay.inf.UserServiceInf;
import com.google.gson.Gson;
import com.mongodb.WriteResult;
@Service
public class UserServiceImpl implements UserServiceInf {
	private final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	  @Autowired
	  private MongoTemplate mongotemplate;
	/**
	 * 封装mongotemplate中的insert方法
	 */
	@Override
	public void insert(Map<String,Object> reqmap,String collectionName) {
		// TODO Auto-generated method stub
//		User user = new User();
//		user.setName(name);
//		user.setAge(age);
//		logger.info("user = " + user);
		mongotemplate.insert(reqmap, collectionName);
	}
	/**
	 * upsert更新，上传参数为query查询条件，update更新内容，collectionName为String类型
	 */
	@Override
	public void updateUserbyname(String name,String age) {
		// TODO Auto-generated method stub
		Query query = new Query();
	    query.addCriteria(Criteria.where("name").is(name));
	    Update update = Update.update("age", age);
	    WriteResult str = mongotemplate.upsert(query, update, "user");
	    logger.info("str=" + str.isUpdateOfExisting());
	}
	@Override
	public String find() {
		// TODO Auto-generated method stub
		Query query = new Query();	
		query.addCriteria(Criteria.where("name").is("wshy"));		
		//query.addCriteria(Criteria.where("age").is("12222222222"));		
		Collection<User> findList = mongotemplate.findAll( User.class,"user");

		return new Gson().toJson(findList);
	
	}

}
