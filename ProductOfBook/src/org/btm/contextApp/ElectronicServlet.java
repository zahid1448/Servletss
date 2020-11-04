package org.btm.contextApp;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/ep")
public class ElectronicServlet extends GenericServlet{
@Override
public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
ServletContext ctx=getServletContext();
String offmsg=ctx.getInitParameter("ofm");
String offperc=ctx.getInitParameter("ofp");
Product p=new Product();
ctx.setAttribute("prd",p);
PrintWriter out=resp.getWriter();
out.println("<html><body bgcolor='yellow'>"
		+ "<h1>electronic product details</h1><b>"+
		" "+offmsg+" "+offperc+"%off"+
		"<br><a href=\"product.html\"> Back </a>"+"</body></html>");
out.close();
}
}
