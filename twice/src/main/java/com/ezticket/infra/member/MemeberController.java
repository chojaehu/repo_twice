package com.ezticket.infra.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemeberController {
	
	@Autowired
	MemeberService service;
	
	@RequestMapping(value = "/memberXdmList")
	public String memberXdmList(Model model)throws Exception {
		model.addAttribute(null, model);
		return "/xdm/infra/member/memberXdmList";
	}

}
