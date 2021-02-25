package com.muldel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.muldel.dto.MDBoardDto;

import static com.muldel.db.JDBCTemplate.*;

public class MDBoardDaoImpl implements MDBoardDao {

	// extends JDBCTemplate 도 가능하지만 import static이 메모리 효율면에서 좋음
	/*
	 	executeQuery()	-> select
	 	executeUpdate() -> in, up, de
	 	executeBatch() 	-> addBatch();
	 
	 */
	@Override
	public List<MDBoardDto> selectList() {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<MDBoardDto> list = new ArrayList<MDBoardDto>();
		
		try {
			pstm = con.prepareStatement(SELECT_LIST_SQL);
			System.out.println("3. query 준비 : "+SELECT_LIST_SQL);
			
			rs = pstm.executeQuery();
			System.out.println("4. query 실행 및 리턴");
			while(rs.next()) {
				MDBoardDto dto = new MDBoardDto();
				// MDBoardDto가 밖에 있으면 마지막에 저장된 dto가 계속 출력됨
				// new MDBoardDto(); 괄호에 밑에꺼 넣어도 됨
				dto.setSeq(rs.getInt(1));
				dto.setWriter(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setRegdate(rs.getDate(5));
				
				list.add(dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
			close(con);
			// close(rs, pstm, con);
			System.out.println("5. db종료");
		}
		
		return list;
	}

	@Override
	public MDBoardDto selectOne(int seq) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;


		// MDBoardDto dto = null; 로 했을 때 차이점 찾아보자
		// npe hell
		MDBoardDto dto = new MDBoardDto();
		
		try {
			pstm = con.prepareStatement(SELECT_ONE_SQL);
			pstm.setInt(1, seq);
			System.out.println("3. query 준비 : "+SELECT_ONE_SQL);
			
			rs = pstm.executeQuery();
			System.out.println("4. query 실행 및 리턴");
			while(rs.next()) {
				dto.setSeq(rs.getInt(1));
				dto.setWriter(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setRegdate(rs.getDate(5));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
			close(con);
			System.out.println("5. db종료");
		}
		
		return dto;
	}

	@Override
	public int insert(MDBoardDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(INSERT_SQL);
			pstm.setString(1, dto.getWriter());
			pstm.setString(2, dto.getTitle());
			pstm.setString(3, dto.getContent());
			System.out.println("3. query 준비 : " + INSERT_SQL);
			
			res = pstm.executeUpdate();
			System.out.println("4. query 실행 및 리턴");
			if (res > 0) {
				commit(con);
				// 내가 원할 때만 저장해주기로 했음 
				// con.setAutoCommit(false);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
			System.out.println("5. db 종료");
		}
		
		
		
		return res;
		
		

	}

	@Override
	public int update(MDBoardDto dto) {
		Connection con = getConnection();
		
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(UPDATE_SQL);
			
			pstm.setString(1, dto.getTitle());
			pstm.setString(2, dto.getContent());
			pstm.setInt(3, dto.getSeq());
			System.out.println("3. query 준비" + UPDATE_SQL);
			
			res = pstm.executeUpdate();
			System.out.println("4. query 실행 및 리턴");
			if (res > 0) {
				commit(con);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
			System.out.println("5. db종료");
		}
		
		return res;
	}

	@Override
	public int delete(int seq) {
Connection con = getConnection();
		
		PreparedStatement pstm = null;
		int res = 0;
	
		try {
			pstm = con.prepareStatement(DELETE_SQL);
			
			pstm.setInt(1, seq);
			System.out.println("3. query 준비 : " + DELETE_SQL);
			
			res = pstm.executeUpdate();
			System.out.println("4. query 실행 및 리턴");
			if(res > 0) {
				commit(con);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con);
			close(pstm);
			System.out.println("5. db종료");
		}
		return res;
	}

	@Override
	public int multidelete(String[] seqs) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		int[] cnt = null;	// int가 아닌 boolean이 더 정확하나 헷갈리니까 일단 int씀
		
		try {
			pstm = con.prepareStatement(DELETE_SQL);
			// 이해를 돕기위해 seq = int(num)으로 하고있지만 String도 가능
			for (int i=0; i < seqs.length; i++) {
				pstm.setString(1, seqs[i]);	// 문자열로 들어가도 되고 int로 들어가도 가능
				// 메모리에 적재해놓고, executeBatch() 메소드가 호출 될 때, 한번에 실행!
				pstm.addBatch();	
				// executeBatch가 없으면 안됨
				// 메모리 어딘가에 우리가 원하는(지울)값을 넣어놓음
				System.out.println("3. query 준비 : "+ DELETE_SQL + "(삭제할 번호 : " + seqs[i] + ")");
				
			}
			
			// 메모리에 적재되어 있는 sql 문들을 한번에 실행!
			// int[] 로 리턴됨! (row 갯수)
			cnt = pstm.executeBatch();
			// 저장되어있는 sql(query)문을 한번에 실행
			System.out.println("4. query 실행 및 리턴");
			
			// -2 : 성공, -3 : 실패
			// 리턴된 결과값
			for(int i=0; i < cnt.length; i++) {
				if(cnt[i] == -2) {
					res++;	// 성공한 갯수 가져오기
				}
			}
			// 갯수 확인 (성공했으니까 commit 하자)
			if (seqs.length == res) {
				commit(con);
			}
			// else syso 갯수확인해주세요 입력 가능
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
		}
		
		return res;
	}

}









