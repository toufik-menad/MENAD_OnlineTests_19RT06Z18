package canada.montreal.MVC.controllers;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import canada.montreal.MVC.models.DepartmentModel;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/departments")
public class DepartmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Inject
	DepartmentModel departmentModel;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		logger.info("ENTER service");

		departmentModel.handle(request, response);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/departments.jsp");
		dispatcher.forward(request, response);

		logger.info("EXIT service");

	}

}
