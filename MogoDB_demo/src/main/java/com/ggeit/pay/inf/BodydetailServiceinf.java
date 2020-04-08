package com.ggeit.pay.inf;

import java.util.List;
import java.util.Map;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ggeit.pay.entity.DiseaseInfo;

@Repository
public interface BodydetailServiceinf {

	List<Map<String, Object>>  findByOne(Map<String, Object> reqmap);
	List<Map<String,Object>> findallFromBodydetail();
}

