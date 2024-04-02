package com.ezticket.infra.performance;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezticket.infra.code.CodeDto;

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
	public int count(PerformanceVo vo) {
		return dao.count(vo);
	}
	public PerformanceDto selectOne(PerformanceDto dto)
	{
		return dao.selectOne(dto);
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
