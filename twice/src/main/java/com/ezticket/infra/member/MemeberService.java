package com.ezticket.infra.member;

import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;

@Service
public class MemeberService {
	
	
	@Autowired
	MemeberDao dao;
	
	@Autowired
	AmazonS3Client amazonS3Client;
	
	@Value("${cloud.aws.s3.bucket}")
	private String bucket;
	
	public List<MemberDto> selectList(MemeberVo vo){ return dao.selectList(vo);};
	
	public List<MemberDto> emailChek()
	{
		return dao.emailChek();
	}
	
	public MemberDto selectlogin(MemberDto dto) {
		return dao.selectlogin(dto);
	}
	
	public MemberDto selectOne(MemberDto dto)
	{
		return dao.selectOne(dto);
	}
	public int count(MemeberVo vo)
	{
		return dao.count(vo);
	}
	
	
	public int insert(MemberDto dto) throws Exception
	{
		dao.insert(dto);
		
		if(dto.getUploadflies() != null)
		{
			for(MultipartFile multipartFile : dto.getUploadflies()) {
				
				if(!multipartFile.isEmpty()) {
					//System.out.println("multipartFile.getOriginalFilename() : " + multipartFile.getOriginalFilename());
					
			        ObjectMetadata metadata = new ObjectMetadata();
			        metadata.setContentLength(multipartFile.getSize());
			        metadata.setContentType(multipartFile.getContentType());
			        
			        amazonS3Client.putObject(bucket, multipartFile.getOriginalFilename(), multipartFile.getInputStream(), metadata);
					
			        String objectUrl = amazonS3Client.getUrl(bucket, multipartFile.getOriginalFilename()).toString();
			        
			        String uuid = UUID.randomUUID().toString();
			        String exit = FilenameUtils.getExtension(multipartFile.getOriginalFilename());
			        
			        
			        dto.setIuPath(objectUrl);
			        dto.setIuOriginalName(FilenameUtils.getBaseName(multipartFile.getOriginalFilename()));
			        dto.setIuUuidName(uuid);
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
		}
		
		return 1;
	}
	public int delete(MemberDto dto)
	{
		return dao.delete(dto);
	}
	public int updatedelete(MemberDto dto)
	{
		return dao.updatedelete(dto);
	}
	
//	s3이미지 불러오기
	public MemberDto uploadimgselect(MemberDto dto)
	{
		return dao.uploadimgselect(dto);
	}
	
//	비밀번호 변경 전 확인
	public MemberDto newPassword(MemberDto dto)
	{
		return dao.newPassword(dto);
	}
	// 비밀번호 변경
	public int newpwupdate(MemberDto dto)
	{
		return dao.newpwupdate(dto);
	}
	
	//유저 업데이트
	public int usrUpdate(MemberDto dto)
	{
		return dao.usrUpdate(dto);
	}

}
