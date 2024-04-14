package com.ezticket.infra.performance;

import java.util.List;


public interface PerformanceDao {
//	관리자 리스트
	public List<PerformanceDto> selectList(PerformanceVo vo);
	
//	사용자 리스트
	public List<PerformanceDto> usrselectList(PerformanceVo vo);
	
//	사용자 랭킹 리스트
	public List<PerformanceDto> usrselectRanking(PerformanceVo vo);
	
//	배우 리스트
	public List<PerformanceDto> castMemberList(PerformanceVo vo);
	public int count(PerformanceVo vo);
	
//	결제 완료 리스트
	public List<PerformanceDto> usrselectPay(PerformanceVo vo);
//	결제 완료 카운트
	public int usescount(PerformanceVo vo);
	
	
//	리뷰 리스트
	public List<PerformanceDto> reviewList(PerformanceVo vo);
	
	
//	리뷰 답글 리스트
	public List<PerformanceDto> replyList(PerformanceVo vo);
	
	
//	공연 몇관에 대한 리스트
	public List<PerformanceDto> tabookList(PerformanceVo vo);
	
//	공연 날짜/시간
	public List<PerformanceDto> bookOneList(PerformanceVo vo);
	
	public List<PerformanceDto> taselectOne(PerformanceVo vo);
	
	public PerformanceDto bookdate(PerformanceDto dto);
	
	
	
//	좌석 리스트
	public List<PerformanceDto> bookseatList(PerformanceDto dto);
	
	public PerformanceDto selectOne(PerformanceDto dto);
	
	
	
//	결제 
	public List<PerformanceDto> Paymentlist(PerformanceDto dto);
	
//	결제 카운트
	public int Paymentcount(PerformanceDto dto);
//	결제 총 가격 
	public Double Paymentsum(PerformanceDto dto);
	
//	결제 후 선택시트 1로 변경
	public int payseatupdate(PerformanceDto dto);
//	결제 후 인설트
	public int payinsert(PerformanceDto dto);
	
	
	public int update(PerformanceDto dto);
	public int insert(PerformanceDto dto);
	public int delete(PerformanceDto dto);
	public int updatedelete(PerformanceDto dto);

}
