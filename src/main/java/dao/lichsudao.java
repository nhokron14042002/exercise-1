package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entity.HistoryStore;

public class lichsudao {
	
	
	public ArrayList<HistoryStore> getlichsu(int makhDangNhap){
		try {
			ArrayList<HistoryStore> ds= new ArrayList<HistoryStore>();
			ketnoi kn = new ketnoi();
			kn.ketnoi();
			//b2 láº¥y dá»¯ liá»‡u vá»�
			String sql ="select acc.uID ,h.NgayMua , h.damua,c.Amount,p.name,p.price,(c.Amount*p.price )as thanhtien\r\n"
					+ "from Cart as c \r\n"
					+ "inner join hoadon as h on  c.BillID = h.MaHoaDon \r\n"
					+ "inner join Account as acc on acc.uID = h.makh\r\n"
					+ "inner join product as p on p.id = c.ProductID\r\n"
					+ "where acc.uID = ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setInt(1, makhDangNhap);
			ResultSet rs = cmd.executeQuery();
		
			while (rs.next()) {
				String makh = rs.getString("uID");
				String tensach = rs.getString("name");
				int soluongmua = rs.getInt("Amount");
				int gia = rs.getInt("price");
				int thanhtien = rs.getInt("thanhtien");
				Date ngaymua = rs.getDate("NgayMua");
				boolean damua = rs.getBoolean("damua");
				ds.add(new HistoryStore(makh,tensach,soluongmua,gia,thanhtien,ngaymua,damua));
			}
			
			rs.close(); kn.cn.close();
			return ds;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	

	}
}
