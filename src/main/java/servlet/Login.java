package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.LoginAuth;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forwardPath = "WEB-INF/jsp/Login.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");
		
		String forwardPath;
		HttpSession session = request.getSession();
		if(LoginAuth.Authentication(loginId, password)) {
			
			session.setMaxInactiveInterval(30);
			session.setAttribute("loginId", loginId);
			response.sendRedirect("welcomepage");
//			forwardPath = "/WEB-INF/jsp/Welcome.jsp";
		}else {
			session.setAttribute("loginError", true);
			response.sendRedirect("login");
//			forwardPath = "/WEB-INF/jsp/LoginError.jsp";
//			RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
//			dispatcher.forward(request, response);
		}
		
		
		
	}

}
