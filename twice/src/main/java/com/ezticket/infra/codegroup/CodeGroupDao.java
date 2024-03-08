package com.ezticket.infra.codegroup;

import java.util.List;

public interface CodeGroupDao {

	public List<CodeGroupDto> selectList();
	public CodeGroupDto selectOne(CodeGroupDto dto);
	
	
	public int insert(CodeGroupDto dto);
	
	public int update(CodeGroupDto dto);
	
	public int updatedelete(CodeGroupDto dto);
	
	public int delete(CodeGroupDto dto);

}
