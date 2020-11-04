package org.btm.requestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Firstservlet extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pname=req.getParameter("pn");
		String pqty=req.getParameter("pq");
       req.setAttribute("prdnm",pname);
       req.setAttribute("prdqt",pqty);
		
	RequestDispatcher rd=req.getRequestDispatcher("ss");
	rd.forward(req,resp);
}
}