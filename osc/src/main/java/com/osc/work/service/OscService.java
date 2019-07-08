package com.osc.work.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.osc.work.mapper.OscMapper;
import com.osc.work.model.OscModel;

@Service("oscService")
public class OscService {

	@Autowired
    private OscMapper oscMapper;
	
	public List<OscModel> selectTestList(OscModel param) throws Exception {
		return oscMapper.selectTestList(param);
	}
	
	@Transactional
	public int testInsert(OscModel param) throws Exception {
		return oscMapper.testInsert(param);
	}
	
	public OscModel testDetail(OscModel param) throws Exception {
		return oscMapper.testDetail(param);
	}
	
	@Transactional
	public int testUpdate(OscModel param) throws Exception {
		return oscMapper.testUpdate(param);
	}
	
	public List<OscModel> selectTestExcelList(OscModel param) throws Exception {
		return oscMapper.selectTestExcelList(param);
	}

}
