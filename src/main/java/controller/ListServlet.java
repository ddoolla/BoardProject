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
		//페이징 기능
		int pageSize = 10;
		
		
		int pageNum = 1;
		int allContents = dao.allContents();
		String pageTemp = req.getParameter("pageNum"); //페이지 번호 클릭하면 쿼리스트링으로 요청하는 파라미터
		if (pageTemp != null && !pageTemp.equals("")) {
			pageNum = Integer.parseInt(pageTemp); 
		}
		
		int start = (pageNum - 1) * pageSize + 1;
		int end = pageNum * pageSize;
		map.put("start", start);
		map.put("end", end);
		
		String pagingStr = Paging.pagingStr(allContents, pageNum);
		req.setAttribute("pagingStr", pagingStr);	
		
		List<BoardDTO> lists = dao.selectList(map);
		//dao.close();
		
		req.setAttribute("lists", lists);
		
		req.getRequestDispatcher("/view/list.jsp").forward(req, resp);
	}
}
