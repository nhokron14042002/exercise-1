/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Account;
import entity.Category;
import entity.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bo.DBContext;

/**
 *
 * @author trinh
 */
public class DAO {

	// lấy tất cả sản phẩm theo id
	public Product getProductByID(String pid) {

		ketnoi kn = new ketnoi();
		kn.ketnoi();

		String query = "select * from product \r\n" + "where id = ?";

		try {
			PreparedStatement cmd = kn.cn.prepareStatement(query);
			cmd.setString(1, pid);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				return (new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6)));
			}
		} catch (Exception e) {
		}
		return null;
	}

///////////////////////
	//  hàm login

	public Account login(String user, String pass) {
		ketnoi kn = new ketnoi();
		kn.ketnoi();
		String query = "\r\n" + "select * from Account\r\n" + "where [user] = ? and pass = ?\r\n" + "";

		try {
			PreparedStatement cmd = kn.cn.prepareStatement(query);
			cmd.setString(1, user);
			cmd.setString(2, pass);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
			}
		} catch (Exception e) {
		}
		return null;
	}
	//////////////////////////////////////
	// hàm signup thực hiện chức năng insert dữ liệu vào db

	public void signup(String user, String pass) {

		ketnoi kn = new ketnoi();
		kn.ketnoi();
		String query = "insert into Account\r\n" + "values (?,?,0,0)";

		try {
			PreparedStatement cmd = kn.cn.prepareStatement(query);
			cmd.setString(1, user);
			cmd.setString(2, pass);

			cmd.executeUpdate();

		} catch (Exception e) {
		}
	}

	///////////////////////////////////

	// hàm kiểm tra tồn tại của acccount


	public Account checkAccountExist(String user) {
		ketnoi kn = new ketnoi();
		kn.ketnoi();
		String query = "\r\n" + "select * from Account\r\n" + "where [user] = ? \r\n" + "";

		try {
			PreparedStatement cmd = kn.cn.prepareStatement(query);
			cmd.setString(1, user);

			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
			}
		} catch (Exception e) {
		}
		return null;
	}

///////////////////////	
	// hàm tìm kiếm theo tên

	public List<Product> searchByName(String txtSearch) {
		List<Product> list = new ArrayList<>();

		ketnoi kn = new ketnoi();
		kn.ketnoi();

		String query = "select * from product \r\n" + "where [name] like ?";

		try {
			PreparedStatement cmd = kn.cn.prepareStatement(query);
			cmd.setString(1, "%" + txtSearch + "%");
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6)));
			}
		} catch (Exception e) {
		}
		return list;
	}

/////////////////////////
	// lấy sản phẩm theo Sellid
	public List<Product> getProductBySellID(int id) {
		List<Product> list = new ArrayList<>();

		ketnoi kn = new ketnoi();
		kn.ketnoi();

		String query = "select * from product \r\n"
				+ "where sell_ID = ?";

		try {
			PreparedStatement cmd = kn.cn.prepareStatement(query);
			cmd.setInt(1, id);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6)));
			}
		} catch (Exception e) {
		}
		return list;
	}
///////////////////////	

/////////////////////////
// hàm lấy sản phẩm theo mã loại
	public List<Product> getProductByCID(String cid) {
		List<Product> list = new ArrayList<>();

		ketnoi kn = new ketnoi();
		kn.ketnoi();

		String query = "select * from product \r\n" + "where cateID = ?";

		try {
			PreparedStatement cmd = kn.cn.prepareStatement(query);
			cmd.setString(1, cid);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6)));
			}
		} catch (Exception e) {
		}
		return list;
	}
///////////////////////	

// hàm lấy tất cả sản phẩm
	public List<Product> getAllProduct() {
		List<Product> list = new ArrayList<>();

		ketnoi kn = new ketnoi();
		kn.ketnoi();

		String query = "select * from product";

		try {
			PreparedStatement cmd = kn.cn.prepareStatement(query);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6)));
			}
		} catch (Exception e) {
		}
		return list;
	}
///////////////////////

// lấy được tất cả các loại   
	public List<Category> getAllCategory() {
		List<Category> list = new ArrayList<>();

		// ketnoicosodu lieu
		ketnoi kn = new ketnoi();
		kn.ketnoi();

		String query = "select * from Category";

		try {
			PreparedStatement cmd = kn.cn.prepareStatement(query);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				list.add(new Category(rs.getInt(1), rs.getString(2)));
			}
		} catch (Exception e) {
		}
		return list;
	}
///////////////////////

	// lấy sản phẩm mới nhất
	public Product getLast() {

		// ketnoicosodu lieu
		ketnoi kn = new ketnoi();
		kn.ketnoi();
		String query = "select top 1 * from product\n" + "order by id desc";

		try {
			PreparedStatement cmd = kn.cn.prepareStatement(query);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				return new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6));
			}
		} catch (Exception e) {
		}
		return null;
	}
	//////////////////////////
      // hàm xóa sản phẩm 
	
	public void deleteProduct (String id) {
		
		ketnoi kn = new ketnoi();
		kn.ketnoi();
		String query = "delete from product\r\n"
				+ "where id = ?";
		
		try {
			PreparedStatement cmd = kn.cn.prepareStatement(query);
			cmd.setString(1, id);
			
			cmd.executeUpdate();
			
		} catch (Exception e) {
		}
		
		
		
	}
	
	
	//////////////////////////
	
	// chức năng thêm dữ liệu
public void insertProduct (String name,String image,String price ,String title, String desciption
		,String cateID, int sell_ID) {
		
		ketnoi kn = new ketnoi();
		kn.ketnoi();
		String query = "insert [dbo].[product]\r\n"
				+ "  ([name],[image],[price],[title],[description],[cateID],[sell_ID])\r\n"
				+ "  values (?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement cmd = kn.cn.prepareStatement(query);
			cmd.setString(1, name);
			cmd.setString(2, image);
			cmd.setString(3, price);
			cmd.setString(4, title);
			cmd.setString(5, desciption);
			cmd.setString(6, cateID);
			cmd.setInt(7, sell_ID);
			
			cmd.executeUpdate();
			
		} catch (Exception e) {
		}
		
		
		
	}
	///////////////////////////////
      // edit product 

       public void editProduct(String pname, String pimage, String pprice, String ptitle, String pdescription,
		String pcategory, String pid) {
	              String query = "update product \r\n"
	              		+ "  set [name]= ?,\r\n"
	              		+ "  [image]= ?,\r\n"
	              		+ "  [price]= ?,\r\n"
	              		+ "  [title]= ?,\r\n"
	              		+ "  [description]= ?,\r\n"
	              		+ "  [cateID]= ?\r\n"
	              		+ "  where id =?";
	            ketnoi kn = new ketnoi();
	      		kn.ketnoi();

	      		try {
	      			PreparedStatement cmd = kn.cn.prepareStatement(query);
	      			cmd.setString(1, pname);
	      			cmd.setString(2, pimage);
	      			cmd.setString(3, pprice);
	      			cmd.setString(4, ptitle);
	      			cmd.setString(5, pdescription);
	      			cmd.setString(6, pcategory);
	      			cmd.setString(7, pid);
	      			
	      			cmd.executeUpdate();
	      			
	      		} catch (Exception e) {
	      		}
	
         }
	
	
	//////////////////////////
	public static void main(String[] args) {
		DAO dao = new DAO();

		List<Product> listC = dao.getProductByCID("3");
		Account listA = dao.checkAccountExist("adam");

		System.out.println(listA);

	}

	

}
