package com.ezticket.infra.code;

import java.util.List;


//import com.example.demo.infra.code.CodeDto;

public interface CodeDao {

	public List<CodeDto> selectList(CodeVo vo);
	
	public CodeDto selectOne(CodeDto dto);
	public int insert(CodeDto dto);
	public int update(CodeDto dto);
	public int delete(CodeDto dto);
	public int updatedelete(CodeDto dto);
	  public List<CodeDto> selectListCachedCodeArrayList();
}
