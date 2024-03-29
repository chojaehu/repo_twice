package com.ezticket.infra.performance;

import java.util.List;


public interface PerformanceDao {
	
	public List<PerformanceDto> selectList(PerformanceVo vo);
	public int count(PerformanceVo vo);
	public PerformanceDto selectOne(PerformanceDto dto);
	
	
	public int update(PerformanceDto dto);
	public int insert(PerformanceDto dto);

}
