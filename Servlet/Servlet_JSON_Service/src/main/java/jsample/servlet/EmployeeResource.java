package jsample.servlet;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import jsample.model.Employee;
import jsample.service.EmployeeService;

public class EmployeeResource extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final String CONTENT_TYPE = "application/json";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = validateId(req, resp);
		if (id == null) {
			return;
		}
		for (int i = 0; i < EmployeeService.getInstance().getEmployeeList().size(); i++) {
			if (EmployeeService.getInstance().getEmployeeList().get(i).getId().equals(id)) {
				Employee emp = EmployeeService.getInstance().getEmployeeList().get(i);
				resp.setContentType(CONTENT_TYPE);
				ObjectMapper objectMapper = new ObjectMapper();
				objectMapper.writeValue(resp.getWriter(), emp);
				return;
			}
		}
		resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
		resp.getWriter().write("Employee with id " + id + " is not found");
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = validateId(req, resp);
		if (id == null) {
			return;
		}
		for (int i = 0; i < EmployeeService.getInstance().getEmployeeList().size(); i++) {
			if (EmployeeService.getInstance().getEmployeeList().get(i).getId().equals(id)) {
				EmployeeService.getInstance().getEmployeeList().remove(i);
				resp.setStatus(HttpServletResponse.SC_ACCEPTED);
				resp.getWriter().write("Employee with id " + id + " is deleted.");
				return;
			}
		}
		resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
		resp.getWriter().write("Employee with id " + id + " is not found");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		InputStream inputStream = req.getInputStream();
		ObjectMapper objectMapper = new ObjectMapper();
		Employee emp = objectMapper.readValue(inputStream, Employee.class);

		if (emp == null) {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			resp.getWriter().write("Employee information is not found in request");
			return;
		}

		if (emp.getId() == null) {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			resp.getWriter().write("Employee id is not found in request");
			return;
		}
		EmployeeService.getInstance().getEmployeeList().add(emp);
		resp.setContentType(CONTENT_TYPE);
		objectMapper.writeValue(resp.getWriter(), emp);

	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = validateId(req, resp);
		if (id == null) {
			return;
		}
		InputStream inputStream = req.getInputStream();
		ObjectMapper objectMapper = new ObjectMapper();
		Employee emp = objectMapper.readValue(inputStream, Employee.class);

		if (emp == null) {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			resp.getWriter().write("Employee information is not found in request");
			return;
		}

		if (emp.getId() == null) {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			resp.getWriter().write("Employee new id is not found in request");
			return;
		}

		for (int i = 0; i < EmployeeService.getInstance().getEmployeeList().size(); i++) {
			if (EmployeeService.getInstance().getEmployeeList().get(i).getId().equals(id)) {
				EmployeeService.getInstance().getEmployeeList().remove(i);
			}
		}

		EmployeeService.getInstance().getEmployeeList().add(emp);
		resp.setContentType(CONTENT_TYPE);
		objectMapper.writeValue(resp.getWriter(), emp);
	}

	private Integer validateId(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String pathId = req.getPathInfo();
		if (pathId == null || pathId.replace("/", "").isEmpty()) {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			resp.getWriter().write("Employee id is not found in request");
		}
		String idStr = pathId.replace("/", "");
		try {
			int id = Integer.parseInt(idStr);
			return id;
		} catch (NumberFormatException e) {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			resp.getWriter().write("Employee id is not valid");
		}
		return null;
	}
}