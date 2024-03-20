package com.ezticket.infra.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemeberService {
	
	
	@Autowired
	MemeberDao dao;
	
	public List<MemberDto> selectList(MemeberVo vo){ return dao.selectList(vo);};

}
