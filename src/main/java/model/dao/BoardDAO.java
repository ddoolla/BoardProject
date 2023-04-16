package model.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import common.DBManager;
import model.dto.BoardDTO;

public class BoardDAO extends DBManager {

	public BoardDAO(ServletContext application) {
		super(application);
	}
	
	//home.jsp에 작은사진 3장 가져오기
	public List<BoardDTO> selectSmallPic() {
		List<BoardDTO> list = new ArrayList<>();
		String query = "SELECT ROWNUM, sq.* "
				+ " FROM ( "
				+ " SELECT b.*, m.userId FROM board b, member m "
				+ " WHERE b.uNum = m.uNum "
				+ " AND newNameFile IS NOT NULL "
				+ " ORDER BY writeDate desc) sq "
				+ " WHERE ROWNUM <= 3 ";
		
				
				
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				BoardDTO dto = new BoardDTO();
				
				dto.setcNum(rs.getString("cNum"));
				dto.setUserId(rs.getString("userId"));
				dto.setTitle(rs.getString("title"));
				dto.setWriteDate(rs.getString("writeDate").substring(0, 10));
				dto.setNewNameFile(rs.getString("newNameFile"));
				
				list.add(dto);
				
			}
			
		} catch (Exception e) {
			System.out.println("selectSmallPic()중 예외");
			e.printStackTrace();
		}
		
		return list;
		
	}//selectSmallPic
	
	//home.jsp에있는 게시판에 상위 게시물 5개 가져오는 메서드
	public List<BoardDTO> selectHome() {
		List<BoardDTO> list = new ArrayList<>();
		String query = "SELECT ROWNUM, A.* FROM ( "
				+ " SELECT b.cNum, m.userId, b.title, TO_CHAR(b.writeDate, 'yyyy-MM-dd') writeDate "
				+ " FROM member m, board b "
				+ " WHERE m.uNum = b.uNum "
				+ " ORDER by b.cNum desc) A "
				+ " WHERE ROWNUM <= 5 "; //생각해보니깐 내가 필요한거만 어렵게 조인할게 아니라 *로 다 불려와서 필요한거만 써도 될 듯? ....
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				BoardDTO dto = new BoardDTO();
				
				dto.setcNum(rs.getString("cNum"));
				dto.setUserId(rs.getString("userId"));
				dto.setTitle(rs.getString("title"));
				dto.setWriteDate(rs.getString("writeDate"));
				
				list.add(dto);
			}//while
			
		} catch (Exception e) {
			System.out.println("selectMain()중 예외발생");
			e.printStackTrace();
		}
		
		return list;
		
	}//selectHome()
	
	//총 게시물 개수 구하는 메서드
	public int allContents(Map<String, Object> map) {
		String query = "SELECT COUNT(*) as allContent FROM board ";
		if (map.get("searchTitle") != null) { //검색어가 있을 경우 추가 쿼리
			query += " WHERE title LIKE '%" + map.get("searchTitle").toString() + "%'";
		}
		int num = 0;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			
			rs.next();
			
			num = Integer.parseInt(rs.getString("allContent"));
			
		} catch (Exception e) {
			System.out.println("allContents() 예외");
			e.printStackTrace();
		}
		
		return num;
		
	}//allContents()
	
	//list.jsp에 게시판 리스트 불러오는 메서드
	public List<BoardDTO> selectList(Map<String, Object> map) {
		List<BoardDTO> list = new ArrayList<>();
		String query = "SELECT * FROM ( "
						+ " SELECT ROWNUM AS list, A.* "
						+ " FROM ( "
							+ " SELECT b.cNum, b.title, m.userId, b.writeDate, b.visitNum "
							+ " FROM board b, member m "
							+ " WHERE b.uNum = m.uNum ";
						//검색어가 있다면 추가할 쿼리
						if (map.get("searchTitle") != null) {
							query += " AND title LIKE '%" + map.get("searchTitle") + "%' ";
						}
					query += " ORDER BY cNum DESC "
						+ " ) A "
					+ " ) "
					+ " WHERE list BETWEEN ? AND ? ";
		
// 검색 기능 없는 쿼리		
//		String query = "SELECT * FROM ( "
//				+ " SELECT ROWNUM AS list, A.* "
//				+ " FROM ( "
//					+ " SELECT b.cNum, b.title, m.userId, b.writeDate, b.visitNum "
//					+ " FROM board b, member m "
//					+ " WHERE b.uNum = m.uNum "
//					+ " ORDER BY cNum DESC "
//				+ " ) A "
//			+ " ) "
//			+ " WHERE list BETWEEN ? AND ? ";
		
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
	
	//title 누르면 상세보기 기능
	public BoardDTO selectTitle(String cNum) {
		
		BoardDTO dto = new BoardDTO();
		
		String query = "SELECT * "
				+ " FROM board b, member m "
				+ " WHERE b.uNum = m.uNum "
				+ " AND cNum = " + cNum; 

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			
			rs.next();
			
			dto.setcNum(rs.getString("cNum"));
			dto.setTitle(rs.getString("title"));
			dto.setUserId(rs.getString("userId"));
			dto.setWriteDate(rs.getString("writeDate"));
			dto.setContent(rs.getString("content"));
			dto.setVisitNum(rs.getString("visitNum"));
			dto.setOriginalFile(rs.getString("originalFile"));
			dto.setNewNameFile(rs.getString("newNameFile"));
			
		} catch (Exception e) {
			System.out.println("selectTitle 중 예외발생");
			e.printStackTrace();
		}
		
		return dto;
				
	}//selectTitle()
	
	//상세보기 페이지 클릭시 조회수 1증가 
	public void updateVisitNum(String cNum) {
		String query = "Update board SET visitNum = visitNum + 1" 
				+ " WHERE cNum = " + cNum;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("updateVisitNum()중 예외");
			e.printStackTrace();
		}
		
	}//updateVisitNum()
	
	//게시물 작성한거 디비저장
	public int insertWrite(BoardDTO dto) {
		int num = 0;
		String query = "INSERT INTO board ";
		if (dto.getOriginalFile() != null && dto.getNewNameFile() != null) { //파일을 입력 했으면 추가 
			query += " (cNum, uNum, title, content, originalFile, newNameFile) "
					+ " VALUES (seq_cont_num.nextval, ?, ?, ?, ?, ?) ";
		} else { //입력 안했으면 추가
			query += " (cNum, uNum, title, content) "
					+ " VALUES (seq_cont_num.nextval, ?, ?, ?) ";
		}
	
		try {
			pstmt = conn.prepareStatement(query);
			
			if (dto.getOriginalFile() != null && dto.getNewNameFile() != null) {
				pstmt.setString(1, dto.getuNum());
				pstmt.setString(2, dto.getTitle());
				pstmt.setString(3, dto.getContent());
				pstmt.setString(4, dto.getOriginalFile());
				pstmt.setString(5, dto.getNewNameFile());
				
			} else {
				pstmt.setString(1, dto.getuNum());
				pstmt.setString(2, dto.getTitle());
				pstmt.setString(3, dto.getContent());
			}
			
			num = pstmt.executeUpdate(); //insert 성공하면 1저장
			
		} catch (Exception e) {
			System.out.println("insertWrite()중 예외");
			e.printStackTrace();
		}
		
		return num;
		
	}//insertWrite
	
	
	//게시물 수정 메서드
	public int updateWrite(BoardDTO dto) {
		String query = "UPDATE board "
				+ " SET title = '" + dto.getTitle() + "' "
				+ " , content = '" + dto.getContent() + "' ";
		if ((dto.getOriginalFile() != null) && (dto.getNewNameFile() != null)) {
			query += " , originalFile = '" + dto.getOriginalFile() + "' "
				+ " , newNameFile = '" + dto.getNewNameFile() + "' ";
		}
		query += " WHERE cNum = '" + dto.getcNum() + "'";
		
		int num = 0;
		
		try {
			stmt = conn.createStatement();
			num = stmt.executeUpdate(query); //업데이트 성공시 1저장
			
		} catch (Exception e) {
			System.out.println("updateWrite()중 예외");
			e.printStackTrace();
		}
		
		return num;
		
	}//updateWrite
}

























