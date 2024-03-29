package com.ezticket.infra.performance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ezticket.common.constants.Constants;
import com.ezticket.common.util.UtilDateTime;


@Controller
public class PerformanceController {
	
	
	
	@Autowired
	PerformanceService service;
	
	private String str = "/xdm/infra/performance";
	
	@RequestMapping(value = "/performanceXdmList")
	public String performanceXdmList(@ModelAttribute("vo")PerformanceVo vo,Model model,PerformanceDto dto) throws Exception{
		setSearch(vo);
		vo.setParamsPaging(service.count(vo));
		
		model.addAttribute("count", service.count(vo));
		
		if(vo.getTotalRows() > 0)
		{
			model.addAttribute("list", service.selectList(vo));
		}
		/*
		 * model.addAttribute("list", service.selectList(vo)); model.addAttribute("vo",
		 * vo);
		 */
		
		/*
		 * System.out.println("dto.getIfmmId(): " + dto.getPrTitle());
		 * 
		 * dto.setPrTitle(encodeBcrypt(dto.getPrTitle(), 10));
		 * dto.setPrTitle(encodeBcrypt(dto.getPrTitle(), 10)); String encodedId =
		 * dto.getPrTitle();
		 * 
		 * System.out.println("dto.getIfmmId()encoded: " + dto.getPrTitle());
		 * 
		 * System.out.println("---------------------");
		 * 
		 * System.out.println("dto.getIfmmName(): " + dto.getPrHostedPlanned());
		 * 
		 * String name = dto.getPrHostedPlanned();
		 * dto.setPrHostedPlanned(encodeBcrypt(dto.getPrHostedPlanned(),9));
		 * 
		 * System.out.println("dto.getIfmmName().encoded: " + dto.getPrHostedPlanned());
		 * 
		 * System.out.println("---------------------");
		 * 
		 * 
		 * System.out.println("---------------------");
		 * 
		 * if(matchesBcrypt(name, dto.getPrTitle(),10)) { System.out.println("true"); }
		 * else { System.out.println("false"); }
		 * 
		 * System.out.println("###########################");
		 */
		
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
	public String encodeBcrypt(String planeText, int strength) {
		  return new BCryptPasswordEncoder(strength).encode(planeText);
	}

			
	public boolean matchesBcrypt(String planeText, String hashValue, int strength) {
	  BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(strength);
	  return passwordEncoder.matches(planeText, hashValue);
	}

}
