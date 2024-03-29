package com.ezticket.infra.codegroup;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezticket.infra.code.CodeDto;
import com.ezticket.infra.code.CodeVo;

@Service
public class CodeGroupService {
	
	
//	CodeGroupDao codeGroupDao;
	
	@Autowired
	CodeGroupDao dao;
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
	
	public int insert(CodeGroupDto dto) {
		
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
