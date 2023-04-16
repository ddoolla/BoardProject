package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.MemberDAO;
import model.dto.MemberDTO;

@WebServlet("/view/updateJoin.do")
public class UpdateJoinServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		ServletContext application = this.getServletContext();
		
		MemberDTO dto = new MemberDTO();
		MemberDAO dao = new MemberDAO(application);
		
		dto.setUserId(req.getParameter("userId"));
		dto.setUserPass(req.getParameter("userPass"));
		dto.setName(req.getParameter("name"));
		dto.setPhone(req.getParameter("phone"));
		dto.setEmail(req.getParameter("email"));
		
		int num = dao.updateJoin(dto); //회원정보 변경 성공하면 1저장
		dao.close();
		
		PrintWriter out = resp.getWriter();
		
		if (num == 1) { //회원정보 변경 성공 시
			HttpSession session = req.getSession();
			session.removeAttribute("loginOK"); //회원정보가 변경되면 세션을 죽여서 다시 로그인하게
			
			String jsFunc = "<script>"
					+ " alert('회원정보가 변경되었습니다. 다시 로그인 해주세요.'); "
					+ " location.href='/view/loginForm.jsp'; "
					+ " </script>";
			
			out.print(jsFunc);
			
		} else {//정보 변경 실패시 
			String jsFunc = "<script>"
					+ " alert('회원정보 변경에 실패했습니다.'); "
					+ " location.href='/view/updateJoinForm.jsp'; "
					+ " </script>";
			
			out.print(jsFunc);
		}
		
		
		
	}//doPost
}





















