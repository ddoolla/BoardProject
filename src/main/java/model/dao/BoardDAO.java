package model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import common.JDBConnect;
import model.dto.BoardDTO;

public class BoardDAO extends JDBConnect {

	public BoardDAO(ServletContext application) {
		super(application);
	}
	//index.jps에있는 게시판에 상위 게시물 5개 가져오는 메서드
	public List<BoardDTO> selectMain() {
		List<BoardDTO> list = new ArrayList<>();
		String query = "SELECT ROWNUM, A.* "
				+ " FROM ( "
				+ " SELECT m.userId, b.title, TO_CHAR(b.writeDate, 'yyyy-MM-dd') writeDate "
				+ " FROM member m, board b "
				+ " WHERE m.uNum = b.uNum "
				+ " ORDER by b.cNum desc) A "
				+ " WHERE ROWNUM <= 5 ";
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				BoardDTO dto = new BoardDTO();
				
				dto.setUserId(rs.getString("userId"));
				dto.setTitle(rs.getString("title"));
				dto.setWriteDate(rs.getString("writeDate"));
				
				list.add(dto);
			}//while
			
			close();
			
		} catch (Exception e) {
			System.out.println("selectMain()중 예외발생");
			e.printStackTrace();
		}
		
		return list;
		
	}//selectMain()
	
	//list.jsp에 게시판 리스트 불러오는 메서드
	public List<BoardDTO> selectList() {
		List<BoardDTO> list = new ArrayList<>();
		String query = "select b.cNum, b.title, m.userId, b.writeDate, b.visitNum "
				+ " from board b, member m "
				+ " where b.uNum = m.uNum "
				+ " order by b.cNum desc";
		
		try {  
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				BoardDTO dto = new BoardDTO();
				
				dto.setcNum(rs.getString("cNum"));
				dto.setTitle(rs.getString("title"));
				dto.setUserId(rs.getString("userId"));
				dto.setWriteDate(rs.getString("writeDate"));
				dto.setVisitNum(rs.getString("visitNum")); 
				
				list.add(dto);
			}//while
			
			close();
		} catch (Exception e) {
			System.out.println("selectList()중 예외 발생");
			e.printStackTrace();
		}
		
		return list;
		
	}//selectList()
	

}
