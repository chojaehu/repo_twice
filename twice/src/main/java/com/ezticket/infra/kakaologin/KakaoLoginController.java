package com.ezticket.infra.kakaologin;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ezticket.infra.member.MemberDto;
import com.ezticket.infra.member.MemeberService;

import jakarta.servlet.http.HttpSession;

@Controller
public class KakaoLoginController {
	@Autowired
	private  KakaoLoginService service;
	
	@Autowired
	private MemeberService memeberService;
	
	
	@Value("${kakaologinkey}")
    private String kakaologinkey;
	
	@Value("${kakaologinurl}")
    private String kakaologinurl;
	
	/*
	 * @RequestMapping(value= "/kakaologin") public String kakaologin()throws
	 * Exception { System.out.println(kakaologinkey); StringBuffer url = new
	 * StringBuffer(); url.append("https://kauth.kakao.com/oauth/authorize?");
	 * url.append("client_id=" + kakaologinkey);
	 * url.append("&redirect_uri="+kakaologinurl);
	 * url.append("&response_type=code"); System.out.println(url);
	 * 
	 * return "redirect:" + url.toString(); }
	 */
	
	@RequestMapping(value="/kakaologin")
    public String loginKakaoRedirect(HttpSession httpSession,KakaoLoginDto dto, KakaoLoginDto isDto, Model model,MemberDto dto2) throws Exception {
    	System.out.println("dto.getCode()================"+dto.getCode());
		
    	

    	
    	// 토큰 받기 
    	String accessToken = service.getAccessTokenFromKakao(kakaologinkey, dto.getCode());
		
    	dto = service.getUserInfo(accessToken, dto);
    	System.out.println(dto.getEmail());  
        
        model.addAttribute("info", dto);
        
        
        
    	String id = dto.getEmail(); // 카카오 이메일 값
    	dto2.setMbEmail(id); // 카카오 이메일을 set으로 값을 담음
    	MemberDto dDto = memeberService.selectlogin(dto2); // db상에 데이터 있는지 확인
    	String loginurl = null; // 주소 값
    	if (dDto != null) {
    		
    		
    		if(id.equals(dDto.getMbEmail())) // db에 저장된 이메일과 동일 할경우 세션을 띄움
    		{
    			httpSession.setAttribute("sessSeqXdm", dDto.getMbSeq());
    			loginurl="/useIndex";
    		}
    	}
    	// 없을시 카카오 정보를 membersDB에 저장
    	else 
		{
			service.kakaoinsert(dto);
			loginurl="/useIndex";
		}
        
        
        return loginurl;
    }


}
