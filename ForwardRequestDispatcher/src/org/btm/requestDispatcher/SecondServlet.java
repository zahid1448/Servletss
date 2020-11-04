package org.btm.requestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class SecondServlet extends HttpServlet{
	Scanner sc=new Scanner(System.in);
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String pname=(String)req.getAttribute("prdnm");
	String pqty=(String)req.getAttribute("prdqt");
//		String pname=req.getParameter("prdnm");
//		String pqty=req.getParameter("prdqt");
		int qty=Integer.parseInt(pqty);
		/*int qty =0;
	    if(pqty!=null){
	      try{
	      qty = Integer.parseInt(pqty);
	       }catch(Exception e){
	       }
	    }*/
		double price=40000.0;
		double totalsum=(price*qty);
		//System.out.println(price+" "+totalsum);
	PrintWriter out=resp.getWriter();
	out.println("<html><body bgcolor='yellow'>"
			+ "<h1>student dtails are "
			   +pname+" " +totalsum+"</h1>"
			+ "</body></html>");
		Connection con=null;
		PreparedStatement stm=null;
	String str="insert into btm1.students1 values(?,?,?)";
	try {
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
		stm=con.prepareStatement(str);
		stm.setString(1,pname);
		stm.setInt(2,qty);
		stm.setDouble(3,totalsum);
		
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