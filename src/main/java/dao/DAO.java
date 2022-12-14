/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import entity.Account;
import entity.Category;
import entity.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author trinh
 */
public class DAO {
	
	
	
	// lấy tất cả sản phẩm theo Pid
    public Product getProductByID(String pid) {
        
        
        
         ketnoi kn= new ketnoi();
      	 kn.ketnoi();

      	  String query = "select * from product \r\n"
      	  		   + "where id = ?";
      		
      
        try {
        	PreparedStatement cmd =kn.cn.prepareStatement(query);
        	cmd.setString(1, pid);
      		ResultSet rs=cmd.executeQuery();
            while (rs.next()) {
            	 return (new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {
        }
      return null;
    }
    
///////////////////////
    // hàm login trả về một account
    
    public Account login (String user ,String pass) {
    	ketnoi kn= new ketnoi();
     	 kn.ketnoi();
    	String query = "\r\n"
    			+ "select * from Account\r\n"
    			+ "where [user] = ? and pass = ?\r\n"
    			+ "";
    	
    	try {
        	PreparedStatement cmd =kn.cn.prepareStatement(query);
        	cmd.setString(1, user);
        	cmd.setString(2, pass);
      		ResultSet rs=cmd.executeQuery();
            while (rs.next()) {
            	return new Account(rs.getInt(1),
            			           rs.getString(2),
            			           rs.getString(3),
            			           rs.getInt(4),
            			           rs.getInt(5));
            }
        } catch (Exception e) {
        }
      return null;
    }
  //////////////////////////////////////
    // hàm sign up thực hiện chức năng insert dl vào db
    
    public void signup (String user , String pass) {
    	
    	ketnoi kn= new ketnoi();
    	 kn.ketnoi();
   	String query = "insert into Account\r\n"
   			+ "values (?,?,0,0)";
   			
   	
   	try {
       	PreparedStatement cmd =kn.cn.prepareStatement(query);
       	cmd.setString(1, user);
       	cmd.setString(2, pass);
     		
          cmd.executeUpdate();
          
       } catch (Exception e) {
       }
    }
    
    
    
 ///////////////////////////////////
    
    // hàm kiểm tra tài khoản mới singin đã tồn tại chưa
    
// hàm login trả về một account
    
    public Account checkAccountExist (String user ) {
    	ketnoi kn= new ketnoi();
     	 kn.ketnoi();
    	String query = "\r\n"
    			+ "select * from Account\r\n"
    			+ "where [user] = ? \r\n"
    			+ "";
    	
    	try {
        	PreparedStatement cmd =kn.cn.prepareStatement(query);
        	cmd.setString(1, user);
        
      		ResultSet rs=cmd.executeQuery();
            while (rs.next()) {
            	return new Account(rs.getInt(1),
            			           rs.getString(2),
            			           rs.getString(3),
            			           rs.getInt(4),
            			           rs.getInt(5));
            }
        } catch (Exception e) {
        }
      return null;
    }
    
    
    
    
///////////////////////	
	// tìm kiểm theo tên 
    
 
    public List<Product> searchByName(String txtSearch) {
        List<Product> list = new ArrayList<>();
        
        
         ketnoi kn= new ketnoi();
      	 kn.ketnoi();

      	  String query = "select * from product \r\n"
      	  		   + "where [name] like ?";
      		
      
        try {
        	PreparedStatement cmd =kn.cn.prepareStatement(query);
        	cmd.setString(1, "%"+txtSearch+"%");
      		ResultSet rs=cmd.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    
    
/////////////////////////
	// lấy tất cả sản phẩm theo cid
    public List<Product> getProductByCID(String cid) {
        List<Product> list = new ArrayList<>();
        
        
         ketnoi kn= new ketnoi();
      	 kn.ketnoi();

      	  String query = "select * from product \r\n"
      	  		   + "where cateID = ?";
      		
      
        try {
        	PreparedStatement cmd =kn.cn.prepareStatement(query);
        	cmd.setString(1, cid);
      		ResultSet rs=cmd.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }
///////////////////////	
	
	
	
	
	
    
// lấy tất cả sản phẩm
    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        
        
         ketnoi kn= new ketnoi();
      	 kn.ketnoi();

      	  String query = "select * from product";
      		
      
        try {
        	PreparedStatement cmd =kn.cn.prepareStatement(query);
      		ResultSet rs=cmd.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }
///////////////////////
    
// lấy tất cả các loại    
    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        
   	 //ketnoicosodu lieu
      	 ketnoi kn= new ketnoi();
      	 kn.ketnoi();

      	 String query = "select * from Category";
      		
       
        try {
        	PreparedStatement cmd = kn.cn.prepareStatement(query);
      		ResultSet rs=cmd.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getInt(1),
                        rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return list;
    }
///////////////////////
    
    
    // lấy sản phẩm mới nhất
    public Product getLast() {
         
   	 //ketnoicosodu lieu
      	 ketnoi kn= new ketnoi();
      	 kn.ketnoi();
      	 String query = "select top 1 * from product\n"
                 + "order by id desc";
      	
      		
        try {
        	PreparedStatement cmd = kn.cn.prepareStatement(query);
      		ResultSet rs=cmd.executeQuery();
            while(rs.next()){
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6));
            }
        } catch (Exception e) {
        }
        return null;
    }
 //////////////////////////
    
    
    
    
    
    
    
    
    
    public static void main(String[] args) {
        DAO dao = new DAO();
       
        List<Product> listC = dao.getProductByCID("3");

        for (Product o : listC) {
            System.out.println(o);
        }
    }

}
