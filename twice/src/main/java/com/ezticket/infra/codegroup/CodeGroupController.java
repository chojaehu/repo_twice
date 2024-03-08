package com.ezticket.infra.codegroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CodeGroupController {

	@Autowired
	CodeGroupService service;

//	@RequestMapping(value = "/codeGroupXdmList")
//	public String codeGroupXdmList(Model model) throws Exception {
//
//		model.addAttribute("list", service.selectList());
////		List<CodeGroupDto> CodeGroupDtos = service.selectList();
////		
////		for(CodeGroupDto a : CodeGroupDtos)
////		{
////			System.out.println(a.getGroupname());
////		}
//		return "/xdm/infra/codegroup/codeGroupXdmList";
//	}

	@RequestMapping(value = "/codeGroupView")
	public String codeGroupView(CodeGroupDto dto, Model model) throws Exception {
//		System.out.println("dto.getNumber():"+dto.getNumber());
//		System.out.println("getGroupname:"+dto.getGroupname());
//		System.out.println("dto.getDeleteNY():"+dto.getDeleteNY());

		model.addAttribute("item", service.selectOne(dto));
		return "/xdm/infra/codegroup/codeGroupView";
	}

	@RequestMapping(value = "/Replacement")
	public String Replacement(CodeGroupDto dto, Model model) throws Exception {

		model.addAttribute("item", service.selectOne(dto));
		return "/xdm/infra/codegroup/Replacement";
	}
	
	@RequestMapping(value = "/Registration")
	public String Registration() throws Exception {
		

		return "/xdm/infra/codegroup/Registration";
	}
	@RequestMapping(value = "/codeGroupInsert")
	public String codeGroupInsert(CodeGroupDto dto) throws Exception {
//		System.out.println("dto.getGroupname() : "+dto.getGroupname());
//		System.out.println("dto.getGroupname() : "+dto.getDeleteNY());
		service.insert(dto);

		return "redirect:/codeGroupXdmList";
	}
	
	
	@RequestMapping(value = "/codeGroupupdate")
	public String codeGroupupdate(CodeGroupDto dto) throws Exception {
		
		service.update(dto);

		return "redirect:/codeGroupXdmList";
	}
	@RequestMapping(value = "/codeGroupupdatedelete")
	public String codeGroupupdatedelete(CodeGroupDto dto) throws Exception {
		
		service.updatedelete(dto);

		return "redirect:/codeGroupXdmList";
	}
	@RequestMapping(value = "/codeGroupdelete")
		public String codeGroupdelete(CodeGroupDto dto) throws Exception {
		
		service.delete(dto);

		return "redirect:/codeGroupXdmList";
	}
	
	
	
	
	
//	인덱스
	@RequestMapping(value = "/indexs")
	public String indexs() throws Exception {
		

		return "/xdm/infra/index/indexs";
	}
	
	@RequestMapping(value = "/forgotpassword")
	public String forgotpassword() throws Exception {
		

		return "/xdm/infra/index/forgotpassword";
	}
	
	@RequestMapping(value = "/codeGroupXdmForm")
	public String codeGroupXdmForm(CodeGroupDto dto, Model model) throws Exception {
		
		model.addAttribute("item", service.selectOne(dto));
		
		return "/xdm/infra/index/codeGroupXdmForm";
	}
	
	@RequestMapping(value = "/codeGroupXdmInst")
	public String codeGroupXdmInst(CodeGroupDto dto, Model model) throws Exception {
		
		
		return "/xdm/infra/index/codeGroupXdmInst";
	}
	
	@RequestMapping(value = "/login")
	public String login() throws Exception {
		

		return "/xdm/infra/index/login";
	}
	
	@RequestMapping(value = "/signup")
	public String signup() throws Exception {
		

		return "/xdm/infra/index/signup";
	}
	
	@RequestMapping(value = "/codeGroupXdmList")
	public String codeGroupXdmList(Model model,CodeGroupDto dto) throws Exception {
		
		model.addAttribute("list", service.selectList());
		
		return "/xdm/infra/index/codeGroupXdmList";
	}
	
	@RequestMapping(value = "/waring")
	public String waring() throws Exception {
		

		return "/xdm/infra/index/waring";
	}
	
	@RequestMapping(value = "/indexinsert")
	public String indexinsert(CodeGroupDto dto) throws Exception {
		
		service.insert(dto);

		return "redirect:/codeGroupXdmList";
	}
	
	@RequestMapping(value = "/indexdelete")
	public String indexdelete(CodeGroupDto dto) throws Exception {
		
		service.delete(dto);

		return "redirect:/codeGroupXdmList";
	}
	
	@RequestMapping(value = "/indexupdatedelete")
	public String indexupdatedelete(CodeGroupDto dto) throws Exception {
		
		service.updatedelete(dto);

		return "redirect:/codeGroupXdmList";
	}
	
	@RequestMapping(value = "/indexupdate")
	public String indexupdate(CodeGroupDto dto) throws Exception {
		
		service.update(dto);

		return "redirect:/codeGroupXdmList";
	}

	
	


}
