package it.cast.servlet;

import it.cast.domain.User;
import it.cast.service.LoginService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("user");
		String pass = request.getParameter("pass");
		User user = new User();
		user.setName(username);
		user.setPass(pass);
		LoginService login_service = new LoginService();
		User u= login_service.login(user);
		if(u == null){
			request.setAttribute("massage", "您的用户名密码输入有误！");
			request.getRequestDispatcher("/login.jsp").forward(request,response);
		}else{
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().write("<javascript>老铁，登陆成功！~</javascript>");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
