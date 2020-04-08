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
import org.springframework.stereotype.Service;

import com.ggeit.pay.entity.Bodydetail;
import com.ggeit.pay.entity.DiseaseInfo;
import com.ggeit.pay.inf.BodydetailServiceinf;
import com.ggeit.pay.utils.BeanMapUtil;
import com.google.gson.Gson;
@Service
public class BodydetailServiceImpl implements BodydetailServiceinf{
	private final static Logger logger = LoggerFactory.getLogger(BodydetailServiceImpl.class);
	
	 @Autowired
	    private MongoTemplate mongotemplate;

	 @Override
	public List<Map<String, Object>> findByOne(Map<String,Object> reqmap) {
		// TODO Auto-generated method stub
		String whereStr =(String) reqmap.get("whereStr");
		String whereStrData =(String) reqmap.get("whereStrData");
		
		Query query = new Query();	
		query.addCriteria(Criteria.where(whereStr).is(whereStrData));
		List<Bodydetail> datalist = mongotemplate.find(query, Bodydetail.class,"body_detail");
		//logger.info("datalist:"  + datalist);
		return BeanMapUtil.beansToMaps(datalist);
	}
	
		@Override
		public List<Map<String,Object>> findallFromBodydetail() {
			// TODO Auto-generated method stub
			List<Bodydetail> findList = mongotemplate.findAll( Bodydetail.class,"body_detail");

			//return new Gson().toJson(findList);
			return BeanMapUtil.beansToMaps(findList);
		}

}
