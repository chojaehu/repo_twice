package com.ezticket.infra.kakaologin;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class KakaoLoginController {
	@Autowired
	private  KakaoLoginService service;
	
	
	@Value("${kakaologinkey}")
    private String kakaologinkey;
	
	@Value("${kakaologinurl}")
    private String kakaologinurl;
	
	@RequestMapping(value= "/kakaologin")
	public String kakaologin()throws Exception
	{
		System.out.println(kakaologinkey);
		StringBuffer url = new StringBuffer();
		url.append("https://kauth.kakao.com/oauth/authorize?");
		url.append("client_id=" + kakaologinkey);
		url.append("&redirect_uri="+kakaologinurl);
		url.append("&response_type=code");
		System.out.println(url);

		return "redirect:" + url.toString();
	}
	@RequestMapping(value="/redirectKakao")
    public String loginKakaoRedirect(KakaoLoginDto dto, KakaoLoginDto isDto, Model model) throws Exception {
    	System.out.println("dto.getCode()================"+dto.getCode());
		
    	// 토큰 받기 
    	String accessToken = service.getAccessTokenFromKakao(kakaologinkey, dto.getCode());
		
    	dto = service.getUserInfo(accessToken, dto);
		  
        
        model.addAttribute("info", dto);
        
        return "usr/kakaologin/kakaoLoginCallBack";
    }


}
