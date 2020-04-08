package com.ggeit.pay.impl;

import java.util.Collection;
import java.util.HashMap;
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

import com.ggeit.pay.entity.DiseaseInfo;
import com.ggeit.pay.entity.User;
import com.ggeit.pay.inf.DiseaseServiceinf;
import com.ggeit.pay.utils.BeanMapUtil;
import com.google.gson.Gson;
import com.mongodb.WriteResult;


@Service
public class DiseaseServiceImpl implements DiseaseServiceinf {
	private final static Logger logger = LoggerFactory.getLogger(DiseaseServiceImpl.class);
    @Autowired
    private MongoTemplate mongotemplate;
	@Override
	public void insert(Map<String,Object> map) {
		// TODO Auto-generated method stub
		DiseaseInfo dis = new DiseaseInfo();
		dis.setSID(map.get("SID").toString());
		mongotemplate.insert(dis);
	}
	@Override
	public List<Map<String,Object>> findallFromDiseaseinfo() {
		// TODO Auto-generated method stub
		List<DiseaseInfo> findList = mongotemplate.findAll( DiseaseInfo.class,"disease_info");

		//return new Gson().toJson(findList);
		return BeanMapUtil.beansToMaps(findList);
	}
	@Override
	public List<Map<String,Object>> findByOne(Map<String,Object> reqmap) {
		// TODO Auto-generated method stub
		String whereStr =(String) reqmap.get("whereStr");
		String updataStr =(String) reqmap.get("updataStr");
		logger.info("whereStr = " + whereStr);
		Query query = new Query();	
		query.addCriteria(Criteria.where(whereStr).is(updataStr));
		List<DiseaseInfo> datalist = mongotemplate.find(query, DiseaseInfo.class,"disease_info");
		logger.info("datalist.stream: " + BeanMapUtil.beansToMaps(datalist));
		//String Str = new Gson().toJson(datalist);
		//return Str;
		return BeanMapUtil.beansToMaps(datalist);
	}
	
	@Override
	public Boolean updatebyOne(Map<String,Object> map) {
		// TODO Auto-generated method stub
		String whereStr = (String) map.get("whereStr");
		String whereStrData = (String) map.get("whereStrData");
		String updateStr = (String) map.get("updateStr");
		String updateStrData = (String) map.get("updateStrData");
		
		Query query = new Query();
	    query.addCriteria(Criteria.where(whereStr).is(whereStrData));
	    Update update = Update.update(updateStr, updateStrData);	//更新数据
	    WriteResult writeresult = mongotemplate.upsert(query, update, "disease_info");
	    //logger.info("str=" + writeresult.isUpdateOfExisting());
	    if(writeresult.isUpdateOfExisting()) {
	    	return true;
	    }
	    return false;  
	}
}


