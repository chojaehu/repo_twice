package com.ezticket.infra.member;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ezticket.common.constants.Constants;
import com.ezticket.common.util.UtilDateTime;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemeberController {
	
	@Autowired
	MemeberService service;
	
	@RequestMapping(value = "/memberXdmList")
	public String memberXdmList(@ModelAttribute("vo")MemeberVo vo, Model model,MemberDto dto)throws Exception {
		
		setSearch(vo);
		
		//dto.setMbEmail(encodeBcrypt(dto.getMbEmail(), 10));
		vo.setParamsPaging(service.count(vo));
		model.addAttribute("count", service.count(vo));
		
		
		if(vo.getTotalRows() > 0)
		{
			model.addAttribute("list", service.selectList(vo));
		}
		System.out.println("dto.getMbPasswordCheck() : " + dto.getMbPasswordCheck());
		
		return "/xdm/infra/member/memberXdmList";
	}
	@RequestMapping(value = "/memberXdmForm")
	public String memberXdmForm(MemberDto dto, Model model) throws Exception {
		
		model.addAttribute("item", service.selectOne(dto));
		
		return "/xdm/infra/index/memberXdmForm";
	}
	
	@ResponseBody
	@RequestMapping(value = "/signinXdmProc")
	public Map<String, Object> signinXdmProc(MemberDto dto, HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		
		String pw = dto.getMbPassword();
		dto.setMbPassword(encodeBcrypt(dto.getMbPassword(), 10));
		
		dto.setMbPasswordCheck(encodeBcrypt(dto.getMbPasswordCheck(), 10));
		
		if(matchesBcrypt(pw, dto.getMbPasswordCheck(),10)) {
			returnMap.put("rt", "success");
		} else {
			returnMap.put("rt", "false");
		}
		return returnMap;
	}
	
	@RequestMapping(value = "/memberXdmInst")
	public String memberXdmInst() throws Exception{
		return "/xdm/infra/member/memberXdmInst";
	}
	
	@RequestMapping(value = "/memberInsert")
	public String memberInsert(MemberDto dto) throws Exception {
		
		
		dto.setMbPassword(encodeBcrypt(dto.getMbPassword(), 10));
		
		service.insert(dto);
		//dto.setMbPassword(encodeBcrypt(dto.getMbPassword(), 10));
		
		System.out.println("dto.getMbPasswordCheck() : " + dto.getMbPasswordCheck());

		return "redirect:/memberXdmList";
	}
	
	@RequestMapping(value = "/login")
	public String login() throws Exception {
		

		return "/xdm/infra/index/login";
	}
	
	@ResponseBody
	@RequestMapping(value = "/loginchek")
	public Map<String, Object> loginchek(MemberDto dto, HttpSession httpSession,MemeberVo vo ,Model model) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		String aa = "";
		
		String id = dto.getMbEmail();
		String pw = dto.getMbPassword();
		MemberDto dDto = service.selectlogin(dto);
		
		if(dto.getMbEmail().equals(dDto.getMbEmailchek())) {
			returnMap.put("rt", "success");
			System.out.println("true");
		} else {
			returnMap.put("rt", "id");
			System.out.println("false");
		}
		
		 if(matchesBcrypt(pw, dto.getMbPasswordCheck(), 10)) { 
			 returnMap.put("rt","success"); 
			 } 
		 else { 
			 returnMap.put("rt", "pwfalse"); 
			 }
		 
		return returnMap;
	}

	
	
	public void setSearch(MemeberVo vo) throws Exception {
		/* 최초 화면 로딩시에 세팅은 문제가 없지만 */
		/*이후 전체적으로 데이터를 조회를 하려면 null 값이 넘어 오는 관계로 문제가 전체 데이터 조회가 되지 못한다.*/
		/*해서 BaseVo.java 에서 기본값을 주어서 처리*/
//		vo.setShUseNy(vo.getShUseNy() == null ? 1 : vo.getShUseNy());
//		vo.setShDelNy(vo.getShDelNy() == null ? 0 : vo.getShDelNy());
//		vo.setShOptionDate(vo.getShOptionDate() == null ? 2 : vo.getShOptionDate());
		
		/* 초기값 세팅이 있는 경우 사용 */
		vo.setShDateStart(vo.getShDateStart() == null
		    ? UtilDateTime.calculateDayReplace00TimeString(UtilDateTime.nowLocalDateTime(), Constants.DATE_INTERVAL)
		    : UtilDateTime.add00TimeString(vo.getShDateStart()));
		vo.setShDateEnd(vo.getShDateEnd() == null
		    ? UtilDateTime.nowString()
		    : UtilDateTime.add59TimeString(vo.getShDateEnd()));		
		
//		/* 초기값 세팅이 없는 경우 사용 */
//		vo.setShDateStart(vo.getShDateStart() == null || vo.getShDateStart() == "" ? null : UtilDateTime.add00TimeString(vo.getShDateStart()));
//		vo.setShDateEnd(vo.getShDateEnd() == null || vo.getShDateEnd() == "" ? null : UtilDateTime.add59TimeString(vo.getShDateEnd()));
		
		
	}
	public String encodeBcrypt(String planeText, int strength) {
		  return new BCryptPasswordEncoder(strength).encode(planeText);
	}

			
	public boolean matchesBcrypt(String planeText, String hashValue, int strength) {
	  BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(strength);
	  return passwordEncoder.matches(planeText, hashValue);
	}

}
