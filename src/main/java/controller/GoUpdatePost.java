package controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.BoardDAO;
import model.dto.BoardDTO;

@WebServlet("/view/goUpdatePost.do")
public class GoUpdatePost extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		ServletContext application = this.getServletContext();
		BoardDAO dao = new BoardDAO(application);
		String cNum = req.getParameter("cNum");
		
		BoardDTO dto = dao.selectTitle(cNum);
		req.setAttribute("BoardDTO", dto);
		
		req.getRequestDispatcher("/view/updatePostForm.jsp").forward(req, resp);
	}
}




















