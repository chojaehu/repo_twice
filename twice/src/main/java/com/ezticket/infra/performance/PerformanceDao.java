package com.ezticket.infra.performance;

import java.util.List;

public interface PerformanceDao {
	
	public List<PerformanceDto> selectList(PerformanceVo vo);
	public PerformanceDto selectOne(PerformanceDto dto);

}
