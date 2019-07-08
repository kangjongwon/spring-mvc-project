package com.osc.work.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.osc.work.common.model.ResultModel;
import com.osc.work.model.OscModel;
import com.osc.work.service.OscService;
/**
 * Handles requests for the application home page.
 */
@Controller
public class OscController {
	
	private static final Logger logger = LoggerFactory.getLogger(OscController.class);

	/**
	 * TEST CLASS
	 * @author jongwon
	 * @version 1.0
	 * 
	 */

	@Controller
	@RequestMapping(value = "/test")
	public class TestController {

		@Autowired
	    private OscService oscService;
	    
	    /**
	     * Test List
	     * @author jongwon
	     * @return 
	     */
	    @RequestMapping(value="/testList")
	    public String testList(OscModel param, Model model){
	    	logger.info("osc List");
	    	
	    	try {
		    	Map<String, Object> resultObject = new HashMap<String, Object>();
				List<OscModel> testList = null;
		         
		        testList = oscService.selectTestList(param);
		        resultObject.put("testList" , testList);
		        
		        model.addAttribute("resultData", resultObject);
	    	}catch(Exception ex) {
	    		ex.printStackTrace();
	    	}
	        return "/test/testList";
	    }
	    
	    /**
	     * Test Insert
	     * @author jongwon
	     * @param param
	     * @return
	     */
	    @RequestMapping(value="/testInsert", method = RequestMethod.POST)
	    @ResponseBody
	    public ResultModel testInsert(@RequestBody OscModel param){
	    	logger.info("INSERT REQUEST PARAM : "+ param.toString());
	    	
	    	ResultModel result = new ResultModel();
	    	boolean ref = false;
	    	try {
	    		oscService.testInsert(param);
	    		ref = true;
	    	}catch(Exception ex) {
	    		ex.printStackTrace();
	    	}
	    	result.setSuccess(ref);
	    	
	        return result;
	    }
	    
	    /**
	     * Test Detail
	     * @author jongwon
	     * @param tempNo
	     * @return
	     */
	    @RequestMapping(value="/testDetail/{id}", method = RequestMethod.GET)
	    public String testDetail(@PathVariable int id, Model model){
	    	logger.info("test List");
	    	
	    	try {
	    		OscModel param = new OscModel();
	    		param.setId(id);
	    		OscModel testDetail = oscService.testDetail(param);
	    		
	    		model.addAttribute("resultData", testDetail);
	    	
	    	}catch(Exception ex) {
	    		ex.printStackTrace();
	    	}
	        return "/test/testDetail";
	    }
	    
	    /**
	     * Test Update
	     * @author jongwon
	     * @param param
	     * @return
	     */
	    @RequestMapping(value="/testUpdate", method = RequestMethod.POST)
	    @ResponseBody
	    public ResultModel testUpdate(@RequestBody OscModel param){
	    	logger.info("INSERT REQUEST PARAM : "+ param.toString());
	    	
	    	ResultModel result = new ResultModel();
	    	boolean ref = false;
	    	try {
	    		oscService.testUpdate(param);
	    		ref = true;
	    	}catch(Exception ex) {
	    		ex.printStackTrace();
	    	}
	    	result.setSuccess(ref);
	    	
	        return result;
	    }
	    
	}
}
