package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/upload1.do")
@MultipartConfig(location = "c:/upload",maxFileSize = 1024*1024*5) // 파일업로드하는것
public class uploadServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;     
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		System.out.println("/upload1.do 파일업로드처리");
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String myfile = request.getParameter("myfile");
		System.out.println("myfile => "+myfile);
		
		
		
		Collection<Part> parts = request.getParts(); // 파일을 multiple로 여러개 받아서 콜렉션으로 함
		System.out.println("parts => "+parts);
		
		for(Part p : parts) {
			System.out.println("p => "+p);
			if(p.getContentType() != null) {
				String filename = p.getSubmittedFileName();
				if(filename != null) {
					p.write(filename);
					out.print("<h3> 업로드한 파일네임 : "+filename+"</h3>");
					out.print("<h3> 파일 size : "+p.getSize()+"</h3>");
					out.print("<img src='c:/upload/"+filename+"'>");
					
				}
			}
		}				
	}
}
