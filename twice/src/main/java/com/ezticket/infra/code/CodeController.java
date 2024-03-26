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
import com.ezticket.infra.paging.pagingDto;

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
	
	
	
	//@ModelAttribute("vo")CodeDto dto,
//	인덱스
	@RequestMapping(value = "/codeXdmList")
	public String codeXdmList(@ModelAttribute("vo")final CodeVo vo, Model model) throws Exception {
		setSearch(vo);
		
		
		PagingResponse<CodeDto> response = service.findAllPost(vo);
		model.addAttribute("page", response);
		System.out.println("vo.getPagination().getTotalPageCount()" + vo.getPagination().getTotalPageCount());
		System.out.println("vo.getPagination().getEndPage() :" + vo.getPagination().getEndPage());
		System.out.println("vo.getPagination().getStartPage() :" + vo.getPagination().getStartPage());
		System.out.println("vo.getPagination().getStartPage() :" + vo.getPagination().getLimitStart());
		System.out.println("vo.getPagination().getStartPage() :" + vo.getPagination().getTotalPageCount());
		
		 //List<CodeDto> list = service.selectList(vo);
		 //model.addAttribute("list", list);
		 
		model.addAttribute("list", service.selectList(vo));
		
		
		//model.addAttribute("vo", vo);
		
		return "/xdm/infra/index/codeXdmList";
	}
	
	@RequestMapping(value = "/codeXdmForm")
	public String codeXdmForm(CodeDto dto, Model model) throws Exception {
		
		
		model.addAttribute("item", service.selectOne(dto));
		
		return "/xdm/infra/index/codeXdmForm";
	}
	@RequestMapping(value = "/codeXdmInst")
	public String codeXdmInst(CodeDto dto, Model model) throws Exception {
		
		model.addAttribute("listPaging", codeGroupService.selectListWithoutPaging());
		return "/xdm/infra/index/codeXdmInst";
	}
	public void setSearch(CodeVo vo) throws Exception {
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
	
	
}
