package ohgym.request;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import ohgym.teacher.TeacherDAOImpl;
import ohgym.teacher.TeacherService;
import ohgym.teacher.TeacherServiceImpl;
import ohgym.userrequest.RequestInfo;
import ohgym.userrequest.RequestInfoDAOImpl;
import ohgym.userrequest.RequestInfoService;
import ohgym.userrequest.RequestInfoServiceImpl;


@WebServlet("/requestNo")
public class RequestByNoServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int no = Integer.valueOf(req.getParameter("no"));
		RequestService service = new RequestServiceImpl(new RequestDAOImpl());
		TeacherService teacherService = new TeacherServiceImpl(new TeacherDAOImpl());
		RequestInfoService requestinfo = new RequestInfoServiceImpl(new RequestInfoDAOImpl());
		
		Request request = service.selectRequestByNo(no);
		RequestInfo requestInfo = requestinfo.selectRequestInfoByNo(no);
		System.out.println("왓냐?" + requestInfo.getAnswer1());
	//	RequestFind requestFind = new RequestFind();
	//	requestFind.requestAnswerFind(no);
		
//		Object[] arr = new Object[]{request, requestFind};
//		
//		ObjectMapper mapper = new ObjectMapper();
//		String json = mapper.writeValueAsString(arr);
//	 
//		PrintWriter pw = resp.getWriter();
//		pw.println(json);
//		pw.flush();
		req.setAttribute("request", request);
		System.out.println("먼값 넘어감?"+request);
	//	req.setAttribute("requestFind", requestFind);
		req.getRequestDispatcher("/views/suggest.jsp").forward(req, resp);
	}
}
