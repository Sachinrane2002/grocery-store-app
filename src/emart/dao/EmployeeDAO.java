/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emart.dao;

import emart.dbutil.DBConnection;
import emart.pojo.EmployeePojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sachi
 */
public class EmployeeDAO {
    public static String getnextEmpId() throws SQLException{
        Connection conn = DBConnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("Select max(empid) from employees");
        rs.next();
        String empid = rs.getString(1);
        int id = Integer.parseInt(empid.substring(1));
        id++;
        return "E"+id;
    }
    public static boolean addEmployee(EmployeePojo emp) throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("insert into employees values(?,?,?,?)");
        ps.setString(1, emp.getEmpid());
        ps.setString(2, emp.getEmpname());
        ps.setString(3, emp.getJob());
        ps.setDouble(4, emp.getSalary());
        int result = ps.executeUpdate();
        return result==1;
    }
    public static List<EmployeePojo> getAllEmployees() throws SQLException{
        Connection conn = DBConnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("Select * from employees order by empid");
        ArrayList<EmployeePojo> empList = new ArrayList<>();
        while(rs.next()){
            EmployeePojo emp = new EmployeePojo();
            emp.setEmpid(rs.getString(1));
            emp.setEmpname(rs.getString(2));
            emp.setJob(rs.getString(3));
            emp.setSalary(rs.getDouble(4));
            empList.add(emp);
        }
        return empList;
    }
    public static List<String> getAllEmpId() throws SQLException {
       Connection conn = DBConnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("Select empid from employees order by empid");
        ArrayList<String> AllId = new ArrayList<>();
        while(rs.next()){
            AllId.add(rs.getString(1));
        }
        return AllId;
    }
    public static EmployeePojo findEmpbyId(String empid) throws SQLException{
         Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement("Select*from employees where empid=?");
         ps.setString(1, empid);
         ResultSet rs= ps.executeQuery();
         rs.next();
         EmployeePojo em=new EmployeePojo();
         em.setEmpid(rs.getString(1));
         em.setEmpname(rs.getString(2));
         em.setJob(rs.getString(3));
         em.setSalary(rs.getDouble(4));
         return em;
    }
    public static boolean updateEmployee(EmployeePojo emp) throws SQLException{
        boolean result;
        Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement("Update employees SET empname=?,job=?,salary=? where empid=?");
         ps.setString(1, emp.getEmpname());
         ps.setString(2, emp.getJob());
         ps.setDouble(3,emp.getSalary());
         ps.setString(4,emp.getEmpid());
         int x= ps.executeUpdate();
         if(x==0)
             return false;
         else
         result = UserDAO.isPrasentUser(emp.getEmpid());
         if(result == false){
             return true;
         }
         ps = conn.prepareStatement("Update users SET username=?,usertype=? where empid=?");
         ps.setString(2, emp.getJob());
         ps.setString(1,emp.getEmpname());
         ps.setString(3,emp.getEmpid());
         int y = ps.executeUpdate();
         return y==1;
         
    }
    public static boolean deleteEmployee(String empid) throws SQLException {
    Connection conn = DBConnection.getConnection();
    PreparedStatement ps = conn.prepareStatement("DELETE FROM employees WHERE empid=?"); 
    ps.setString(1, empid);
    int x = ps.executeUpdate(); 
    return x == 1; 
}


}
