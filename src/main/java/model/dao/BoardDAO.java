package model.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import common.JDBConnect;
import model.dto.BoardDTO;

public class BoardDAO extends JDBConnect {

	public BoardDAO(ServletContext application) {
		super(application);
	}
	//index.jps에있는 게시판에 상위 게시물 5개 가져오는 메서드
	public List<BoardDTO> selectHome() {
		List<BoardDTO> list = new ArrayList<>();
		String query = "SELECT ROWNUM, A.* "
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
	
	//총 게시물 개수 구하는 메서드
	public int allContents() {
		String query = "SELECT COUNT(*) as allContent FROM board";
		BoardDTO dto = new BoardDTO();
		int num = 0;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			
			rs.next();
			
			dto.setAllContents(rs.getString("allContent"));
			num = Integer.parseInt(dto.getAllContents());
			
		} catch (Exception e) {
			System.out.println("allContents() 예외");
			e.printStackTrace();
		}
		close();
		
		return num;
		
	}//allContents()
	
	//list.jsp에 게시판 리스트 불러오는 메서드
	public List<BoardDTO> selectList(Map<String, Object> map) {
		List<BoardDTO> list = new ArrayList<>();
		String query = "SELECT * FROM ( "
					+ "	FROM ( "
						+ " SELECT ROWNUM AS list, A.* "
						+ " FROM ( "
							+ " SELECT b.cNum, b.title, m.userId, b.writeDate, b.visitNum "
							+ " FROM board b, member m "
							+ " WHERE b.uNum = m.uNum "
							+ " ORDER BY cNum DESC "
						+ " ) A "
					+ " ) "
					+ " WHERE list BETWEEN ? AND ? ";
		
		try {  
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, map.get("start").toString());
			pstmt.setString(2, map.get("end").toString());
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				BoardDTO dto = new BoardDTO();
				
				dto.setcNum(rs.getString("cNum"));
				dto.setTitle(rs.getString("title"));
				dto.setUserId(rs.getString("userId"));
				dto.setWriteDate(rs.getString("writeDate"));
				dto.setVisitNum(rs.getString("visitNum")); 
				
				list.add(dto);
			}//while
			
		} catch (Exception e) {
			System.out.println("selectList()중 예외 발생");
			e.printStackTrace();
		}
		
		return list;
		
	}//selectList()
	

}
