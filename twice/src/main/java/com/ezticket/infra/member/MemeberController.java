package com.ezticket.infra.member;

import java.util.HashMap;
import java.util.List;
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
	
	String mb = "xdm/infra/member/";

	// 로그인 페이지
	@RequestMapping(value = "/login")
	public String login() throws Exception {

		return "xdm/infra/index/login";
	}

	// 리스트 페이지
	@RequestMapping(value = "/memberXdmList")
	public String memberXdmList(@ModelAttribute("vo") MemeberVo vo, Model model, MemberDto dto) throws Exception {

		setSearch(vo);

		// dto.setMbEmail(encodeBcrypt(dto.getMbEmail(), 10));
		vo.setParamsPaging(service.count(vo));
		model.addAttribute("count", service.count(vo));

		if (vo.getTotalRows() > 0) {
			model.addAttribute("list", service.selectList(vo));
		}
		// System.out.println("dto.getMbPasswordCheck() : " + dto.getMbPasswordCheck());

		return mb +"memberXdmList";
	}

	// 수정페이지
	@RequestMapping(value = "/memberXdmForm")
	public String memberXdmForm(MemberDto dto, Model model) throws Exception {

		model.addAttribute("item", service.selectOne(dto));

		return mb+"memberXdmForm";
	}

	// 비밀번호 암호화
	@ResponseBody
	@RequestMapping(value = "/signinXdmProc")
	public Map<String, Object> signinXdmProc(MemberDto dto, HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();

		String pw = dto.getMbPassword();
		dto.setMbPassword(encodeBcrypt(dto.getMbPassword(), 10));

		dto.setMbPasswordCheck(encodeBcrypt(dto.getMbPasswordCheck(), 10));

		if (matchesBcrypt(pw, dto.getMbPasswordCheck(), 10)) {
			returnMap.put("rt", "success");
		} else {
			returnMap.put("rt", "false");
		}
		return returnMap;
	}

	// 둥록페이지
	@RequestMapping(value = "/memberXdmInst")
	public String memberXdmInst() throws Exception {
		return mb+"memberXdmInst";
	}

	// 회원 추가
	@RequestMapping(value = "/memberInsert")
	public String memberInsert(MemberDto dto) throws Exception {

		dto.setMbPassword(encodeBcrypt(dto.getMbPassword(), 10));

		service.insert(dto);
		// dto.setMbPassword(encodeBcrypt(dto.getMbPassword(), 10));

		System.out.println("dto.getMbPasswordCheck() : " + dto.getMbPasswordCheck());

		return "redirect:/memberXdmList";
	}

	// 화원 정보 삭제
	@RequestMapping(value = "/memberdelete")
	public String memberdelete(MemberDto dto) throws Exception {
		service.delete(dto);

		return "redirect:/memberXdmList";
	}

	// 회원 정보 deleteNY false
	@RequestMapping(value = "/memberupdatedelete")
	public String memberupdatedelete(MemberDto dto) throws Exception {
		service.updatedelete(dto);
		return "redirect:/memberXdmList";
	}

	/*
	 * @RequestParam("mbEmailchek") String mbEmailchek,
	 * 
	 * @RequestParam("mbPasswordCheck") String mbPasswordCheck,
	 */

	// 로그인 체크
	@ResponseBody
	@RequestMapping(value = "/loginchek")
	public Map<String, Object> loginchek(MemberDto dto, HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();

		MemberDto dDto = service.selectlogin(dto);

		if (dDto != null) {
			//dto.setMbPassword(encodeBcrypt(dto.getMbPassword(), 10));

			String id = dto.getMbEmail();
			String pw = dto.getMbPassword();

			//dDto.setMbPassword(encodeBcrypt(dDto.getMbPassword(), 10));

			System.out.println("dDto.getMbEmail() : " + id);
			System.out.println("dDto.getMbPassword() : " + pw);

			System.out.println("dDto.getMbEmail() : " + dDto.getMbEmail());
			System.out.println("dDto.getMbPassword() : " + dDto.getMbPassword());

			if (id.equals(dDto.getMbEmail())) {
				returnMap.put("rt", "success");
				System.out.println("true");

			} else {
				returnMap.put("rt", "id");
				System.out.println("false");
			}

			if (matchesBcrypt(pw, dDto.getMbPassword(), 10)) {
				httpSession.setMaxInactiveInterval(120 * Constants.SESSION_MINUTE_XDM); // 60second * 30 = 30minute
				httpSession.setAttribute("sessSeqXdm", dDto.getMbSeq());
				httpSession.setAttribute("sessNameXdm", dDto.getMbName());
				httpSession.setAttribute("sessIdXdm", dDto.getMbEmail());
				httpSession.setAttribute("sessPwXdm", dDto.getMbPassword());
				returnMap.put("rt", "success");
			} else {
				returnMap.put("rt", "pwfalse");
				System.out.println("false");
			}

		} else {
			returnMap.put("rt", "email");
		}

		return returnMap;
	}

	// 이메일 중복검사
	@ResponseBody
	@RequestMapping(value = "/emailChek")
	public Map<String, Object> emailChek(MemberDto dto, HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();

		List<MemberDto> list = service.emailChek();

		return returnMap;
	}

	// 로그 아웃
	@ResponseBody
	@RequestMapping(value = "/loginoutXdm")
	public Map<String, Object> loginoutXdm(MemberDto dto, HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();

		httpSession.invalidate();
		returnMap.put("rt", "success");

		return returnMap;
	}
	
	
	
	

