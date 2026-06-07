package in.soft.controller;

import java.io.IOException;
import java.util.List;

import in.soft.entity.User;
import in.soft.factory.ServiceFactory;
import in.soft.service.UserService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class UpdateUserServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		process(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		process(req, res);
	}

	public void process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		try {

			UserService service = ServiceFactory.getUserService();

			List<User> list = service.viewUser();

			req.setAttribute("data", list);

			RequestDispatcher rd = req.getRequestDispatcher("display.jsp");

			rd.forward(req, res);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}