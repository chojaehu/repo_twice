package com.ezticket.infra.codegroup;

import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;


@Service
public class CodeGroupService {
	
	
//	CodeGroupDao codeGroupDao;
	
	@Autowired
	CodeGroupDao dao;
	
	@Autowired
	AmazonS3Client amazonS3Client;
	
	@Value("${cloud.aws.s3.bucket}")
	private String bucket;
//	CodeGroupDao dao = new CodeGroupDao();
	
//	public List<CodeGroupDto> selectList(){
//		
//		List<CodeGroupDto> list = dao.selectList();
//		
//		return list;
//	}
	
	public List<CodeGroupDto> selectList(CodeGroupVo vo){ return dao.selectList(vo);}
	
	public List<CodeGroupDto> selectListWithoutPaging()
	{
		return dao.selectListWithoutPaging();
	}
	public int count(CodeGroupVo vo)
	{
		return dao.count(vo);
	}
	
	
	public CodeGroupDto selectOne(CodeGroupDto dto)
	{
		return dao.selectOne(dto);	
	}
	
	
	
	public int insert(CodeGroupDto dto)throws Exception {
		dao.insert(dto);
	    
	    
		for(MultipartFile multipartFile : dto.getUploadflies()) {
			
			if(!multipartFile.isEmpty()) {
				//System.out.println("multipartFile.getOriginalFilename() : " + multipartFile.getOriginalFilename());
				
		        ObjectMetadata metadata = new ObjectMetadata();
		        metadata.setContentLength(multipartFile.getSize());
		        metadata.setContentType(multipartFile.getContentType());
		        
		        amazonS3Client.putObject(bucket, multipartFile.getOriginalFilename(), multipartFile.getInputStream(), metadata);
				
		        String objectUrl = amazonS3Client.getUrl(bucket, multipartFile.getOriginalFilename()).toString();
		        
		        UUID uuid = UUID.randomUUID();
		        String exit = FilenameUtils.getExtension(multipartFile.getOriginalFilename());
		        
		        
		        dto.setIuPath(objectUrl);
		        dto.setIuOriginalName(FilenameUtils.getBaseName(multipartFile.getOriginalFilename()));
		        dto.setIuUuidName(uuid.toString());
		        dto.setIuSize((int) multipartFile.getSize());
		        dto.setIuExt(exit);
		        
		       
		        
		        System.out.println(dto.getIuPath());
		        System.out.println(dto.getIuOriginalName());
		        System.out.println(dto.getIuUuidName());
		        System.out.println(dto.getIuSize());
		        System.out.println(dto.getIuExt());
		        dao.imageupload(dto);
				
			}
		}
		return 1;
	}
	public int excelupload(CodeGroupDto dto)
	{
		return dao.insert(dto);
	}
	
	
	
	
	public int update(CodeGroupDto dto) {
		
		return dao.update(dto);
	}
	
	public int updatedelete(CodeGroupDto dto) {
		
		return dao.updatedelete(dto);
	}
	
	public int delete(CodeGroupDto dto) {
		
		return dao.delete(dto);
	}
	

}
