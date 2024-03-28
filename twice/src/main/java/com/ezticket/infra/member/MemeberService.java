package com.ezticket.infra.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemeberService {
	
	
	@Autowired
	MemeberDao dao;
	
	public List<MemberDto> selectList(MemeberVo vo){ return dao.selectList(vo);};
	
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
	public int insert(MemberDto dto)
	{
		return dao.insert(dto);
	}

}
