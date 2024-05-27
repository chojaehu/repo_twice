package com.ezticket.infra.performance;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ezticket.common.constants.Constants;
import com.ezticket.common.util.UtilDateTime;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpSession;



@Controller
public class PerformanceController {
	
	
	
	@Autowired
	PerformanceService service;
	
	private String str = "xdm/infra/performance/";
	
	@RequestMapping(value = "/performanceXdmList")
	public String performanceXdmList(@ModelAttribute("vo")PerformanceVo vo,Model model,PerformanceDto dto) throws Exception{
		setSearch(vo);
		vo.setParamsPaging(service.count(vo));
		
		//model.addAttribute("count", service.count(vo));
		
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
		
		return str+"performanceXdmList";
	}
	@RequestMapping(value = "/performanceXdmForm")
	public String performanceXdmForm(PerformanceDto dto, Model model) throws Exception {
		
		
		model.addAttribute("item", service.selectOne(dto));
		
		return "xdm/infra/performance/performanceXdmForm";
	}
	@RequestMapping(value = "/performanceXdmInst")
	public String performanceXdmInst(PerformanceDto dto) throws Exception
	{
		return str + "performanceXdmInst";
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
	private String str2 = "usr/list";
	
	/*
	 * @RequestMapping(value="/useSession") public String useSession(HttpSession
	 * httpSession) throws Exception{ httpSession.setMaxInactiveInterval(120 *
	 * Constants.SESSION_MINUTE_XDM); // 60second * 30 = 30minute
	 * httpSession.setAttribute("useSession", "usr"); return "redirect:/useIndex"; }
	 */
	//메인회면
	@RequestMapping(value = "/useIndex")
	public String useIndex(@ModelAttribute("vo")PerformanceVo vo,Model model,HttpSession httpSession) throws Exception {
		
		
		String apiUrl2 = "https://api.themoviedb.org/3/movie/now_playing?language=ko-KR&page=1";
		

		URL url2 = new URL(apiUrl2);
		HttpURLConnection httpURLConnection2 = (HttpURLConnection) url2.openConnection();
		httpURLConnection2.setRequestMethod("GET");
		
		
		httpURLConnection2.setRequestProperty("Accept", "application/json");
		httpURLConnection2.setRequestProperty("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIwYmUxNTQzYjU4ZGM5MDc3MWFhZDBiMWEzOThhYmRkNiIsInN1YiI6IjY2NGZmMDE5NTg3NzE3NjY3OTliMmFlMSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.b3XosGNjbcuGLqDbjmMw7PqTW3k5JxbnDuVzFJbznfE");
		
		
		BufferedReader bufferedReader2;
		if (httpURLConnection2.getResponseCode() >= 200 && httpURLConnection2.getResponseCode() <= 300) {
			bufferedReader2 = new BufferedReader(new InputStreamReader(httpURLConnection2.getInputStream()));
		} else {
			bufferedReader2 = new BufferedReader(new InputStreamReader(httpURLConnection2.getErrorStream()));
		}
		
		StringBuilder stringBuilder2 = new StringBuilder();
		String line2;
		while ((line2 = bufferedReader2.readLine()) != null) {
			stringBuilder2.append(line2);
		}

		bufferedReader2.close();
		httpURLConnection2.disconnect();

		ObjectMapper objectMapper2 = new ObjectMapper();
		JsonNode node2 = objectMapper2.readTree(stringBuilder2.toString());
		
		
		model.addAttribute("item", node2);
		
		
		
		httpSession.setMaxInactiveInterval(120 * Constants.SESSION_MINUTE_XDM); // 60second * 30 = 30minute
		httpSession.setAttribute("useSession", "usr");
		
		
		setSearch(vo);
		model.addAttribute("list", service.usrselectRanking(vo));
		/* model.addAttribute("list", service.usrselectList(vo)); */
		return str2 + "/useIndex";
	}
	
	// 공연 리스트 
	@RequestMapping(value = "/usePerformanceList")
	public String usePerformanceList(@ModelAttribute("vo")PerformanceVo vo,Model model,RedirectAttributes redirectAttributes) throws Exception{
		
		
		setSearch(vo);
		vo.setParamsPaging(service.usrcount(vo));
		System.out.println(vo.getShOption()+"----------------------------------------");
		System.out.println(vo.getShValue()+"----------------------------------------");
		
		redirectAttributes.addFlashAttribute("vo", vo);
		model.addAttribute("list", service.usrselectList(vo));

		return str2 + "/usePerformanceList";
	}
	
	//지역별 공연 리스트
	@RequestMapping(value = "/usePerformanceAreaAjax")
	public String usePerformanceAreaAjax(@ModelAttribute("vo")PerformanceVo vo,Model model) throws Exception {
		
		setSearch(vo);
		vo.setParamsPaging(service.usrcount(vo));
		model.addAttribute("list", service.usrselectList(vo));
		return str2 + "/usePerformanceAreaAjax";
	}
	@RequestMapping(value = "/usePerformanceArea")
	public String usePerformanceArea(@ModelAttribute("vo")PerformanceVo vo,Model model) throws Exception {
		
		setSearch(vo);
		vo.setParamsPaging(service.usrcount(vo));
		model.addAttribute("list", service.usrselectList(vo));
		return str2 + "/usePerformanceArea";
	}
	
	// 랭킹 공연 리스트
	@RequestMapping(value = "/usePerformanceRanking")
	public String usePerformanceRanking(@ModelAttribute("vo")PerformanceVo vo,Model model) throws Exception {
		
		setSearch(vo);
		model.addAttribute("list", service.usrselectRanking(vo));
		return str2 + "/usePerformanceRanking";
	}
	
	// 공연 페이지
	@RequestMapping(value = "/usePerformancepage")
	public String usePerformancepage(@ModelAttribute("vo")PerformanceVo vo,PerformanceDto dto,Model model) throws Exception {
		
		 //List<PerformanceDto> rv = service.reviewList(vo);
		setSearch(vo);
		model.addAttribute("castlist", service.castMemberList(vo));
		model.addAttribute("item", service.selectOne(dto));
		model.addAttribute("review", service.reviewList(vo));
		model.addAttribute("reply", service.replyList(vo));
		model.addAttribute("image", service.pruploadimgselect(dto));
		
		return str2 + "/usePerformancepage";
	}
	// 공연페이지 리뷰(댓글)
	@ResponseBody
	@RequestMapping(value = "/reviewinsert")
	public Map<String, Object> reviewinsert(Model model, PerformanceDto dto, HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		System.out.println(dto.getRvRvwCntnt());
		dto.setMbSeq((String)httpSession.getAttribute("sessSeqXdm"));
		String str = dto.getMbSeq();
		if(str != null)
		{
			returnMap.put("rt", "success");
			service.reviewinsert(dto);
		}
		else
		{
			returnMap.put("rt", "false");
		}
		
	
		return returnMap;
	}
	// 공연페이지 리뷰(댓글)
		@ResponseBody
		@RequestMapping(value = "/replyinsert")
		public Map<String, Object> replyinsert(Model model, PerformanceDto dto, HttpSession httpSession) throws Exception {
			Map<String, Object> returnMap = new HashMap<String, Object>();
			
			System.out.println(dto.getRvRvwCntnt());
			dto.setMbSeq((String)httpSession.getAttribute("sessSeqXdm"));
			String str = dto.getMbSeq();
			if(str != null)
			{
				returnMap.put("rt", "success");
				service.replyinsert(dto);
			}
			else
			{
				returnMap.put("rt", "false");
			}
			
		
			return returnMap;
		}
		
	

		
	
	
	
	
	public void setSearch(PerformanceVo vo) throws Exception {

		
		/* 초기값 세팅이 있는 경우 사용 */
		vo.setShDateStart(vo.getShDateStart() == null
		    ? UtilDateTime.calculateDayReplace00TimeString(UtilDateTime.nowLocalDateTime(), Constants.DATE_INTERVAL)
		    : UtilDateTime.add00TimeString(vo.getShDateStart()));
		vo.setShDateEnd(vo.getShDateEnd() == null
		    ? UtilDateTime.nowString()
		    : UtilDateTime.add59TimeString(vo.getShDateEnd()));		
	}
	public String encodeBcrypt(String planeText, int strength) {
		  return new BCryptPasswordEncoder(strength).encode(planeText);
	}

			
	public boolean matchesBcrypt(String planeText, String hashValue, int strength) {
	  BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(strength);
	  return passwordEncoder.matches(planeText, hashValue);
	}

}
