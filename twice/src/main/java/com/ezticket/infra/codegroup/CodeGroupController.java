package com.ezticket.infra.codegroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CodeGroupController {

	@Autowired
	CodeGroupService service;

	@RequestMapping(value = "/codeGroupXdmList")
	public String codeGroupXdmList(Model model) throws Exception {

		model.addAttribute("list", service.selectList());
//		List<CodeGroupDto> CodeGroupDtos = service.selectList();
//		
//		for(CodeGroupDto a : CodeGroupDtos)
//		{
//			System.out.println(a.getGroupname());
//		}
		return "codeGroupXdmList";
	}

	@RequestMapping(value = "/codeGroupView")
	public String codeGroupView(CodeGroupDto dto, Model model) throws Exception {
//		System.out.println("dto.getNumber():"+dto.getNumber());
//		System.out.println("getGroupname:"+dto.getGroupname());
//		System.out.println("dto.getDeleteNY():"+dto.getDeleteNY());

		model.addAttribute("item", service.selectOne(dto));
		return "codeGroupView";
	}

	@RequestMapping(value = "/Replacement")
	public String Replacement(CodeGroupDto dto, Model model) throws Exception {

		model.addAttribute("item", service.selectOne(dto));
		return "Replacement";
	}
	
	@RequestMapping(value = "/Registration")
	public String Registration() throws Exception {
		

		return "Registration";
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

}
