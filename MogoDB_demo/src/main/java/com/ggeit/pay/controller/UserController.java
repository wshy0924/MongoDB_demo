package com.ggeit.pay.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ggeit.pay.entity.User;
import com.ggeit.pay.impl.DiseaseServiceImpl;
import com.ggeit.pay.impl.UserServiceImpl;
import com.google.gson.Gson;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private final static Logger logger = LoggerFactory.getLogger(UserController.class);
	
    @Autowired
    private UserServiceImpl userserviceimpl;
	/**
	 * MongoDB insert
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/insertuser", method = RequestMethod.GET)
	public void insert(HttpServletRequest request, HttpServletResponse response,String name,String age) throws Exception {
		
		Map<String ,Object> reqmap = new HashMap<String,Object>();
		reqmap.put("name", name);
		reqmap.put("age", age);
		String collectionName = "user";//插入哪个集合（表）
		//调用insert接口
		userserviceimpl.insert(reqmap,collectionName);
		logger.info("插入成功！");
     }
	
	/**
	 * MongoDB update
	 * @param req
	 * @param resp
	 */
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public void update(HttpServletRequest req,HttpResponse resp,String name,String age) {
		userserviceimpl.updateUserbyname(name,age);
		logger.info("更新成功！");
	}
	
	/**
	 * MongoDB findall
	 * @param req
	 * @param resp
	 */
	@RequestMapping(value = "/findall", method = RequestMethod.GET)
	public String findall(HttpServletRequest req,HttpResponse resp) {
		String str = userserviceimpl.find();
		//查出来的数据要转成json格式，不然会显示错误
		logger.info("查询成功：" + str);
		return str;
	}
	
}
