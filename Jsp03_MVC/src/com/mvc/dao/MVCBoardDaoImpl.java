package com.mvc.dao;

import static com.mvc.db.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mvc.dto.MVCBoardDto;

import static com.mvc.db.JDBCTemplate.*;

public class MVCBoardDaoImpl implements MVCBoardDao {

	public List<MVCBoardDto> selectList(){
		
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<MVCBoardDto> list = new ArrayList<MVCBoardDto>();
		
		try {
			pstm = con.prepareStatement(SELECT_LIST_SQL);
			System.out.println("3. query 준비 : " + INSERT_SQL);
			
			rs = pstm.executeQuery();
			System.out.println("4. query 실행 및 리턴");
			while(rs.next()) {
				
				MVCBoardDto dto = new MVCBoardDto();
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
			System.out.println("5. db종료");
		}

		return list;
	}

	@Override
	public MVCBoardDto selectOne(int seq) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;


		
		MVCBoardDto dto = new MVCBoardDto();
		
		try {
			pstm = con.prepareStatement(SELECT_ONE_SQL);
			pstm.setInt(1, seq);
			System.out.println("3. query 준비 : " + SELECT_ONE_SQL);
			
			rs = pstm.executeQuery();
			System.out.println("4. query 실행 및 리턴");
			while(rs.next()) {
				dto.setSeq(rs.getInt("SEQ"));
				dto.setWriter(rs.getString("WRITER"));
				dto.setTitle(rs.getString("TITLE"));
				dto.setContent(rs.getString("CONTENT"));
				dto.setRegdate(rs.getDate("REGDATE"));
				// 1,2,3,4,5 숫자로 할 땐 순서대로 해야하지만
				// 문자로 쓰면 어차피 컬럼 값 가져와서 저장하는거라서 순서 상관X
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstm, con);
			System.out.println("5. db종료");
		}
		
		return dto;
	}

	@Override
	public int insert(MVCBoardDto dto) {
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
	public int update(MVCBoardDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(UPDATE_SQL);
			
			pstm.setString(1, dto.getTitle());
			pstm.setString(2, dto.getContent());
			pstm.setInt(3, dto.getSeq());
			System.out.println("3. query 준비 : " + UPDATE_SQL);
			
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
}