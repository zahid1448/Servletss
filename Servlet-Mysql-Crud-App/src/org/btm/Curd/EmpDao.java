package org.btm.Curd;
import java.util.*;
import java.util.Date;
import java.sql.*;  
public class EmpDao {  
    public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
    public static int save(Emp e){  
        int status=0;  
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("insert into btm.student values (?,?,?,?,?,?,?,?)");  
            ps.setString(1,e.getEmployee_Name()); 
            ps.setString(2,e.getEmployee_code());  
            ps.setString(3,e.getEmail_Id());  
            ps.setString(4,e.getContact_No());  
            ps.setString(5,e.getReporting_Manager());  
            ps.setString(6,e.getStatus()); 
            ps.setObject(7,e.getDate_Of_Joining()); 
            ps.setObject(8,e.getDate_Of_Resigning()); 
            status=ps.executeUpdate();  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int update(Emp e){  
        int status=0;  
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("update btm.student set Employee_code=?,Email_Id=?,Contact_No=?,Reporting_Manager=?,Status=?,Date_Of_Joining=?,Date_Of_Resigning=? where Employee_Name=?");
           // ps.setString(1,e.getEmployee_Name());
            ps.setString(1,e.getEmployee_code());  
            ps.setString(2,e.getEmail_Id());  
            ps.setString(3,e.getContact_No());  
            ps.setString(4,e.getReporting_Manager());  
            ps.setString(5,e.getStatus());  
            ps.setObject(6,e.getDate_Of_Joining()); 
            ps.setObject(7,e.getDate_Of_Resigning()); 
            ps.setString(8,e.getEmployee_Name());
            status=ps.executeUpdate();  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int delete(String Employee_Name){  
        int status=0;  
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from btm.student where Employee_Name=?");  
            ps.setString(1,Employee_Name); 
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }  
    public static Emp getEmployeeByEmployee_Name(String Employee_Name){  
        Emp e=new Emp();  
          
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from btm.student where Employee_Name=?");  
            ps.setString(1,Employee_Name);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e.setEmployee_Name(rs.getString(1)); 
                e.setEmployee_code(rs.getString(2));  
                e.setEmail_Id(rs.getString(3));  
                e.setContact_No(rs.getString(4));  
                e.setReporting_Manager(rs.getString(5));  
                e.setStatus(rs.getString(6)); 
                e.setDate_Of_Joining(rs.getDate(7)); 
                e.setDate_Of_Resigning(rs.getDate(8)); 
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    }  
    public static List<Emp> getAllEmployees(){  
        List<Emp> list=new ArrayList<Emp>();  
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from btm.student");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Emp e=new Emp();  
                e.setEmployee_Name(rs.getString(1)); 
                e.setEmployee_code(rs.getString(2));  
                e.setEmail_Id(rs.getString(3));  
                e.setContact_No(rs.getString(4));  
                e.setReporting_Manager(rs.getString(5));  
                e.setStatus(rs.getString(6)); 
                e.setDate_Of_Joining(rs.getDate(7)); 
                e.setDate_Of_Joining(rs.getDate(8)); 
                list.add(e);  
                            }  
            con.close();  
                        }
        catch(Exception e){e.printStackTrace();
                          }  
        return list;  
    }  
}  