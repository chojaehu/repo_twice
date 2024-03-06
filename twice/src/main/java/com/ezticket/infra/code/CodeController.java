package com.ezticket.infra.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CodeController {
	
	@Autowired
	CodeService service;
	
	@RequestMapping(value = "/codeXdmList")
	public String codeXdmList(Model model) throws Exception
	{
		model.addAttribute("list", service.selectList());
		return "codeXdmList";
	}
	@RequestMapping(value = "/codeView")
	public String codeView(Model model, CodeDto dto) throws Exception
	{
		model.addAttribute("item", service.selectOne(dto));
		return "codeView";
	}
	@RequestMapping(value = "/codeInsertRegistration")
	public String codeInsertRegistration() throws Exception
	{

		return "codeInsertRegistration";
	}
	@RequestMapping(value = "/codeReplacement")
	public String codeReplacement(Model model, CodeDto dto) throws Exception
	{
		model.addAttribute("item", service.selectOne(dto));
		return "codeReplacement";
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
	


}
