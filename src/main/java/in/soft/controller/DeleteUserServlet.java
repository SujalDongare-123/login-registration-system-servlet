package in.soft.controller;

import java.io.IOException;

import in.soft.factory.ServiceFactory;
import in.soft.service.UserService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteUserServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		try {

			int id = Integer.parseInt(req.getParameter("id"));

			UserService service = ServiceFactory.getUserService();

			String status = service.delete(id);

			RequestDispatcher rd;

			if (status.equals("success")) {

				service.viewUser();

				rd = req.getRequestDispatcher("view");

			} else {

				rd = req.getRequestDispatcher("fail.html");
			}

			rd.forward(req, res);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}