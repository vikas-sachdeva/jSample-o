package jsample.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.common.base.Joiner;

public class HelloWorld extends HttpServlet {

	private static final long serialVersionUID = -4481720201981492955L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.print(Joiner.on("\n").join("<html>", "<body>", "<h2>Hello Servlet !!!</h2>", "</body>", "</html>"));
	}
}