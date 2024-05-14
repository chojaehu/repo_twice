package com.ezticket.infra.member;

import java.util.List;


public interface MemeberDao {
	
	public List<MemberDto> selectList(MemeberVo vo);
	
	public List<MemberDto> emailChek();
	public MemberDto selectOne(MemberDto dto);
	
	public MemberDto selectlogin(MemberDto dto);
	public int count(MemeberVo vo);
	public int insert(MemberDto dto);
	public int delete(MemberDto dto);
	public int updatedelete(MemberDto dto);
	
//	비밀번호 변경 정 확인
	public MemberDto newPassword(MemberDto dto);
	
	//비밀번호 변경
	public int newpwupdate(MemberDto dto);
	
//	s3이미지 불러오기 쿼리문
	public MemberDto uploadimgselect(MemberDto dto);
	
	
	//유저 정보 변경
	public int usrUpdate(MemberDto dto);
	
//	파일 업로드
	public int imageupload(MemberDto dto);

}
