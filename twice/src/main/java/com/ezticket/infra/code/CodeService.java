package com.ezticket.infra.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezticket.infra.paging.pagingDto;

import jakarta.annotation.PostConstruct;

@Service
public class CodeService {
	
	@Autowired
	CodeDao dao;
	
	
	public List<CodeDto> selectList(final CodeVo vo){
		return dao.selectList(vo);
	}
	public int count(CodeVo vo)
	{
		return dao.count(vo);
	}
	public CodeDto selectOne(CodeDto dto)
	{
		return dao.selectOne(dto);
	}
	
	public int insert(CodeDto dto)
	{
		return dao.insert(dto);
	}
	
	public int update(CodeDto dto)
	{
		return dao.update(dto);
	}
	public int delete(CodeDto dto)
	{
		return dao.delete(dto);
	}
	public int updatedelete(CodeDto dto)
	{
		return dao.updatedelete(dto);
	}
	

	
	@PostConstruct
	public void selectListCachedCodeArrayList() throws Exception {
		List<CodeDto> codeListFromDb = (ArrayList<CodeDto>) dao.selectListCachedCodeArrayList();
//		codeListFromDb = (ArrayList<Code>) dao.selectListCachedCodeArrayList();
		CodeDto.cachedCodeArrayList.clear(); 
		CodeDto.cachedCodeArrayList.addAll(codeListFromDb);
		System.out.println("cachedCodeArrayList: " + CodeDto.cachedCodeArrayList.size() + " chached !");
	}
	
	
	public static String selectOneCachedCode(int code) throws Exception {
		String rt = "";
		for(CodeDto codeRow : CodeDto.cachedCodeArrayList) {
			if (codeRow.getIfcdSeq().equals(Integer.toString(code))) {
				rt = codeRow.getIfcdName();
			} else {
				// by pass
			}
		}
		return rt;
	}
	
	public static List<CodeDto> selectListCachedCode(String ifcgSeq) throws Exception {
		List<CodeDto> rt = new ArrayList<CodeDto>();
		for(CodeDto codeRow : CodeDto.cachedCodeArrayList) {
			if (codeRow.getCodegroupIfcgseq().equals(ifcgSeq)) {
				rt.add(codeRow);
			} else {
				// by pass
			}
		}
		return rt;
	}
	
	public PagingResponse<CodeDto> findAllPost(CodeVo vo) {

        // 조건에 해당하는 데이터가 없는 경우, 응답 데이터에 비어있는 리스트와 null을 담아 반환
        int count = dao.count(vo);
        if (count < 1) {
            return new PagingResponse<>( null);
        }

        // Pagination 객체를 생성해서 페이지 정보 계산 후 SearchDto 타입의 객체인 params에 계산된 페이지 정보 저장
        Pagination pagination = new Pagination(count, vo);
        vo.setPagination(pagination);

        // 계산된 페이지 정보의 일부(limitStart, recordSize)를 기준으로 리스트 데이터 조회 후 응답 데이터 반환
        return new PagingResponse<>(pagination);
    }
	
	

}
