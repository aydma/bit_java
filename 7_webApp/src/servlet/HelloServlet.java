package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/hello", "/hello.do" },loadOnStartup = 1) //요청이 오기전에 메모리에 띄움
//@WebServlet({ "/hello", "/hello.do" })
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HelloServlet() {
        System.out.println("HelloServlet() 객체 생성");
    }

	public void init(ServletConfig config) throws ServletException { // 초기화작업
		System.out.println("init() 호출");
		
	}

	public void destroy() { // 자원반납
		System.out.println("destroy() 호출");
	}
/*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8"); //인코딩 타입 변경해서 한글 출력
		
		System.out.println("doGet() 호출");	// 겟방식이라 리로드 될때마다 수행	
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		out.print("<h1>HelloServlet Page 입니다.</h1>"); // 웹브라우저에 출력
		
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		out.print("<h1>"+name+"||"+id+"</h1>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8"); // post방식은 한글이 깨져서 request로 요청이들어온 값의 인코딩 타입을 변경해준다.
		
		System.out.println("doPost() 호출"); // 폼태그로 호출해야 출력
		
		response.getWriter().append("Served at: ").append(request.getContextPath());// request.getContextPath()는 7_webApp을 의미		
		PrintWriter out = response.getWriter();
		out.print("<h1>HelloServlet Page 입니다.</h1>");
		
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		out.print("<h1>"+name+"||"+id+"</h1>");
	}
*/
	// service로 하면 get/post 둘다 처리해준다.
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8"); // post방식은 한글이 깨져서 request로 요청이들어온 값의 인코딩 타입을 변경해준다.
		
		System.out.println("service() 호출"); // 폼태그로 호출해야 출력
		
		response.getWriter().append("Served at: ").append(request.getContextPath());// request.getContextPath()는 7_webApp을 의미		
		PrintWriter out = response.getWriter();
		out.print("<h1>HelloServlet Page 입니다.</h1>");
		
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		out.print("<h1>"+name+"||"+id+"</h1>");
	}
}
