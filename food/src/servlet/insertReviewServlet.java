package servlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.ReviewDAO;
import dao.ReviewDAO_Oracle;
import service.ReviewService;
import service.ReviewServiceImpl;
import vo.ReviewVO;

@WebServlet("/insertReview.do")
public class insertReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		System.out.println("/insertBook.do 요청 처리"); 
		
	
		ReviewDAO dao = new ReviewDAO_Oracle();
		ReviewService service = new ReviewServiceImpl(dao);
		
		ReviewVO vo = new ReviewVO();
		vo.setUserid(request.getParameter("userid"));
		vo.setFid(Integer.parseInt(request.getParameter("fid")));
		vo.setText(request.getParameter("text"));
		vo.setEval(request.getParameter("eval"));
		
		
		String path = request.getRealPath("/upload/");
		
		Collection<Part> parts = request.getParts();
		for(Part p : parts) {
			if(p.getContentType() != null) {
				String fileName = p.getSubmittedFileName();
				if(fileName != null && fileName.length() != 0) {
					p.write(path+fileName);
					vo.setImage("./upload/"+fileName);
					System.out.println(vo);
				}
			}
		}
		
		
		try {
			service.addReview(vo);			
			response.sendRedirect("listReview.do"); // 등록한 책을 리스트에 넣어 출력   응답이 가고 재요청이 오는게 sendRedirect
		} catch (Exception e) {
			
			request.setAttribute("exception", new Exception("등록 데이터 확인 후 다시 등록하세요 "));
			getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
		}
	}

}
