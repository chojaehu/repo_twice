package com.ezticket.infra.performance;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezticket.infra.code.CodeDto;

@Service
public class PerformanceService {
	
	@Autowired
	PerformanceDao dao;
	
	public List<PerformanceDto> selectList(PerformanceVo vo)
	{
		return dao.selectList(vo);
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

}
