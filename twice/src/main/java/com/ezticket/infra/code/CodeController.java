package com.ezticket.infra.code;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ezticket.common.constants.Constants;
import com.ezticket.common.util.UtilDateTime;
import com.ezticket.infra.codegroup.CodeGroupService;

import jakarta.servlet.http.HttpServletResponse;

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
	
	
	String cd = "xdm/infra/code/";
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
		//model.addAttribute("list", service.selectList(vo));
		
		return cd+"codeXdmList";
	}
	@RequestMapping(value = "/codeXdmListAjax")
	public String codeXdmListAjax(@ModelAttribute("vo")CodeVo vo, Model model) throws Exception {
		setSearch(vo);
		
		vo.setParamsPaging(service.count(vo));
		
		model.addAttribute("count", service.count(vo));
		if(vo.getTotalRows()>0)
		{
			model.addAttribute("list", service.selectList(vo));		
		}	
		System.out.println("아작스 통신 성공 ---------------------------------------");
		System.out.println("아작스 통신 성공 ---------------------------------------" );
		//model.addAttribute("list", service.selectList(vo));
		
		return cd+"codeXdmListAjax";
	}
	
	@RequestMapping(value = "/codeXdmForm")
	public String codeXdmForm(CodeDto dto, Model model) throws Exception {
		
		
		model.addAttribute("item", service.selectOne(dto));
		
		return cd+"codeXdmForm";
	}
	@RequestMapping(value = "/codeXdmInst")
	public String codeXdmInst(CodeDto dto, Model model) throws Exception {
		
		model.addAttribute("listPaging", codeGroupService.selectListWithoutPaging());
		return cd+"codeXdmInst";
	}
	
	
	
	@RequestMapping("/excelDownload")
    public void excelDownload(@ModelAttribute("vo")CodeVo vo, HttpServletResponse httpServletResponse) throws Exception {
		
		setSearch(vo);
		vo.setParamsPaging(service.count(vo));

		if (vo.getTotalRows() > 0) {
			List<CodeDto> list = service.selectList(vo);
			
			Workbook workbook = new HSSFWorkbook();	// for xls
//	        Workbook workbook = new XSSFWorkbook();
	        Sheet sheet = workbook.createSheet("첫번째 시트");
	        CellStyle cellStyle = workbook.createCellStyle();        
	        Row row = null;
	        Cell cell = null;
	        int rowNum = 0;
			
//	        each column width setting
	        sheet.setColumnWidth(0, 2100);
	        sheet.setColumnWidth(1, 3100);

//	        Header
	        String[] tableHeader = {"그룹넘버",	"그룹이름",	"코드넘버","코드이름","등록일","수정일","삭제여부"};

	        row = sheet.createRow(rowNum++);
			for(int i=0; i<tableHeader.length; i++) {
				cell = row.createCell(i);
	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
	        	cell.setCellStyle(cellStyle);
				cell.setCellValue(tableHeader[i]);
			}

//	        Body
	        for (int i=0; i<list.size(); i++) {
	            row = sheet.createRow(rowNum++);
	            
//	            String type: null 전달 되어도 ok
//	            int, date type: null 시 오류 발생 하므로 null check
//	            String type 이지만 정수형 데이터가 전체인 seq 의 경우 캐스팅
	            
	            cell = row.createCell(0);
	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
	        	cell.setCellStyle(cellStyle);
	            cell.setCellValue(Integer.parseInt(list.get(i).getIfcgSeq()));
	            
	            cell = row.createCell(1);
	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
	        	cell.setCellStyle(cellStyle);
	        	cell.setCellValue(list.get(i).getIfcgName());
	        	
	            cell = row.createCell(2);
	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
	        	cell.setCellStyle(cellStyle);
	        	cell.setCellValue(Integer.parseInt(list.get(i).getIfcdSeq()));
	        	
	            cell = row.createCell(3);
	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
	        	cell.setCellStyle(cellStyle);
	        	cell.setCellValue(list.get(i).getIfcdName());
	            

	            cell = row.createCell(4);
	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
	        	cell.setCellStyle(cellStyle);
	        	if(list.get(i).getIfcdRgstrDate() != null) cell.setCellValue(UtilDateTime.dateTimeToString(list.get(i).getIfcdRgstrDate()));
	        	
	        	cell = row.createCell(5);
	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
	        	cell.setCellStyle(cellStyle);
	        	if(list.get(i).getIfcdModifiedDate() != null) cell.setCellValue(UtilDateTime.dateTimeToString(list.get(i).getIfcdModifiedDate()));
	        	
	        	cell = row.createCell(6);
	            cellStyle.setAlignment(HorizontalAlignment.CENTER);
	            cell.setCellStyle(cellStyle);
	            if(list.get(i).getIfcddeleteNY() != null) cell.setCellValue(list.get(i).getIfcddeleteNY() == 0 ? "N" : "Y");
	        }

	        httpServletResponse.setContentType("ms-vnd/excel");
//	        httpServletResponse.setHeader("Content-Disposition", "attachment;filename=example.xls");	// for xls
	        httpServletResponse.setHeader("Content-Disposition", "attachment;filename=example.xls");

	        workbook.write(httpServletResponse.getOutputStream());
	        workbook.close();
		}
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
