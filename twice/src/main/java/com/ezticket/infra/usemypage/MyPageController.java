package com.ezticket.infra.usemypage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ezticket.common.constants.Constants;
import com.ezticket.common.util.UtilDateTime;
import com.ezticket.infra.performance.PerformanceService;
import com.ezticket.infra.performance.PerformanceVo;

import jakarta.servlet.http.HttpSession;

@Controller
public class MyPageController {

	
	@Autowired
	PerformanceService service;

	private String str2 = "/usr/list";
	@RequestMapping(value = "/useInformation")
	public String useModify(@ModelAttribute("vo")PerformanceVo vo, Model model, HttpSession httpSession) throws Exception {
		
		setSearch(vo);
		vo.setPrSeq((String) httpSession.getAttribute("sessSeqXdm"));
																					
		vo.setParamsPaging(service.usescount(vo));
		model.addAttribute("list", service.usrselectPay(vo));
		model.addAttribute("seat", service.usrseatPay(vo));

		return str2 + "/useInformation";
	}
	
	@RequestMapping(value = "/ticketdelete")
	public String ticketdelete(PerformanceVo vo) throws Exception
	{
		service.selectList(vo);
		return "redirect:/usePerformanceList";
	}
	
	
	
	
	public void setSearch(PerformanceVo vo) throws Exception {

		
		/* 초기값 세팅이 있는 경우 사용 */
		vo.setShDateStart(vo.getShDateStart() == null
		    ? UtilDateTime.calculateDayReplace00TimeString(UtilDateTime.nowLocalDateTime(), Constants.DATE_INTERVAL)
		    : UtilDateTime.add00TimeString(vo.getShDateStart()));
		vo.setShDateEnd(vo.getShDateEnd() == null
		    ? UtilDateTime.nowString()
		    : UtilDateTime.add59TimeString(vo.getShDateEnd()));		
	}
	

}
