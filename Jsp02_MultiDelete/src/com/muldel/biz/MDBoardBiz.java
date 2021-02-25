package com.muldel.biz;

import java.util.List;

import com.muldel.dto.MDBoardDto;

// dao랑 biz를 습관적으로 만들도록 하자..
public interface MDBoardBiz {
	
	public List<MDBoardDto> selectList();	// 여러줄 dto에 받아주니까 (여러줄 받아서 List 로 관리)
	public MDBoardDto selectOne(int seq);	// 번호(pk)를 조건으로 가져올 거
	public int insert(MDBoardDto dto);		// 
	public int update(MDBoardDto dto);
	public int delete(int seq);
	
	public int multidelete(String[] seq);
	
	
}
