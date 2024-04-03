package com.ezticket.infra.performance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ezticket.common.constants.Constants;
import com.ezticket.common.util.UtilDateTime;

import jakarta.servlet.http.HttpSession;


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
	
	@RequestMapping(value = "/performancedelete")
	public String performancedelete(PerformanceDto dto) throws Exception
	{
		service.insert(dto);
		return "redirect:/performanceXdmList";
	}
	
	@RequestMapping(value = "/performanceupdatedelete")
	public String performanceupdatedelete(PerformanceDto dto) throws Exception
	{
		service.updatedelete(dto);
		return "redirect:/performanceXdmList";
	}
	
	
	
	
	
//	사용자 화면
	private String str2 = "/usr/list";
	
	
	//메인회면
	@RequestMapping(value = "/useIndex")
	public String useIndex(PerformanceVo vo,Model model) {
		
		model.addAttribute("list", service.usrselectList(vo));
		/* model.addAttribute("list", service.usrselectList(vo)); */
		return str2 + "/useIndex";
	}
	
	// 공연 리스트 
	@RequestMapping(value = "/usePerformanceList")
	public String usePerformanceList(PerformanceVo vo,Model model) throws Exception{
		
		model.addAttribute("castlist", service.castMemberList(vo));
		model.addAttribute("list", service.usrselectList(vo));
		
		
		return str2 + "/usePerformanceList";
	}
	
	//지역별 공연 리스트
	@RequestMapping(value = "/usePerformanceArea")
	public String usePerformanceArea(PerformanceVo vo,Model model) {
		
		
		model.addAttribute("list", service.usrselectList(vo));
		return str2 + "/usePerformanceArea";
	}
	
	// 랭킹 공연 리스트
	@RequestMapping(value = "/usePerformanceRanking")
	public String usePerformanceRanking(PerformanceVo vo,Model model) {
		
		
		model.addAttribute("list", service.usrselectRanking(vo));
		return str2 + "/usePerformanceRanking";
	}
	
	// 공연 페이지
	@RequestMapping(value = "/usePerformancepage")
	public String usePerformancepage(PerformanceVo vo,PerformanceDto dto,Model model) {

		model.addAttribute("castlist", service.castMemberList(vo));
		model.addAttribute("item", service.selectOne(dto));
		model.addAttribute("review", service.reviewList(vo));
		//model.addAttribute("reply", service.replyList(vo));
		
		return str2 + "/usePerformancepage";
	}
	
	// 결제 정보 보기
	@RequestMapping(value = "/useInformation")
	public String useModify(PerformanceVo vo, Model model, HttpSession httpSession) throws Exception
	{
		vo.setPrSeq((String)httpSession.getAttribute("sessSeqXdm"));
		model.addAttribute("list", service.usrselectPay(vo));
		
		return str2 + "/useInformation";
	}
	
	

	
	
//	티켓 예매 페이지
	private String str3 = "/usr/book";
	
	// 예매 첫번째 페이지
	@RequestMapping(value = "/useBookOne")
	public String useBookOne(PerformanceVo vo , Model model) throws Exception
	{
		// 공연관
		model.addAttribute("talist", service.tabookList(vo));
		
		// 공연 날짜 시간
		model.addAttribute("list", service.bookOneList(vo));
		
		return str3 + "/useBookOne";
	}
	
	// 예매 두번째 페이지 좌석 선택
	@RequestMapping(value = "/useBookTow")
	public String useBookTow() throws Exception
	{
		
		return str3 + "/useBookTow";
	}
	
	// 예매 3번째 페이지 결제
	@RequestMapping(value = "/useBookBuy")
	public String useBookBuy() throws Exception
	{
		
		return str3 + "/useBookBuy";
	}
	
	// 예매 최종 티켓 발행
	@RequestMapping(value = "/useBookfinal")
	public String useBookfinal() throws Exception
	{
		
		return str3 + "/useBookfinal";
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
