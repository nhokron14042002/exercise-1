package dao;

import java.sql.PreparedStatement;

public class Chitietdao {
		
	  public int Them(String masach, long soluongmua, long mahd) {

		try {
			ketnoi kn= new ketnoi();
			kn.ketnoi();
			String sql="insert into Cart(ProductID,Amount,BillID) values(?,?,?)";
			PreparedStatement cmd= kn.cn.prepareStatement(sql);
			cmd.setString(1, masach);
			cmd.setLong(2, soluongmua);
			cmd.setLong(3, mahd);
			int kq=cmd.executeUpdate();
			kn.cn.close();
			return kq;
		} catch (Exception e) {
			e.printStackTrace();return 0;
		}
   }
}



