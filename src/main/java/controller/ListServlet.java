package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Paging;
import model.dao.BoardDAO;
import model.dto.BoardDTO;

@WebServlet("/view/list.do")
public class ListServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		ServletContext application = this.getServletContext();
		BoardDAO dao = new BoardDAO(application);
		Map<String, Object> map = new HashMap<>();
		
		//검색
		String searchTitle = req.getParameter("searchTitle");
		req.setAttribute("searchTitle", searchTitle);
		map.put("searchTitle", searchTitle);
		
		//페이징 시작
		int pageSize = 10;
		
		int pageNum = 1; //기본 1페이지
		int allContents = dao.allContents(map);
		String pageTemp = req.getParameter("pageNum"); //페이지 번호 클릭하면 쿼리스트링으로 요청하는 파라미터
		if (pageTemp != null && !pageTemp.equals("")) {
			pageNum = Integer.parseInt(pageTemp); 
		}
		
		int start = (pageNum - 1) * pageSize + 1; //rownum 쿼리에 들어갈 시작번호
		int end = pageNum * pageSize; //끝번호
		map.put("start", start);
		map.put("end", end);
		
		String pagingStr = Paging.pagingStr(allContents, pageNum, searchTitle);
		req.setAttribute("pagingStr", pagingStr);
		//페이징 끝
		
		//게시물 번호 (전체조회는 상관없는데 검색했을 때 게시물 번호가 순서대로 나오는게 아니라 각자 가지고있는 시퀀스넘버가 나와서 가상의 번호를 사용해야한다.) 
		req.setAttribute("totalNum", allContents);
		req.setAttribute("pageNum", pageNum);
		
		List<BoardDTO> lists = dao.selectList(map);
		dao.close();
		
		req.setAttribute("lists", lists);
		
		req.getRequestDispatcher("/view/list.jsp").forward(req, resp);
	}
}

