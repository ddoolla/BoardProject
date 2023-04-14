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
			dto.setPhone(rs.getString("phone"));
			dto.setEmail(rs.getString("email"));
			

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
	
	//회원정보 변경
	public int updateJoin(MemberDTO dto) {
		String query = "UPDATE member "
				+ " SET userPass = ? "
				+ " , name = ? "
				+ " , phone = ? "
				+ " , email = ? "
				+ " WHERE userId = ? ";
		int num = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, dto.getUserPass());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getPhone());
			pstmt.setString(4, dto.getEmail());
			pstmt.setString(5, dto.getUserId());
			
			num = pstmt.executeUpdate(); //업뎃 성공시 1저장
			
		} catch (Exception e) {
			System.out.println("updateJoin()중 예외");
			e.printStackTrace();
		}
		
		return num;
		
	}
}


















