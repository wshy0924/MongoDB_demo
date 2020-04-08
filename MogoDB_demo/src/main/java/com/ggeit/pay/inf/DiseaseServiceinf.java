package com.ggeit.pay.inf;

import java.util.List;
import java.util.Map;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ggeit.pay.entity.DiseaseInfo;

@Repository
public interface DiseaseServiceinf {

	void insert(Map<String,Object> map);
	List<Map<String,Object>> findallFromDiseaseinfo();
	List<Map<String,Object>> findByOne(Map<String, Object> reqmap);
	Boolean updatebyOne(Map<String,Object> map);
}

