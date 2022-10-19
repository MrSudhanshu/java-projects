import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String n = request.getParameter("t1");
		String pwd = request.getParameter("t2");
		PrintWriter out = response.getWriter();
		
		
		response.setContentType("text/html");
		out.println("this is my first servlet");
		if(n.equals("Sudhanshu") && pwd.equals("Bhuvi")) {
			HttpSession hs = request.getSession();
			hs.setAttribute("uname", n);
			response.sendRedirect("success.jsp");
		}
		else {
			out.print("Incorrect Username or Password......Try Again !");
			RequestDispatcher rd = request.getRequestDispatcher("input.jsp");
			rd.include(request, response);
		}
	}
}
