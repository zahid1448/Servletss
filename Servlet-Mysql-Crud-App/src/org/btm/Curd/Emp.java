package org.btm.Curd;
import java.util.Date;
public class Emp {  
private String  Employee_Name;
private String Employee_code; 
private String Email_Id;
private String Contact_No;
private String Reporting_Manager; 
private String Status;
private Date Date_Of_Joining;  
private Date Date_Of_Resigning;
public String getEmployee_Name() {
	return Employee_Name;
}
public void setEmployee_Name(String employee_Name) {
	this.Employee_Name = employee_Name;
}
public String getEmployee_code() {
	return Employee_code;
}
public void setEmployee_code(String employee_code) {
	this.Employee_code = employee_code;
}
public String getEmail_Id() {
	return Email_Id;
}
public void setEmail_Id(String email_Id) {
	this.Email_Id = email_Id;
}
public String getContact_No() {
	return Contact_No;
}
public void setContact_No(String contact_No) {
	this.Contact_No = contact_No;
}
public String getReporting_Manager() {
	return Reporting_Manager;
}
public void setReporting_Manager(String reporting_Manager) {
	this.Reporting_Manager = reporting_Manager;
}
public String getStatus() {
	return Status;
}
public void setStatus(String status) {
	this.Status = status;
}
public Date getDate_Of_Joining() {
	return Date_Of_Joining;
}
public void setDate_Of_Joining(Date date_Of_Joining) {
	this.Date_Of_Joining = date_Of_Joining;
}
public Date getDate_Of_Resigning() {
	return Date_Of_Resigning;
}
public void setDate_Of_Resigning(Date date_Of_Resigning) {
	this.Date_Of_Resigning = date_Of_Resigning;
}
@Override
public String toString() {
	return "Emp [Employee_Name=" + Employee_Name + ", Employee_code=" + Employee_code + ", Email_Id=" + Email_Id
			+ ", Contact_No=" + Contact_No + ", Reporting_Manager=" + Reporting_Manager + ", Status=" + Status
			+ ", Date_Of_Joining=" + Date_Of_Joining + ", Date_Of_Resigning=" + Date_Of_Resigning + "]";
}

}  