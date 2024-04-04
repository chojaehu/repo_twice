package com.ezticket.infra.usemypage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ezticket.infra.performance.PerformanceService;
import com.ezticket.infra.performance.PerformanceVo;

import jakarta.servlet.http.HttpSession;

@Controller
public class MyPageController {

	
	@Autowired
	PerformanceService service;

	private String str2 = "/usr/list";
	@RequestMapping(value = "/useInformation")
	public String useModify(PerformanceVo vo, Model model, HttpSession httpSession) throws Exception {
		
		
		vo.setPrSeq((String) httpSession.getAttribute("sessSeqXdm"));
		model.addAttribute("list", service.usrselectPay(vo));

		return str2 + "/useInformation";
	}
	

}
