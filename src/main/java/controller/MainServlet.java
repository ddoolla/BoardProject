package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.BoardDAO;
import model.dto.BoardDTO;
@WebServlet("/")
public class MainServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8"); 
		resp.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		
		ServletContext application = this.getServletContext();
		BoardDAO dao = new BoardDAO(application);
		
		List<BoardDTO> lists = dao.selectMain();
		//req.setAttribute("mainLists", lists);
		session.setAttribute("mainLists", lists);
		
		//req.getRequestDispatcher("/view/index.jsp").forward(req, resp); 
		resp.sendRedirect("/view/index.jsp");
	}
}
