package com.ezticket.infra.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberRestController {
	
	@Autowired
	MemeberService service;
	
	
	
	@RequestMapping(value = "/restlist", method = RequestMethod.GET)
	public List<MemberDto> restlist(MemeberVo vo) throws Exception {
		vo.setParamsPaging(service.count(vo));
		List<MemberDto> list = service.selectList(vo);
		
		return list;
	}
	
	
	@RequestMapping(value = "/restone/{mbSeq}" , method = RequestMethod.GET)
	public MemberDto restone(@PathVariable("mbSeq") String mbSeq,MemberDto dto) throws Exception {
		dto.setMbSeq(mbSeq);
		MemberDto item =   service.selectOne(dto);

		return item;
	}
	
	@RequestMapping(value = "/restinst" , method = RequestMethod.POST)
	public int restinst(MemberDto dto) throws Exception {
		//dto.setMbSeq(mbSeq);
		
		dto.setMbPassword(encodeBcrypt(dto.getMbPassword(), 10));


		service.insert(dto);

		return 1;
	}
	@RequestMapping(value = "/restupdate/{mbSeq}" , method = RequestMethod.PATCH)
	public int restuptp(@PathVariable("mbSeq") String mbSeq,MemberDto dto) throws Exception {
		dto.setMbSeq(mbSeq);


		service.usrUpdate(dto);

		return 1;
	}
	
	public String encodeBcrypt(String planeText, int strength) {
		return new BCryptPasswordEncoder(strength).encode(planeText);
	}

}
