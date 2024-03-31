package com.ezticket.infra.usr.performancelist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PrfrmController {
	
	@Autowired
	PrfrmService service;
	
	private String str = "/usr/list";
	
	@RequestMapping(value = "/usePerformanceList")
	public String usePerformanceList() {
		
		return str + "/usePerformanceList";
	}
	
	@RequestMapping(value = "/usePerformanceArea")
	public String usePerformanceArea() {
		
		return str + "/usePerformanceArea";
	}
	
	@RequestMapping(value = "/usePerformanceRanking")
	public String usePerformanceRanking() {
		
		return str + "/usePerformanceRanking";
	}
	
	@RequestMapping(value = "/usePerformancepage")
	public String usePerformancepage() {
		
		return str + "/usePerformancepage";
	}


}
