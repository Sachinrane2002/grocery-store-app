/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emart.dao;

import emart.dbutil.DBConnection;
import emart.pojo.ReceptionistPojo;
import emart.pojo.UserPojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author sachi
 */
public class ReceptionistDAO {
    public static Map<String,String> getNonRegisterReceptionist() throws SQLException{
        Connection conn = DBConnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("Select empid,empname from employees where job='Receptionist' and empid not in (select empid from users where usertype='Receptionist')");
        
        HashMap<String,String> map = new HashMap<>();
        while(rs.next()){
            String id = rs.getString(1);
            String name = rs.getString(2);
            map.put(id,name);
        }
        return map;
    }
    public static boolean addReceptionist(UserPojo user) throws SQLException{
         Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement("Insert into users values (?,?,?,?,?)");
         ps.setString(1, user.getUserid());
         ps.setString(2, user.getEmpid());
         ps.setString(3, user.getPassword());
         ps.setString(4, user.getUsertype());
         ps.setString(5, user.getUsername());
         int result = ps.executeUpdate();
         return result==1;
    }
    public static List<ReceptionistPojo> getAllReceptionistDetails() throws SQLException{
         Connection conn = DBConnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("Select users.empid,empname,userid,job,salary from users,employees where usertype='Receptionist' and users.empid=employees.empid ");
        ArrayList<ReceptionistPojo> list = new ArrayList<>();
        while(rs.next()){
            ReceptionistPojo recp = new ReceptionistPojo();
            recp.setEmpid(rs.getString(1));
            recp.setEmpName(rs.getString(2));
            recp.setUserId(rs.getString(3));
            recp.setJob(rs.getString(4));
            recp.setSalary(rs.getDouble(5));
            list.add(recp);
        }
        return list;
    }
    public static Map<String,String> getAllReceptionistId() throws SQLException{
        Connection conn = DBConnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("Select userid,username from users where usertype='Receptionist'");
        
        HashMap<String,String> map = new HashMap<>();
        while(rs.next()){
            String id = rs.getString(1);
            String name = rs.getString(2);
            map.put(id,name);
        }
        return map;
    }
  public static boolean updatePassword(String userid,String pass) throws SQLException {
         Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement("update users set password=? where userid=?");
         ps.setString(1, pass);
         ps.setString(2,userid);
         int result = ps.executeUpdate();
         return result==1;
  } 
  public static List<String> getAllReceptionistUserId() throws SQLException{
      Connection conn = DBConnection.getConnection();
      Statement st = conn.createStatement();
      ResultSet rs = st.executeQuery("Select userid from users where usertype='Receptionist'");
      List<String> userList = new ArrayList<>();
      while(rs.next()){
          userList.add(rs.getString(1));
      }
      return userList;
  }
  public static boolean deleteReceptionist(String userid) throws SQLException {
      Connection conn = DBConnection.getConnection();
      PreparedStatement ps =conn.prepareStatement("delete from users where userid=?");
      ps.setString(1, userid);
      return ps.executeUpdate()==1;
  }
}
