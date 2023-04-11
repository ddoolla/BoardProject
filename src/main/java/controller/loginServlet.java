package controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.MemberDAO;
import model.dto.MemberDTO;

@WebServlet("/view/loginServlet.do")
public class loginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		
		ServletContext application = this.getServletContext();
		HttpSession session = req.getSession();
		
		String userId = req.getParameter("userId");
		String userPass = req.getParameter("userPass");
		
		MemberDAO dao = new MemberDAO(application);
		MemberDTO dto = dao.loginCheck(userId);
		
		if (userId.equals(dto.getUserId()) && userPass.equals(dto.getUserPass())) {
			session.setAttribute("loginOK", dto);
			resp.sendRedirect("/view/home.do");
		} else {
			//여기는 session으로 보내면 안될듯 ?
			session.setAttribute("message", "아이디 또는 비밀번호를 확인하세요.");
			resp.sendRedirect("/view/loginForm.jsp");
		}
	}

}
