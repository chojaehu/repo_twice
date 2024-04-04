package com.ezticket.infra.usebook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ezticket.infra.performance.PerformanceDto;
import com.ezticket.infra.performance.PerformanceService;
import com.ezticket.infra.performance.PerformanceVo;

@Controller
public class BookController {
	
	
	
	@Autowired
	PerformanceService service;
	
	private String str3 = "/usr/book";
	
	// 예매 첫번째 페이지
	@RequestMapping(value = "/useBookOne")
	public String useBookOne(PerformanceVo vo , Model model) throws Exception
	{
		
		
		PerformanceDto dto = new PerformanceDto();
		//PerformanceDto dto = new PerformanceDto();
		// 공연관
		model.addAttribute("talist", service.tabookList(vo));
		
		
		
		// 공연 날짜 시간
		model.addAttribute("list", service.bookOneList(vo));
		
		return str3 + "/useBookOne";
	}
	
	
	// 예매 두번째 페이지 좌석 선택
	@RequestMapping(value = "/useBookTow")
	public String useBookTow() throws Exception
	{
		
		return str3 + "/useBookTow";
	}
	
	// 예매 3번째 페이지 결제
	@RequestMapping(value = "/useBookBuy")
	public String useBookBuy() throws Exception
	{
		
		return str3 + "/useBookBuy";
	}
	
	// 예매 최종 티켓 발행
	@RequestMapping(value = "/useBookfinal")
	public String useBookfinal() throws Exception
	{
		
		return str3 + "/useBookfinal";
	}

	
	
	
}
