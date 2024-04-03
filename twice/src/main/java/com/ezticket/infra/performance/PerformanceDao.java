package com.ezticket.infra.performance;

import java.util.List;


public interface PerformanceDao {
//	관리자 리스트
	public List<PerformanceDto> selectList(PerformanceVo vo);
	
//	사용자 리스트
	public List<PerformanceDto> usrselectList(PerformanceVo vo);
	
//	사용자 랭킹 리스트
	public List<PerformanceDto> usrselectRanking(PerformanceVo vo);
	
//	결제 완료 리스트
	public List<PerformanceDto> usrselectPay(PerformanceVo vo);
	
	
//	공연 몇관에 대한 리스트
	public List<PerformanceDto> tabookList(PerformanceVo vo);
	
//	공연 날짜/시간
	public List<PerformanceDto> bookOneList(PerformanceVo vo);
	
//	배우 리스트
	public List<PerformanceDto> castMemberList(PerformanceVo vo);
	public int count(PerformanceVo vo);
	public PerformanceDto selectOne(PerformanceDto dto);
	
	
	public int update(PerformanceDto dto);
	public int insert(PerformanceDto dto);
	public int delete(PerformanceDto dto);
	public int updatedelete(PerformanceDto dto);

}
