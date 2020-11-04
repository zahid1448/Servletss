package org.btm.dopostApp;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
public class FirstServlet extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sid=req.getParameter("i");
		int id=Integer.parseInt(sid);
		String name=req.getParameter("nm");
		String dept=req.getParameter("dp");
		String sperc=req.getParameter("pr");
		double perc=Double.parseDouble(sperc);
		PrintWriter out=resp.getWriter();
		out.println("<html><body bgcolor='yellow'>"
				+ "<h1>student dtails are "
				   +name+" " +dept+"</h1>"
						+ "</body></html>");
		out.close();
		Connection con=null;
		PreparedStatement stm=null;
	String str="insert into btm1.students values(?,?,?,?)";
	try {
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
		stm=con.prepareStatement(str);
		stm.setInt(1,id);
		stm.setString(2,name);
		stm.setString(3,dept);
		stm.setDouble(4,perc);
		stm.executeUpdate();
	} catch (ClassNotFoundException|SQLException e) {
		e.printStackTrace();
	}
	finally {
		if(stm!=null)
		{
		try {
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(con!=null)
		{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		}
		
	}
	}	
}
