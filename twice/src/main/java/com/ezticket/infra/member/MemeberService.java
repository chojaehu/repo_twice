package com.ezticket.infra.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemeberService {
	
	
	@Autowired
	MemeberDao dao;
	
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
	public int insert(MemberDto dto)
	{
		return dao.insert(dto);
	}
	public int delete(MemberDto dto)
	{
		return dao.delete(dto);
	}
	public int updatedelete(MemberDto dto)
	{
		return dao.updatedelete(dto);
	}
	
	
	//유저 업데이트
	public int usrUpdate(MemberDto dto)
	{
		return dao.usrUpdate(dto);
	}

}
