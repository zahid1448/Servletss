package org.btm.Curd;
import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List;  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/ViewServlet")  
public class ViewServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<a href='form.html'>Insert New Employee</a>");  
        out.println("<h1>Employees List</h1>");  
          
        List<Emp> list=EmpDao.getAllEmployees();  
          
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>Employee_Name</th><th>Employee_Code</th><th>Email_Id</th><th>Contact_No</th><th>Reporting_Manager</th><th>Status</th><th>Date_Of_Joining</th><th>Date_Of_Resigning</th><th>Edit</th><th>Delete</th></tr>");  
        for(Emp e:list){  
         out.print("<tr><td>"+e.getEmployee_Name()+"</td><td>"+e.getEmployee_code()+"</td><td>"+e.getEmail_Id()+"</td><td>"+e.getContact_No()+"</td><td>"
        +e.getReporting_Manager()+"</td><td>"+e.getStatus()+"</td><td>"+e.getDate_Of_Joining()+"</td><td>"+e.getDate_Of_Resigning()+"</td><td><a href='EditServlet?Employee_Name="+e.getEmployee_Name()+"'>edit</a></td><td><a href='DeleteServlet?Employee_Name="+e.getEmployee_Name()+"'>delete</a></td></tr>");  
        }  
        out.print("</table>");  
        out.close();  
    }  
}  