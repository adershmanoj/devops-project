package com.nissan;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "addnumbersservlet", urlPatterns = "/AddNumbers")
public class AddNumbersServlet extends HttpServlet {
	public double addNumbers(double num1, double num2) {
		double sum = num1 + num2;
		return sum;
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			double num1 = Double.parseDouble(req.getParameter("num1"));
			double num2 = Double.parseDouble(req.getParameter("num2"));
			double sum = addNumbers(num1, num2);
			req.setAttribute("sum", sum);
		} catch (NumberFormatException e) {
			String result = "Invalid input, please enter a number";
			req.setAttribute("sum", result);
		}
		RequestDispatcher view = req.getRequestDispatcher("result.jsp");
		view.forward(req, resp);
	}
}