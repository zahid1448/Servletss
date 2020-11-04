package org.btm.Curd;
import java.io.IOException;  
import java.io.PrintWriter;  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/EditServlet")  
public class EditServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<h1>Update Employee</h1>");  
        String employeename=request.getParameter("Employee_Name");
   String regexName="^[a-z A-Z]*$";
	if(!employeename.matches(regexName))
		{
		try {
		throw new Exception("Employee_Name is not proper format");
		} catch (Exception e) {
		e.printStackTrace();
	}
}
        Emp e=EmpDao.getEmployeeByEmployee_Name(employeename);  
        out.print("<form action='EditServlet2' method='post'>");  
        out.print("<table>");  
        out.print("<tr><td></td><td><input type='hidden' name='Employee_Name' value='"+e.getEmployee_Name()+"'/></td></tr>");  
        out.print("<tr><td>Employee_code:</td><td><input type='text' name='Employee_code' value='"+e.getEmployee_code()+"'/></td></tr>");  
        out.print("<tr><td>Email_Id:</td><td><input type='Email_Id' name='Email_Id' value='"+e.getEmail_Id()+"'/></td></tr>");  
        out.print("<tr><td>Contact_No:</td><td><input type='Contact_No' name='Contact_No' value='"+e.getContact_No()+"'/></td></tr>");  
        out.print("<tr><td>Reporting_Manager:</td><td><input type='text' name='Reporting_Manager' value='"+e.getReporting_Manager()+"'/></td></tr>");  
        out.print("<tr><td>Status:</td><td><input type='text' name='Status' value='"+e.getStatus()+"'/></td></tr>");  
         out.print("</td></tr>");
  //date format taken automatically
         out.print("<tr><td>Date_Of_Joining:</td><td><input type='Date_Of_Joining' name='Date_Of_Joining' value='"+e.getDate_Of_Joining()+"'/></td></tr>");  
        out.print("<tr><td>Date_Of_Resigning:</td><td><input type='Date_Of_Resigning' name='Date_Of_Resigning' value='"+e.getDate_Of_Resigning()+"'/></td></tr>");   
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save'/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
        out.close();  
    }  
}  
