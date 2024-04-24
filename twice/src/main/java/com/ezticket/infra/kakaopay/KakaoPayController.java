package com.ezticket.infra.kakaopay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    @RequestMapping(value="/kakaopay")
	public String kakaopay() {
    	System.out.println(".................................................... kakaopay");
        return "redirect:" + kakaoPayService.kakaoPayReady();
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

}
