package com.ezticket.infra.performance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ezticket.common.constants.Constants;
import com.ezticket.common.util.UtilDateTime;
import com.ezticket.infra.code.CodeDto;
import com.ezticket.infra.codegroup.CodeGroupDto;
import com.ezticket.infra.codegroup.CodeGroupService;
import com.ezticket.infra.member.MemeberVo;

@Controller
public class PerformanceController {
	
	
	
	@Autowired
	PerformanceService service;
	
	private String str = "/xdm/infra/performance";
	
	@RequestMapping(value = "/performanceXdmList")
	public String performanceXdmList(Model model, PerformanceVo vo) throws Exception{
		setSearch(vo);
		model.addAttribute("list", service.selectList(vo));
		model.addAttribute("vo", vo);
		
		return "/xdm/infra/performance/performanceXdmList";
	}
	@RequestMapping(value = "/performanceXdmForm")
	public String performanceXdmForm(PerformanceDto dto, Model model) throws Exception {
		
		
		model.addAttribute("item", service.selectOne(dto));
		
		return "/xdm/infra/performance/performanceXdmForm";
	}
	@RequestMapping(value = "/performanceXdmInst")
	public String performanceXdmInst(PerformanceDto dto) throws Exception
	{
		return str + "/performanceXdmInst";
	}
	@RequestMapping(value = "/performanceinsert")
	public String performanceinsert(PerformanceDto dto) throws Exception
	{
		service.insert(dto);
		return "redirect:/performanceXdmList";
	}
	
	
	@RequestMapping(value = "/performanceupdate")
	public String performanceupdate(PerformanceDto dto) throws Exception {
		
		
		System.out.println("dto.getPrStartDate : "+dto.getPrStartDate());
		System.out.println("dto.getPrEndDate : "+dto.getPrEndDate());
		service.update(dto);

		return "redirect:/performanceXdmList";
	}
	
	public void setSearch(PerformanceVo vo) throws Exception {
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
