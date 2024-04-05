package com.ezticket.infra.performance;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PerformanceService {
	
	@Autowired
	PerformanceDao dao;
	
//	관리자 리스트
	public List<PerformanceDto> selectList(PerformanceVo vo)
	{
		return dao.selectList(vo);
	}
	
//	사용자 리스트
	public List<PerformanceDto> usrselectList(PerformanceVo vo)
	{
		return dao.usrselectList(vo);
	}
	
//	사용자 랭킹 리스트
	public List<PerformanceDto> usrselectRanking(PerformanceVo vo)
	{
		return dao.usrselectRanking(vo);
	}
	
//	사용자 배우 리스트
	public List<PerformanceDto> castMemberList(PerformanceVo vo)
	{
		return dao.castMemberList(vo);
	}
	
//	사용자 결제완료 티켓 리스트 
	public List<PerformanceDto> usrselectPay(PerformanceVo vo)
	{
		return dao.usrselectPay(vo);
	}
	
//	공연장소 관에 대한 정보
	public List<PerformanceDto> tabookList(PerformanceVo vo)
	{
		return dao.tabookList(vo);
	}
	
//	공연 날짜 시간 
	public List<PerformanceDto> bookOneList(PerformanceVo vo)
	{
		return dao.bookOneList(vo);
	}
	
//	상세페이지 리뷰 리스트
	public List<PerformanceDto> reviewList(PerformanceVo vo){
		return dao.reviewList(vo);
	}
	
//	리뷰 답글 리스트
	public List<PerformanceDto> replyList(PerformanceVo vo)
	{
		return dao.replyList(vo);
	}
	
//	리스트 총 갯수
	public int count(PerformanceVo vo) {
		return dao.count(vo);
	}
	public PerformanceDto selectOne(PerformanceDto dto)
	{
		return dao.selectOne(dto);
	}
	public PerformanceDto bookdate(PerformanceDto dto)
	{
		return dao.bookdate(dto);
	}
	
	
	public int update(PerformanceDto dto)
	{
		return dao.update(dto);
	}
	public int insert(PerformanceDto dto)
	{
		return dao.insert(dto);
	}
	public int delete(PerformanceDto dto)
	{
		return dao.delete(dto);
	}
	public int updatedelete(PerformanceDto dto)
	{
		return dao.updatedelete(dto);
	}

}
