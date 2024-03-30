package com.ezticket.infra.code;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ezticket.common.constants.Constants;
import com.ezticket.common.util.UtilDateTime;
import com.ezticket.infra.codegroup.CodeGroupService;
import com.ezticket.infra.codegroup.CodeGroupVo;

import jakarta.annotation.PostConstruct;

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
	/*
	 * @RequestMapping(value = "/codeView") public String codeView(Model model,
	 * CodeDto dto) throws Exception { model.addAttribute("item",
	 * service.selectOne(dto)); return "/xdm/infra/code/codeView"; }
	 * 
	 * @RequestMapping(value = "/codeInsertRegistration") public String
	 * codeInsertRegistration() throws Exception {
	 * 
	 * return "/xdm/infra/code/codeInsertRegistration"; }
	 * 
	 * @RequestMapping(value = "/codeReplacement") public String
	 * codeReplacement(Model model, CodeDto dto) throws Exception {
	 * model.addAttribute("item", service.selectOne(dto)); return
	 * "/xdm/infra/code/codeReplacement"; }
	 */
	
	
	
	
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
	
	
	
	//@ModelAttribute("vo")CodeDto dto,
//	인덱스
	@RequestMapping(value = "/codeXdmList")
	public String codeXdmList(@ModelAttribute("vo")CodeVo vo, Model model) throws Exception {
		setSearch(vo);
		
		vo.setParamsPaging(service.count(vo));
		
		model.addAttribute("count", service.count(vo));
		if(vo.getTotalRows()>0)
		{
			model.addAttribute("list", service.selectList(vo));		
		}	
		
		/*
		 * System.out.println("vo.getPagination().getTotalPageCount()" +
		 * vo.getPagination().getTotalPageCount());
		 * System.out.println("vo.getPagination().getEndPage() :" +
		 * vo.getPagination().getEndPage());
		 * System.out.println("vo.getPagination().getStartPage() :" +
		 * vo.getPagination().getStartPage());
		 * System.out.println("vo.getPagination().getStartPage() :" +
		 * vo.getPagination().getLimitStart());
		 * System.out.println("vo.getPagination().getStartPage() :" +
		 * vo.getPagination().getTotalPageCount());
		 */
		 
		model.addAttribute("list", service.selectList(vo));
		
		
		//model.addAttribute("vo", vo);
		
		return "/xdm/infra/code/codeXdmList";
	}
	
	@RequestMapping(value = "/codeXdmForm")
	public String codeXdmForm(CodeDto dto, Model model) throws Exception {
		
		
		model.addAttribute("item", service.selectOne(dto));
		
		return "/xdm/infra/code/codeXdmForm";
	}
	@RequestMapping(value = "/codeXdmInst")
	public String codeXdmInst(CodeDto dto, Model model) throws Exception {
		
		model.addAttribute("listPaging", codeGroupService.selectListWithoutPaging());
		return "/xdm/infra/code/codeXdmInst";
	}
	public void setSearch(CodeVo vo) throws Exception {
		vo.setShDateStart(vo.getShDateStart() == null
		    ? UtilDateTime.calculateDayReplace00TimeString(UtilDateTime.nowLocalDateTime(), Constants.DATE_INTERVAL)
		    : UtilDateTime.add00TimeString(vo.getShDateStart()));
		vo.setShDateEnd(vo.getShDateEnd() == null
		    ? UtilDateTime.nowString()
		    : UtilDateTime.add59TimeString(vo.getShDateEnd()));		
	}
	
	
}
