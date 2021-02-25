package com.muldel.biz;

import java.util.List;

import com.muldel.dao.MDBoardDao;
import com.muldel.dao.MDBoardDaoImpl;
import com.muldel.dto.MDBoardDto;

public class MDBoardBizImpl implements MDBoardBiz {

	private MDBoardDao dao = new MDBoardDaoImpl();
	
	
	@Override
	public List<MDBoardDto> selectList() {
		return dao.selectList();
	}

	@Override
	public MDBoardDto selectOne(int seq) {
		return dao.selectOne(seq);
	}

	@Override
	public int insert(MDBoardDto dto) {
		return dao.insert(dto);
	}

	@Override
	public int update(MDBoardDto dto) {
		return dao.update(dto);
	}

	@Override
	public int delete(int seq) {
		return dao.delete(seq);
	}

	@Override
	public int multidelete(String[] seq) {
		// executeBatch 쓰지말고 반복문으로 닫아주면 안될까? 
		// -> 안됨
		// 메모리가 공간이 무한한데 처리만 늦어지는건가요 아니면 
		// 공간자체가 한정되어서 처리가 될수 없는건가요?
		// -> 후자
		return dao.multidelete(seq);
	}

}
