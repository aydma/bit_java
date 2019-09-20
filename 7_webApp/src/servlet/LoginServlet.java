package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet({"/login.do","/logout.do"}) // post로 들어오면 login , get방식으로 들어오면 logout
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session != null) {
			session.invalidate(); // 세션객체파괴
		}
		response.sendRedirect("./index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		System.out.println("/login.do 요청 처리"); 
		System.out.println(id+"/"+pw); 
		
		if(id==null||pw==null||id.length()==0||pw.length()==0) {
//			response.sendRedirect("./login.jsp");
			request.setAttribute("msg", "pw 정보를 입력하세요");
			request.setAttribute("id", id); // login.jsp로 돌아갔을때 입력했던 아이디 살림
			request.getRequestDispatcher("login.jsp").forward(request, response); // request로 login.jsp에 접근한다.
			return;
		}
		if(id.equals("java01") && pw.equals("1234")) {
			HttpSession session = request.getSession();
			session.setAttribute("login", id+"/홍자바");
			
			request.getRequestDispatcher("index.jsp").forward(request, response); 
			
		}else {
			request.setAttribute("msg", "로그인 실패");
			request.setAttribute("id", id); 
			
			request.getRequestDispatcher("login.jsp").forward(request, response); 
		}
	}
}
