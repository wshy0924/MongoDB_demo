package com.ggeit.pay.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ggeit.pay.impl.BodydetailServiceImpl;
import com.ggeit.pay.impl.DiseaseServiceImpl;

@RestController
@RequestMapping("/crud")
public class CrudController {
	private final static Logger logger = LoggerFactory.getLogger(DataController.class);
	
	   @Autowired
	    private BodydetailServiceImpl bodydetailserviceimpl;
	   
	   @Autowired
	    private DiseaseServiceImpl diseaseserviceimpl;
	   /**
	    * <p>更新disease_info集合中的SID</p>
	    * @param request
	    * @param response
	    * @return
	    * @throws Exception
	    */
	   @RequestMapping(value = "/index", method = RequestMethod.GET)
		public void index(HttpServletRequest request, HttpServletResponse response) throws Exception {
		   String sid ="";
		 //--------------------step01 查询disease_info中所有数据------------------------------------
		 List<Map<String,Object>> dataList = diseaseserviceimpl.findallFromDiseaseinfo();
		 
		 //-------------------step02 遍历dataList，取出所有SICK_ID----------------------------------
		 for(int i=0; i < dataList.size(); i++) {
			String sick_id = (String) dataList.get(i).get("SICK_ID");
			logger.info("sick_id:" + sick_id);

			 sid = sick_id.substring(0, sick_id.length()-3);
			//logger.info("SID = " + sid);
			 
			//-----------------------step03 根据SICK_ID更新SID---------------------------------------
			Map<String,Object> map = new HashMap<String,Object>();
				map.put("whereStr", "SICK_ID");
				map.put("whereStrData", sick_id);
				map.put("updateStr", "SID");
				map.put("updateStrData", sid);
				Boolean updateFlag = diseaseserviceimpl.updatebyOne(map);
				logger.info("disease_info SID是否更新成功 : " + updateFlag);
		 	}
	   }
	   
	   /**
	    * <p>更新disease_info集合中的SNAME</p>
	    * @param request
	    * @param response
	    * @return
	    * @throws Exception
	    */
	   @RequestMapping(value = "/update_sname", method = RequestMethod.GET)
		public void updateSNAME(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 
		 //--------------------step01 查询disease_info中所有数据------------------------------------
		 List<Map<String,Object>> disdataList = diseaseserviceimpl.findallFromDiseaseinfo();
		 
		 //-------------------step02 遍历dataList，取出所有SICK_ID----------------------------------
		 for(int i=0; i < disdataList.size(); i++) {
			String sick_id = (String) disdataList.get(i).get("SICK_ID");
			logger.info("sick_id:" + sick_id);

			String sid = sick_id.substring(0, sick_id.length()-3);
		 
		 //-------------------step02 根据SID取出body_detail中sname----------------------------------
			Map<String,Object> reqmap = new HashMap<String,Object>();
			reqmap.put("whereStr","SID");
			reqmap.put("whereStrData",sid);
			List<Map<String,Object>> bodydataList = bodydetailserviceimpl.findByOne(reqmap);
			logger.info("bodydatalist:" + bodydataList);
			//取SNAME
			String SNAME = (String) bodydataList.get(0).get("SNAME");
			logger.info("Sname:" + SNAME);
		 
			//-----------------------step03 根据SICK_ID更新SNAME---------------------------------------
			Map<String,Object> map = new HashMap<String,Object>();
				map.put("whereStr", "SICK_ID");
				map.put("whereStrData", sick_id);
				map.put("updateStr", "SNAME");
				map.put("updateStrData", SNAME);
				Boolean updateFlag = diseaseserviceimpl.updatebyOne(map);
				logger.info("disease_info SNAME是否更新成功 : " + updateFlag);
		 		
		 	}
	   }
}
