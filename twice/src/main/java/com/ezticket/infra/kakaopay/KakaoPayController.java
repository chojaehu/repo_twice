package com.ezticket.infra.kakaopay;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ezticket.infra.performance.PerformanceDto;

import jakarta.servlet.http.HttpSession;

@Controller
public class KakaoPayController {
	
	@Autowired
	KakaoPayService kakaoPayService;
	
	
	// 결제화면
    @RequestMapping(value="/kakao")
	public String kakao() {
    	return "kakaopay/kakaoPay";
    }

    // 결제요청
    @ResponseBody
    @RequestMapping(value="/kakaopay")
	public  Map<String, Object>  kakaopay(KakaoPayDto kakaoPayDto,PerformanceDto dto,HttpSession httpSession ) {
    	Map<String, Object> returnMap = new HashMap<String, Object>();
    	dto.setMbSeq((String)httpSession.getAttribute("sessSeqXdm"));
    	returnMap.put("rt", kakaoPayService.kakaoPayReady(dto));
    	System.out.println(".................................................... kakaopay");
    	
        return returnMap;
	}
    //결제 정
    @RequestMapping(value="/kakaoPaySuccess")
    public String kakaoPaySuccess(@RequestParam("pg_token")String pg_token, Model model, HttpSession httpSession) {
    	model.addAttribute("info", kakaoPayService.kakaoPayInfo(pg_token, httpSession));
    	return "kakaopay/kakaoPaySuccess";
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
