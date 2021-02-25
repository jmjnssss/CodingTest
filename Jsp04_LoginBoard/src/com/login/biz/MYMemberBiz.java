package com.login.biz;

import java.util.List;

import com.login.dao.MYMemberDao;
import com.login.dto.MYMemberDto;

public class MYMemberBiz {
	
		/*
		 * 
		 *  MYMember dao; (속성)
		 *  
		 *  public MYMemberBiz(){
		 *  	dao = new MYMemberDao();
		 *  }
		 *  원래 이렇게 써야함 
		 *  
		 */
	
		MYMemberDao dao = new MYMemberDao();

		
		public List<MYMemberDto> selectAllUser(){
			return dao.selectAllUser();
		}
		// 2. 전체정보(탈퇴안한)
		public List<MYMemberDto> selectEnableduser(){
			return dao.selectEnableduser();
		}
		// 3. 회원 등급 조정
		public int updateRole(int myno, String myrole) {
			return dao.updateRole(myno, myrole);
		}




		/*
		 * 사용자(USER) 기능
		 * 1. 로그인
		 * 3. 회원가입 <- 2. 아이디 중복체크
		 * 4. 내 정보 조회
		 * 5. 내 정보 수정
		 * 6. 회원 탈퇴 (delete 안쓸것! update : myenabled를 n으로 바꾸자.)
		 */

		// 1. 로그인
		public MYMemberDto login(String myid, String mypw) {
			return dao.login(myid, mypw);
		}
		
		// 2. 중복체크
		public MYMemberDto idCheck(String myid) {
			return dao.idCheck(myid);
		}

		// 3. 회원가입
		public int insertUser(MYMemberDto dto) {
			return dao.insertUser(dto);
		}
		
		// 4. 정보 조회
		public MYMemberDto selectUser(int myno) {
			return dao.selectUser(myno);
		}
		
		// 5. 정보 수정
		public int updateUser(MYMemberDto dto) {
			return dao.updateUser(dto);
		}
		
		// 6. 회원 탈퇴 (update)
		public int deleteUser(int myno) {
			return dao.deleteUser(myno);
		}




	

}
