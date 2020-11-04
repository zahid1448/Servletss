package org.btm.Curd;
import java.io.IOException;  
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/EditServlet2")  
public class EditServlet2 extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
          throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        String Employee_Name=request.getParameter("Employee_Name");  
     String regexName="^[a-z A-Z]*$";
	if(!Employee_Name.matches(regexName))
	{
		try {
		throw new Exception("Employee_Name is not proper format");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
       String Employee_code=request.getParameter("Employee_code"); 
      /* String regexName=".*[^0-9].*";
	if(!Employee_code.matches(regexName))
		{
		try {
			throw new Exception("Employee_Code is not in number format");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
        String Email_Id=request.getParameter("Email_Id"); 
       String regexName3 =  "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		if(!Email_Id.matches(regexName3))
		{
			try {
				throw new Exception("email is not proper format");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
        String Contact_No=request.getParameter("Contact_No");  
		String regexName4 ="(0/91)?[7-9][0-9]{9}";
		if(!Contact_No.matches(regexName4))
		{
			try {
				throw new Exception("contact must have digit number");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
        String Reporting_Manager=request.getParameter("Reporting_Manager");
        String regexName6="^[a-z A-Z]*$";
	if(!Reporting_Manager.matches(regexName6))
	{
		try {
		throw new Exception("Reporting_Manager is not proper format");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
        String Status=request.getParameter("Status"); 
        String regexName7="^[a-zA-Z]*$";
    	if(!Status.matches(regexName7))
    	{
    		try {
    		throw new Exception("Status is not proper format");
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
      /* if(!Status.equals("active")||!Status.equals("resigned")) {
    			try {
    				throw new Exception("chose status is wrong it should be active/regined");
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		}*/
        Emp e=new Emp();  
        e.setEmployee_Name(Employee_Name); 
        e.setEmployee_code(Employee_code);  
        e.setEmail_Id(Email_Id);  
        e.setContact_No(Contact_No);  
        e.setReporting_Manager(Reporting_Manager);  
        e.setStatus(Status); 
        e.setDate_Of_Joining(new Date()); 
        e.setDate_Of_Resigning(new Date()); 
      
        int status=EmpDao.update(e);  
        if(status>0){  
            response.sendRedirect("ViewServlet");  
        }else{  
            out.println("Sorry! unable to update record");  
        }  
        out.close();  
    }  
  
}  