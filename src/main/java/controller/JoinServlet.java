package controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDAO;
import model.dto.MemberDTO;

@WebServlet("/view/join.do")
public class JoinServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		ServletContext application = this.getServletContext();
		MemberDAO dao = new MemberDAO(application);
		MemberDTO dto = new MemberDTO();
		
		dto.setUserId(req.getParameter("userId"));
		dto.setUserPass(req.getParameter("userPass"));
		dto.setName(req.getParameter("name"));
		dto.setPhone(req.getParameter("phone"));
		dto.setEmail(req.getParameter("email"));
		
		dao.insertJoin(dto);
		dao.close();
		
		//req.getRequestDispatcher("/view/loginForm.jsp").forward(req, resp);
		//처음에 포워드를 사용했는데 포워드를 사용하면 안된다. DB에 같은 회원가입이 중복해서 들어간 현상이 있어서 찾아보았다.
		//만약 회원가입에 성공해서 로그인 페이지로 포워드를 통해 이동했다면 이전 회원가입 페이지부터 요청한 것이 연결이 되어있는 것이다
		//이 상태에서 새로고침을 누르게 되면 현재 서블릿이 다시한번 동작하여 DB에 변화를 줄 수 있기 때문에 DB변화가 있는 요청은 포워드로 넘기면 안되고 리다이렉트를 사용해야한다.
		//물론 회원가입은 중복방지하는 로직이 있으면 에러가 발생하겠지만, 예를들어 게시글을 작성한 후 완료버튼을눌러 DB에 추가한 후 다음 페이지를 포워드로 이동시킨 후
		//새로고침을 누르면 이전 요청이 살아있어 게시물이 중복해서 DB에 추가될 수 있다.
		
		resp.sendRedirect("/view/loginForm.jsp");
		
		
		
		
	}

}
