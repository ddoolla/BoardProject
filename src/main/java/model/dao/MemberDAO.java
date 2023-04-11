package model.dao;

import javax.servlet.ServletContext;

import common.DBManager;
import model.dto.MemberDTO;

public class MemberDAO extends DBManager {

	public MemberDAO(ServletContext application) {
		super(application);
	}
	
	//로그인 확인
	public MemberDTO loginCheck(String userId) {
		MemberDTO dto = new MemberDTO();
		
		String query = "SELECT * FROM member "
				+ " WHERE userId = '" + userId + "'";
		
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
		
		//회원가입 저장
		
	}//loginCheck
	
}
