package ohgym.userrequest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.RepaintManager;

@WebServlet("/userreq")
public class UserRequestServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/userrequest.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("POST");
		try {
			resp.setContentType("text/plain");
			resp.setCharacterEncoding("UTF-8");
			
			String requestData = req.getReader().lines().reduce("", (accumulator, actual) -> accumulator + actual);
			String[] arr = requestData.replaceAll("[\\[\\]{}\"]", "").split(",");

			HttpSession session = req.getSession();
			String user_id = (String) session.getAttribute("id");
			
			UserRequestService service = new UserRequestServiceImpl(new UserRequestDAOImpl());
			if (user_id != null) {
				service.requestAdd(user_id, arr[39], arr[38]);
				service.requestAnswerAdd(arr);
			}
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	}
}