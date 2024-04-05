package com.ezticket.infra.usebook;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ezticket.common.constants.Constants;
import com.ezticket.common.util.UtilDateTime;
import com.ezticket.infra.member.MemberDto;
import com.ezticket.infra.performance.PerformanceDto;
import com.ezticket.infra.performance.PerformanceService;
import com.ezticket.infra.performance.PerformanceVo;

import jakarta.servlet.http.HttpSession;

@Controller
public class BookController {
	
	
	
	@Autowired
	PerformanceService service;
	
	private String str3 = "/usr/book";
	
	// 예매 첫번째 페이지
	@RequestMapping(value = "/useBookOne")
	public String useBookOne(@ModelAttribute("vo")PerformanceVo vo , Model model,PerformanceDto dto) throws Exception
	{
		
		setSearch(vo);

		
		
		PerformanceDto date = new PerformanceDto();
		date = service.bookdate(dto);
		
		
		String str = date.getPrStartDate();
		vo.setShpreDate(str);
		
		
		model.addAttribute("item", service.bookdate(dto));
		
		System.out.println("vo.getShprDate()"+vo.getShprDate());
		
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
	
	
	@ResponseBody
	@RequestMapping(value = "/bookDate")
	public Map<String, Object> bookDate(@RequestParam("shprDate") String da, PerformanceDto dto, HttpSession httpSession, PerformanceVo vo, Model model) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		//vo.setShpreDate(da);
		
		if(da != null )
		{
			
			vo.setShpreDate(da);
			model.addAttribute("talist",service.tabookList(vo));
			model.addAttribute("list", service.bookOneList(vo));
			returnMap.put("rt", "success");
		}
		
		/*
		 * service.tabookList(vo); service.bookOneList(vo);
		 */
	

		return returnMap;
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
