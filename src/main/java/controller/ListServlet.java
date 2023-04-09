package controller;

import java.io.IOException;
import java.util.List;

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
		
		//페이징 기능 
		int pageNum = 1;
		int allContents = dao.allContents();
		String pagingStr = Paging.pagingStr(allContents, pageNum);
		req.setAttribute("pagingStr", pagingStr);
		
		
		
		List<BoardDTO> lists = dao.selectList();
		req.setAttribute("lists", lists);
		
		req.getRequestDispatcher("/view/list.jsp").forward(req, resp);
	}
}
