package in.soft.controller;

import java.io.IOException;

import in.soft.entity.User;
import in.soft.factory.ServiceFactory;
import in.soft.service.UserService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		try {

			String email = req.getParameter("email");

			String password = req.getParameter("password");

			UserService service = ServiceFactory.getUserService();

			User u = service.login(email, password);

			RequestDispatcher rd;

			if (u != null) {

				HttpSession session = req.getSession();

				session.setAttribute("user", u);

				rd = req.getRequestDispatcher("dashboard.html");

			} else {

				rd = req.getRequestDispatcher("fail.html");
			}

			rd.forward(req, res);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}