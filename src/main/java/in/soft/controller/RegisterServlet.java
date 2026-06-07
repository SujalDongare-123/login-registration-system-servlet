package in.soft.controller;

import java.io.IOException;

import in.soft.entity.User;
import in.soft.factory.ServiceFactory;
import in.soft.service.UserService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		try {

			System.out.println("Servlet Called");

			int id = Integer.parseInt(req.getParameter("id"));

			String name = req.getParameter("name");

			String email = req.getParameter("email");

			String password = req.getParameter("password");

			User u = new User();

			u.setId(id);
			u.setName(name);
			u.setEmail(email);
			u.setPassword(password);

			UserService service = ServiceFactory.getUserService();

			String status = service.register(u);

			System.out.println(status);

			RequestDispatcher rd = null;

			if (status.equals("success")) {

				rd = req.getRequestDispatcher("success.html");

			} else {

				rd = req.getRequestDispatcher("fail.html");
			}

			rd.forward(req, res);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}