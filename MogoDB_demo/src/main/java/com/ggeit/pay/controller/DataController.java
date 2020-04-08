package com.ggeit.pay.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ggeit.pay.entity.DiseaseInfo;
import com.ggeit.pay.impl.DiseaseServiceImpl;
import com.ggeit.pay.utils.GGitUtil;
import com.ggeit.pay.utils.JsonUtils;



@RestController
@RequestMapping("/diseaseinfo")

// 支持返回页面只能使用@Controller、不能使用@RestController
public class DataController {

	private final static Logger logger = LoggerFactory.getLogger(DataController.class);
	
	   @Autowired
	    private DiseaseServiceImpl diseaseserviceimpl;

//	/**
//	 *测试mongodb
//	 * 
//	 * @param request
//	 * @param response
//	 * @throws Exception
//	 */
//	@RequestMapping(value = "/insert", method = RequestMethod.GET)
//	public void index(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		diseaseserviceimpl.insert();
//		logger.info("插入成功！");
//        }
	
	/**
	 * MongoDB findall
	 * @param req
	 * @param resp
	 */
	@RequestMapping(value = "/findall", method = RequestMethod.GET)
	public void findall(HttpServletRequest req,HttpResponse resp) {
		List<Map<String,Object>> str = diseaseserviceimpl.findallFromDiseaseinfo();
		//查出来的数据要转成json格式，不然会显示错误
		logger.info("查询成功：" + str);
	}
	
	/**
	 * MongoDB findbysid
	 * @param req
	 * @param resp
	 */
	@RequestMapping(value = "/findbysid", method = RequestMethod.GET)
	public Map<String,Object> findbysid(HttpServletRequest req,HttpResponse resp) {
		Map<String,Object> reqmap = new HashMap<String,Object>();
		reqmap.put("whereStr", "SICK_ID");
		reqmap.put("updataStr", "head01001");
		List<Map<String,Object>> listdata = diseaseserviceimpl.findByOne(reqmap);
		Map<String,Object> resultmap = listdata.get(0);
		//查出来的数据要转成json格式，不然会显示错误
		logger.info("查询成功：" + resultmap);
		return resultmap;
	}
	
}