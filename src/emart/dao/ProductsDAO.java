/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emart.dao;

import emart.dbutil.DBConnection;
import emart.pojo.ProductsPojo;
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
public class ProductsDAO {
    public static String getNextProductId() throws SQLException{
        Connection conn = DBConnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("Select max(p_id) from products");
        rs.next();
        String productId = rs.getString(1);
        if(productId==null){
            return "P101";
        }
        int pId = Integer.parseInt(productId.substring(1));
        pId++;
        return "P"+pId;
    }
    public static boolean addProducts(ProductsPojo p) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("insert into products values(?,?,?,?,?,?,?,'Y')");
        ps.setString(1,p.getProductId());
        ps.setString(2,p.getProductName());
        ps.setString(3,p.getProductCompanyName());
        ps.setDouble(4,p.getPrice());
        ps.setDouble(5, p.getOurPrice());
        ps.setInt(6, p.getTax());
        ps.setInt(7, p.getQuantity());
        return ps.executeUpdate()==1;
    }
    public static List<ProductsPojo> getProductsDetails() throws SQLException{
         Connection conn = DBConnection.getConnection();
         Statement st = conn.createStatement();
         ResultSet rs = st.executeQuery("select * from products where status='Y' order by p_id");
         List<ProductsPojo> pList = new ArrayList<>();
         while(rs.next()){
             ProductsPojo p = new ProductsPojo();
             p.setProductId(rs.getString(1));
             p.setProductName(rs.getString(2));
             p.setProductCompanyName(rs.getString(3));
             p.setPrice(rs.getDouble(4));
             p.setOurPrice(rs.getDouble(5));
             p.setTax(rs.getInt(6));
             p.setQuantity(rs.getInt(7));
             pList.add(p);
         }
         return pList;
    }
    public static boolean deleteProduct(String pId) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("Update products SET status='N' where p_id=?");
        ps.setString(1,pId);
        return ps.executeUpdate()==1;
    }
    public static boolean updateProducts(ProductsPojo p) throws SQLException{
        Connection conn = DBConnection.getConnection();
       PreparedStatement ps = conn.prepareStatement("UPDATE products SET p_name=?, p_companyname=?, p_price=?, our_price=?, p_tax=?, quantity=? WHERE p_id=?");
          ps.setString(1,p.getProductName());
          ps.setString(2,p.getProductCompanyName());
          ps.setDouble(3, p.getPrice());
          ps.setDouble(4,p.getOurPrice());
          ps.setInt(5, p.getTax());
          ps.setInt(6, p.getQuantity());
          ps.setString(7,p.getProductId());
          return ps.executeUpdate()==1;
    }
    public static ProductsPojo getProductsDetails(String id) throws SQLException {
          Connection conn = DBConnection.getConnection();
          PreparedStatement ps = conn.prepareStatement("Select * from products where p_id=? and status='Y'");
          ps.setString(1,id);
          ResultSet rs = ps.executeQuery();
          ProductsPojo p = new ProductsPojo();
          if(rs.next()){
             p.setProductId(rs.getString(1));
             p.setProductName(rs.getString(2));
             p.setProductCompanyName(rs.getString(3));
             p.setPrice(rs.getDouble(4));
             p.setOurPrice(rs.getDouble(5));
             p.setTax(rs.getInt(6));
             p.setQuantity(rs.getInt(7));
          }
          return p;
    }
    public static boolean updateStocks(List<ProductsPojo> plist) throws SQLException{
        Connection conn = DBConnection.getConnection();
       PreparedStatement ps = conn.prepareStatement("Update products SET Quantity=? where P_id=?");
       int x=0;
       for(ProductsPojo list : plist){
           ps.setInt(1, list.getQuantity());
           ps.setString(2, list.getProductId());
           int row = ps.executeUpdate();
           if(row!=0){
               x++;
           }
           
       }
       return x==plist.size();
    }
}
