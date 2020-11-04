package org.btm.Curd;
import java.io.IOException;  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/DeleteServlet")  
public class DeleteServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
             throws ServletException, IOException {  
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
        EmpDao.delete(employeename);  
        response.sendRedirect("ViewServlet");  
    }  
}  