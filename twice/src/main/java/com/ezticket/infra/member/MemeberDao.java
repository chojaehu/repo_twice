package com.ezticket.infra.member;

import java.util.List;


public interface MemeberDao {
	
	public List<MemberDto> selectList(MemeberVo vo);
	public MemberDto selectOne(MemberDto dto);
	
	public MemberDto selectlogin(MemberDto dto);
	public int count(MemeberVo vo);
	public int insert(MemberDto dto);

}
