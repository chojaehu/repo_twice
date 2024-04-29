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
//	사용자 리스트 카운트
	public int usrcount(PerformanceVo vo) {
		return dao.usrcount(vo);
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
	
//	상세페이지
	public PerformanceDto selectOne(PerformanceDto dto)
	{
		return dao.selectOne(dto);
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
//	리뷰 달기
	public int reviewinsert(PerformanceDto dto)
	{
		return dao.reviewinsert(dto);
	}
//	리뷰 답글 달기
	public int replyinsert(PerformanceDto dto)
	{
		return dao.replyinsert(dto);
	}
	
//	리스트 총 갯수
	public int count(PerformanceVo vo) {
		return dao.count(vo);
	}
	
//	사용자 결제완료 티켓 리스트 
	public List<PerformanceDto> usrselectPay(PerformanceVo vo)
	{
		return dao.usrselectPay(vo);
	}
//	결제완료 좌석 리스트
	public List<PerformanceDto> usrseatPay(PerformanceVo vo)
	{
		return dao.usrseatPay(vo);
	}
//	결제완료 카운트
	public int usescount(PerformanceVo vo)
	{
		return dao.usescount(vo);
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
	
	public List<PerformanceDto> taselectOne(PerformanceVo vo)
	{
		return dao.taselectOne(vo);
	}
	public PerformanceDto bookdate(PerformanceDto dto)
	{
		return dao.bookdate(dto);
	}
	
	
//	좌서리스트
	public List<PerformanceDto> bookseatList(PerformanceDto dto)
	{
		return dao.bookseatList(dto);
	}
	
	
//	결제창
	public List<PerformanceDto> Paymentlist(PerformanceDto dto){
		return dao.Paymentlist(dto);
	}
	
//	결제 카운트
	public int Paymentcount(PerformanceDto dto)
	{
		return dao.Paymentcount(dto);
	}
//	결제 총가격
	public PerformanceDto Paymentsum(PerformanceDto dto)
	{
		return dao.Paymentsum(dto);
	}
	
//	결제후 선택시트 1로 변경
	public int payseatupdate(PerformanceDto dto)
	{
		return dao.payseatupdate(dto);
	}
//	결제 후 결제 정보 인설트 
	public int payinsert(PerformanceDto dto)
	{
		return dao.payinsert(dto);
	}
//	카카오페이 결제 인설트
	public int kakaopayinsert(PerformanceDto dto)
	{
		return dao.kakaopayinsert(dto);
	}
//	결제 후 공연좌석 정보 인설트
	public int payseatinsert(PerformanceDto dto)
	{
		return dao.payseatinsert(dto);
	}
	
//	결제 후 티켓 발행
	public PerformanceDto ticketfianl(PerformanceDto dto)
	{
		return dao.ticketfianl(dto);
	}
//	결제 후 티켓 발행 좌석
	public List<PerformanceDto> ticketfianlseat(PerformanceDto dto)
	{
		return dao.ticketfianlseat(dto);
	}
	
//	결제 취소 시 좌석정보 조회
	public List<String> ticketseatList(PerformanceDto dto)
	{
		return dao.ticketseatList(dto);
	}
//	결제 취소 시 좌석정보 활성화
	public int ticketseatupt(PerformanceDto dto)
	{
		return dao.ticketseatupt(dto);
	}
//	결제 취소 티켓태이블 ny변경
	public int ticketuptdel(PerformanceDto dto)
	{
		return dao.ticketuptdel(dto);
	}
//	결제 취소 좌석 정보 ny변경
	public int tickerseatuptdel(PerformanceDto dto)
	{
		return dao.tickerseatuptdel(dto);
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
