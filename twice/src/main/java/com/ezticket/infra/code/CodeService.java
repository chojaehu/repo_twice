package com.ezticket.infra.code;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeService {
	
	@Autowired
	CodeDao dao;
	
	
	public List<CodeDto> selectList(CodeVo vo){
		return dao.selectList(vo);
	}
	
	public CodeDto selectOne(CodeDto dto)
	{
		return dao.selectOne(dto);
	}
	
	public int insert(CodeDto dto)
	{
		return dao.insert(dto);
	}
	
	public int update(CodeDto dto)
	{
		return dao.update(dto);
	}
	public int delete(CodeDto dto)
	{
		return dao.delete(dto);
	}
	public int updatedelete(CodeDto dto)
	{
		return dao.updatedelete(dto);
	}

}
