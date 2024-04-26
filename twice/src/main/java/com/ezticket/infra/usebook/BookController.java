package com.ezticket.infra.usebook;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		
		//System.out.println("vo.getShprDate()"+vo.getShprDate());
		
		// 공연관
		model.addAttribute("talist", service.tabookList(vo));

		// 공연 날짜 시간
		model.addAttribute("list", service.bookOneList(vo));
		
		return str3 + "/useBookOne";
		
	}
	
	
	// 예매 두번째 페이지 좌석 선택
	@RequestMapping(value = "/useBookTow")
	public String useBookTow(PerformanceDto dto,Model model) throws Exception
	{
		
		model.addAttribute("list", service.bookseatList(dto));
		return str3 + "/useBookTow";
	}
	
	// 예매 3번째 페이지 결제
	@RequestMapping(value = "/useBookBuy")
	public String useBookBuy(PerformanceDto dto, Model model,PerformanceVo vo) throws Exception
	{
		
		System.out.println(dto.getSeat());
		/*
		 * List<String> list = new ArrayList<>(); list.addAll(dto.getSeat());
		 */
		
		//vo.setParamsPaging(service.Paymentcount(dto));
		//model.addAttribute("paycount", service.Paymentcount(dto));
		model.addAttribute("paysum", service.Paymentsum(dto));
		model.addAttribute("list", service.Paymentlist(dto));
		
		
		System.out.println(dto.getPaytotalcount());
		
		
		
		
		return str3 + "/useBookBuy";
	}
	
	// 예매 최종 티켓 발행
	@RequestMapping(value = "/useBookfinal")
	public String useBookfinal(@RequestParam("pmSeq") String aa, Model model,PerformanceDto dto) throws Exception
	{
		System.out.println(aa + "--------------------------");
		model.addAttribute("item", service.ticketfianl(dto));
		model.addAttribute("list", service.ticketfianlseat(dto));
		return str3 + "/useBookfinal";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/bookDate")
	public Map<String, Object> bookDate(@RequestParam("shprDate") String da, PerformanceVo vo, Model model, PerformanceDto dto) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		vo.setShpreDate(da);
		
		List<PerformanceDto> dto2 = new ArrayList<>();
		dto2 = service.taselectOne(vo);

		
		//System.out.println("asasasasasas"+dto2.getPdselectionDate());
		if(dto2.isEmpty())
		{
			returnMap.put("rt", "false"); 
		}
		else
		{
			returnMap.put("talist", service.tabookList(vo)); 
			returnMap.put("list",service.bookOneList(vo)); 
			returnMap.put("rt", "success"); 
		}
	
		return returnMap;
	}
	
	@RequestMapping(value = "/payseatupdate")
	public String payseatupdate(PerformanceDto dto,HttpSession httpSession,RedirectAttributes redirectAttributes) throws Exception
	{
		dto.setMbSeq((String)httpSession.getAttribute("sessSeqXdm"));
		System.out.println(dto.getMbSeq());
		System.out.println(dto.getSeat());
		
		
		
		service.payinsert(dto);
		service.payseatinsert(dto);	
		service.payseatupdate(dto);
		redirectAttributes.addAttribute("pmSeq", dto.getPmSeq());
		return "redirect:/useBookfinal";
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
