package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.BoardDAO;
import model.dto.BoardDTO;
@WebServlet("/view/home.do")
public class HomeServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8"); 
		
		ServletContext application = this.getServletContext();
		BoardDAO dao = new BoardDAO(application);
		
		//본문 게시글 5개
		List<BoardDTO> lists = dao.selectHome();
		req.setAttribute("homeLists", lists);
		
		//본문 사진 3장
		List<BoardDTO> smallPicList = dao.selectSmallPic();
		dao.close();
		
		req.setAttribute("smallPicList", smallPicList);
		
		req.getRequestDispatcher("/view/home.jsp").forward(req, resp); 
	}
	
}
