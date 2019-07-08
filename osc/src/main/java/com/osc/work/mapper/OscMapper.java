package com.osc.work.mapper;

import java.util.List;

import com.osc.work.model.OscModel;

public interface OscMapper {
	
	public List<OscModel> selectTestList(OscModel param);
	
	public int testInsert(OscModel param);
	
	public OscModel testDetail(OscModel param);
	
	public int testUpdate(OscModel param);
	
	public List<OscModel> selectTestExcelList(OscModel param);

}