//	유저 페이지
	private String str = "usr/index";
	private String str2 = "usr/modify";
	
	//	로그인 페이지
	@RequestMapping(value = "/useLogin")
	public String useLogin(@ModelAttribute("vo")MemeberVo vo) throws Exception {
		setSearch(vo);
		return str + "/useLogin";
	}
	
	//	회원 정보
	@RequestMapping(value = "/useModify")
	public String useModify(@ModelAttribute("vo")MemeberVo vo, Model model, HttpSession httpSession, MemberDto dto) throws Exception {
		
		
		setSearch(vo);
		dto.setMbSeq((String)httpSession.getAttribute("sessSeqXdm"));
		model.addAttribute("item", service.selectOne(dto));
		return str2 + "/useModify";
	}

	// 비밀번호 변경
	@RequestMapping(value = "/usePwModifying")
	public String usePwModifying(@ModelAttribute("vo")MemeberVo vo,Model model, MemberDto dto) throws Exception {
		
		setSearch(vo);
		return str2 + "/usePwModifying";
	}

	// 유저정보 업데이트
	@RequestMapping(value = "/useModifyUpdt")
	public String useModifyUpdt(@ModelAttribute("vo")MemeberVo vo,MemberDto dto, Model model) throws Exception {
		
		setSearch(vo);
		model.addAttribute("item", service.selectOne(dto));
		return str2 + "/useModifyUpdt";
	}
	
	@RequestMapping(value = "/useWithdrawal")
	public String useWithdrawal(@ModelAttribute("vo")MemeberVo vo) throws Exception {
		setSearch(vo);
		return str2 + "/useWithdrawal";
	}
	
	// 유저 업데이트
	@RequestMapping(value = "/usrUpdate")
	public String usrUpdate(@ModelAttribute("vo")MemeberVo vo,MemberDto dto,HttpSession httpSession) throws Exception
	{
		
		setSearch(vo);
		dto.setMbSeq((String)httpSession.getAttribute("sessSeqXdm"));
		
		service.usrUpdate(dto);
		return "redirect:/useModify";
	}
	
//	비밀번호 변경
	@ResponseBody
	@RequestMapping(value = "/newPassword")
	public Map<String, Object> newPassword(@ModelAttribute("dto") MemberDto dto , HttpSession httpSession) {
		
		dto.setMbSeq((String)httpSession.getAttribute("sessSeqXdm"));
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		MemberDto dtoPw = service.newPassword(dto); 
		System.out.println(dtoPw.getMbPassword()+"---------------------------");
		
		System.out.println(dto.getMbnewPassword()+"-----------------");
		System.out.println(dto.getMbPasswordCheck()+"--------------------------");
		if(matchesBcrypt(dto.getMbPassword(), dtoPw.getMbPassword(), 10))
		{
			if(dto.getMbnewPassword().equals(dto.getMbPasswordCheck()))
			{
				dto.setMbnewPassword(encodeBcrypt(dto.getMbnewPassword(), 10));
				service.newpwupdate(dto);
				returnMap.put("rt", "success");
			}
			else
			{
				returnMap.put("rt", "no");
			}
		}
		else
		{
			returnMap.put("rt", "existingPassword");
		}

	    return returnMap;
	}
	
	
	
	

	// 검색 기능
	public void setSearch(MemeberVo vo) throws Exception {
		/* 최초 화면 로딩시에 세팅은 문제가 없지만 */
		/* 이후 전체적으로 데이터를 조회를 하려면 null 값이 넘어 오는 관계로 문제가 전체 데이터 조회가 되지 못한다. */
		/* 해서 BaseVo.java 에서 기본값을 주어서 처리 */
//		vo.setShUseNy(vo.getShUseNy() == null ? 1 : vo.getShUseNy());
//		vo.setShDelNy(vo.getShDelNy() == null ? 0 : vo.getShDelNy());
//		vo.setShOptionDate(vo.getShOptionDate() == null ? 2 : vo.getShOptionDate());

		/* 초기값 세팅이 있는 경우 사용 */
		vo.setShDateStart(vo.getShDateStart() == null
				? UtilDateTime.calculateDayReplace00TimeString(UtilDateTime.nowLocalDateTime(), Constants.DATE_INTERVAL)
				: UtilDateTime.add00TimeString(vo.getShDateStart()));
		vo.setShDateEnd(
				vo.getShDateEnd() == null ? UtilDateTime.nowString() : UtilDateTime.add59TimeString(vo.getShDateEnd()));

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
