package model.dao;

import javax.servlet.ServletContext;

import common.DBManager;
import model.dto.MemberDTO;

public class MemberDAO extends DBManager {

	public MemberDAO(ServletContext application) {
		super(application);
	}

	// 로그인 확인
	public MemberDTO loginCheck(String userId) {
		MemberDTO dto = new MemberDTO();

		String query = "SELECT * FROM member " + " WHERE userId = '" + userId + "'";

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);

			rs.next();

			dto.setUserId(rs.getString("userId"));
			dto.setUserPass(rs.getString("userPass"));
			dto.setName(rs.getString("name"));

		} catch (Exception e) {
			System.out.println("loginCheck()중 예외");
			e.printStackTrace();
		}

		return dto;

	}// loginCheck

	// 회원가입 저장
	public int insertJoin(MemberDTO dto) {
		
		String query = "INSERT INTO member VALUES (seq_mem_num.nextval, ?, ?, ?, ?, ?) ";
		int num = 0;

		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, dto.getUserId());
			pstmt.setString(2, dto.getUserPass());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getPhone());
			pstmt.setString(5, dto.getEmail());

			num = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("insertJoin()중 예외");
			e.printStackTrace();
		}

		return num;
		
	}//insertJoin()
	
	
}


















