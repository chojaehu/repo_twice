package com.ezticket.infra.code;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ezticket.infra.codegroup.CodeGroupService;

@Controller
public class CodeController {
	
	@Autowired
	CodeService service;
	
	@Autowired
	CodeGroupService codeGroupService;
	
//	@RequestMapping(value = "/codeXdmList")
//	public String codeXdmList(Model model) throws Exception
//	{
//		model.addAttribute("list", service.selectList());
//		return "/xdm/infra/code/codeXdmList";
//	}
	@RequestMapping(value = "/codeView")
	public String codeView(Model model, CodeDto dto) throws Exception
	{
		model.addAttribute("item", service.selectOne(dto));
		return "/xdm/infra/code/codeView";
	}
	@RequestMapping(value = "/codeInsertRegistration")
	public String codeInsertRegistration() throws Exception
	{

		return "/xdm/infra/code/codeInsertRegistration";
	}
	@RequestMapping(value = "/codeReplacement")
	public String codeReplacement(Model model, CodeDto dto) throws Exception
	{
		model.addAttribute("item", service.selectOne(dto));
		return "/xdm/infra/code/codeReplacement";
	}
	
	
	
	
	@RequestMapping(value = "/codeInsert")
	public String codeInsert(Model model, CodeDto dto) throws Exception
	{
		service.insert(dto);
		return "redirect:/codeXdmList";
	}
	@RequestMapping(value = "/codeupdate")
	public String codeupdate(Model model, CodeDto dto) throws Exception
	{
		service.update(dto);
		return "redirect:/codeXdmList";
	}
	@RequestMapping(value = "/codedelect")
	public String codedelect(Model model, CodeDto dto) throws Exception
	{
		service.delete(dto);
		return "redirect:/codeXdmList";
	}
	
	@RequestMapping(value = "/updatedelete")
	public String updatedelete(Model model, CodeDto dto) throws Exception
	{
		service.updatedelete(dto);
		return "redirect:/codeXdmList";
	}
	
	
	
	
//	인덱스
	@RequestMapping(value = "/codeXdmList")
	public String codeXdmList(Model model, CodeVo vo, CodeDto dto) throws Exception {
		
		System.out.println(dto.getIfcgName());
		model.addAttribute("list", service.selectList(vo));
		
		model.addAttribute("vo", vo);
		
		return "/xdm/infra/index/codeXdmList";
	}
	
	@RequestMapping(value = "/codeXdmForm")
	public String codeXdmForm(CodeDto dto, Model model) throws Exception {
		
		model.addAttribute("listPaging", codeGroupService.selectListWithoutPaging());
		model.addAttribute("item", service.selectOne(dto));
		
		return "/xdm/infra/index/codeXdmForm";
	}
	@RequestMapping(value = "/codeXdmInst")
	public String codeXdmInst(CodeDto dto, Model model) throws Exception {
		
		
		return "/xdm/infra/index/codeXdmInst";
	}
	



}
