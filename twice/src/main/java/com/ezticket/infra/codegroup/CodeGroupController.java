package com.ezticket.infra.codegroup;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ezticket.common.util.UtilDateTime;
import com.ezticket.common.constants.Constants;

@Controller
public class CodeGroupController {

	@Autowired
	CodeGroupService service;
	
	String str = "xdm/infra/index/";

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

	/*
	 * @RequestMapping(value = "/codeGroupView") public String
	 * codeGroupView(CodeGroupDto dto, Model model) throws Exception {
	 * 
	 * model.addAttribute("item", service.selectOne(dto)); return
	 * "/xdm/infra/codegroup/codeGroupView"; }
	 * 
	 * @RequestMapping(value = "/Replacement") public String
	 * Replacement(CodeGroupDto dto, Model model) throws Exception {
	 * 
	 * model.addAttribute("item", service.selectOne(dto)); return
	 * "/xdm/infra/codegroup/Replacement"; }
	 * 
	 * @RequestMapping(value = "/Registration") public String Registration() throws
	 * Exception {
	 * 
	 * 
	 * return "/xdm/infra/codegroup/Registration"; }
	 */
	@RequestMapping(value = "/codeGroupInsert")
	public String codeGroupInsert(CodeGroupDto dto) throws Exception {
		
		
		
		
//		System.out.println(dto.getUploadflies().length);
//		for(MultipartFile a : dto.getUploadflies())
//		{
//			System.out.println("a.getOriginalFilename() : "+a.getOriginalFilename());
//		}
		
		
		service.insert(dto);

		return "redirect:/codeGroupXdmList";
	}
	@RequestMapping(value= "/excelupload")
	public String excelupload(CodeGroupDto dto) throws Exception
	{
		XSSFWorkbook workbook = new XSSFWorkbook(dto.getExcelfile().getInputStream());
	    XSSFSheet worksheet = workbook.getSheetAt(0);
	    System.out.println(worksheet.getPhysicalNumberOfRows()+"-------------------------------------------");
	    for(int i=1;i<worksheet.getPhysicalNumberOfRows() ;i++) {
	        CodeGroupDto excel = new CodeGroupDto();
	           
	        
	        DataFormatter formatter = new DataFormatter();		        
	        XSSFRow row = worksheet.getRow(i);
	        	    	
	        String userName = formatter.formatCellValue(row.getCell(0));
	        
	        
	        excel.setIfcgName(userName);
	        excel.setIfcgdeleteNY(0);
	        
	        service.excelupload(excel);
	    } 
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
	
	@RequestMapping(value = "/portfolio")
	public String startindex() throws Exception {
		

		return str+"startindex";
	}
	@RequestMapping(value = "/indexs")
	public String indexs() throws Exception {
		

		return str+"indexs";
	}
	
	@RequestMapping(value = "/forgotpassword")
	public String forgotpassword() throws Exception {
		

		return str+"forgotpassword";
	}
	@RequestMapping(value = "/signup")
	public String signup() throws Exception {
		

		return str+ "signup";
	}
	@RequestMapping(value = "/waring")
	public String waring() throws Exception {
		

		return str+"waring";
	}
	
	
	
	
	
	String cdg = "xdm/infra/codegroup/";
	@RequestMapping(value = "/codeGroupXdmForm")
	public String codeGroupXdmForm(CodeGroupDto dto, Model model) throws Exception {
		
		model.addAttribute("item", service.selectOne(dto));
		
		return cdg+"codeGroupXdmForm";
	}
	
	@RequestMapping(value = "/codeGroupXdmInst")
	public String codeGroupXdmInst(CodeGroupDto dto, Model model) throws Exception {
		
		
		return cdg+"codeGroupXdmInst";
	}
	
		
	@RequestMapping(value = "/codeGroupXdmList")
	public String codeGroupXdmList(@ModelAttribute("vo") CodeGroupVo vo,Model model,CodeGroupDto dto) throws Exception {

		setSearch(vo);
		
		vo.setParamsPaging(service.count(vo));
		
		
		model.addAttribute("count", service.count(vo));
		if(vo.getTotalRows()>0)
		{
			model.addAttribute("list", service.selectList(vo));		
		}		
		
		/*
		 * System.out.println("vo.getEndPage() : " + vo.getEndPage());
		 * System.out.println("vo.getStartPage() : "+ vo.getStartPage());
		 * System.out.println("vo.getTotalPages() : " + vo.getTotalPages());
		 * System.out.println("vo.getTotalRows() : " + vo.getTotalRows());
		 */
		return cdg+"codeGroupXdmList";
	}
	

	
	
	public void setSearch(CodeGroupVo vo) throws Exception {
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
