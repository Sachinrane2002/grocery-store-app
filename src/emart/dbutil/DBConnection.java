/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emart.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author sachi
 */
public class DBConnection {
    private static Connection conn;
    static{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/ grocery?useSSL=false&allowPublicKeyRetrieval=true",
                "root", "Sachin@123");
            JOptionPane.showMessageDialog(null, "Connection opened successfully!","Success",JOptionPane.INFORMATION_MESSAGE);
        }catch(ClassNotFoundException ex){
             JOptionPane.showMessageDialog(null, "Error in loading the driver","Driver Error",JOptionPane.ERROR_MESSAGE);
             ex.printStackTrace();
             System.exit(1);
        }catch(SQLException e){
             JOptionPane.showMessageDialog(null, "Error in opning Connection"," DB Error",JOptionPane.ERROR_MESSAGE);
             e.printStackTrace();
             System.exit(1);
        }
    }
    public static Connection getConnection(){
        return conn;
    }
    public static void closeConnection(){
        try{
            conn.close();
            JOptionPane.showMessageDialog(null, "Connection closed  successfully!","Success",JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error in closing Connection"," DB Error",JOptionPane.ERROR_MESSAGE);
             ex.printStackTrace();
        }
    }
}
