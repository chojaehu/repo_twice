package com.ezticket.infra.kakaopay;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ezticket.infra.performance.PerformanceDto;
import com.ezticket.infra.performance.PerformanceService;

import jakarta.servlet.http.HttpSession;

@Controller
public class KakaoPayController {
	
	@Autowired
	KakaoPayService kakaoPayService;
	
	@Autowired
	PerformanceService service;
	
	
	// 결제화면
    @RequestMapping(value="/kakao")
	public String kakao() {
    	return "kakaopay/kakaoPay";
    }

    // 결제요청
    @ResponseBody
    @RequestMapping(value="/kakaopay")
	public  Map<String, Object>  kakaopay(KakaoPayDto kakaoPayDto,PerformanceDto dto,HttpSession httpSession,RedirectAttributes redirectAttributes ) {
    	Map<String, Object> returnMap = new HashMap<String, Object>();
    	dto.setMbSeq((String)httpSession.getAttribute("sessSeqXdm"));
    	returnMap.put("rt", kakaoPayService.kakaoPayReady(dto));
    	System.out.println(".................................................... kakaopay");
    	
    	
    	
        return returnMap;
	}
    //결제 정
    @RequestMapping(value="/kakaoPaySuccess")
    public String kakaoPaySuccess(@RequestParam("pg_token")String pg_token, Model model, HttpSession httpSession,RedirectAttributes redirectAttributes,PerformanceDto dto) {
    	
    	
    	
    	dto.setMbSeq((String)httpSession.getAttribute("sessSeqXdm"));
		System.out.println(dto.getMbSeq());
		System.out.println(dto.getSeat());
		
		
		
		service.kakaopayinsert(dto);
		service.payseatinsert(dto);	
		service.payseatupdate(dto);
		
		System.out.println(pg_token +"-----------------------------------------------------------------");
		redirectAttributes.addAttribute("pmSeq", dto.getPmSeq());
		redirectAttributes.addFlashAttribute("pg_token", kakaoPayService.kakaoPayInfo(pg_token, httpSession,dto));
    	
    	return "redirect:/useBookfinal";
    }  
	  
	/*public String kakaoPaySuccess(@RequestParam("pg_token")String pg_token, Model model,HttpSession httpSession)
	{
		model.addAttribute("kakao", httpSession)
		return 
	}*/
    //카카오페이 취소
    @RequestMapping(value="/kakaopayCancel")
	public String kakaopayCancel(Model model, HttpSession httpSession ) {
    	System.out.println(".................................................... kakaopayCancel");
    	String sessTidString = (String) httpSession.getAttribute("sessTid");
    	if(sessTidString != null) {
    		model.addAttribute("info", kakaoPayService.kakaoPayCancel(httpSession));

    		// 세션삭제
        	httpSession.removeAttribute("sessTid");
        	httpSession.removeAttribute("sessTotal");
        	httpSession.removeAttribute("sessTaxFree");
        	httpSession.removeAttribute("sessVat");
        	
        	return "kakaopay/kakaopayCancelSuccess"; 
    	} else {
    		return "redirect:/kakao"; 
    	}
	}

}
