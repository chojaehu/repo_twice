package com.ezticket.infra.kakaologin;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class KakaoLoginController {
	
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

		return "redirect:" + url.toString();
	}

}
