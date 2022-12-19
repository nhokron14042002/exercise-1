package dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;



public class hoadondao {
	 public long getmaxhd() {
	    	try {
	    		ketnoi kn= new ketnoi();
				kn.ketnoi();
				String sql="select max(mahoadon) as maxhd from hoadon";
				PreparedStatement cmd= kn.cn.prepareStatement(sql);
				ResultSet rs=cmd.executeQuery();
				long max=0;
				if(rs.next()) 
					max=rs.getLong("maxhd");
				rs.close(); kn.cn.close();
				return max;
			} catch (Exception e) {
				e.printStackTrace();return 0;
			}
	    }

	public int  Them(int makh ) {
		try {
			ketnoi kn= new ketnoi();
			kn.ketnoi();
			String sql="insert into hoadon(makh,NgayMua,damua) values(?,?,?)";
			PreparedStatement cmd= kn.cn.prepareStatement(sql);
			cmd.setInt(1, makh);
			Date n= new Date();
			SimpleDateFormat dd= new SimpleDateFormat("yyyy-MM-dd");
			String ngay =dd.format(n);
			Date ngaymua=dd.parse(ngay);
			cmd.setDate(2, new java.sql.Date(ngaymua.getTime()));
			cmd.setBoolean(3, false);
			int kq=cmd.executeUpdate();
			kn.cn.close();
			return kq;
		} catch (Exception e) {
			e.printStackTrace();return 0;
		}
		
	}
	
	public void capnhatdamua(long maHD) {
		try {
			ketnoi kn= new ketnoi();
			kn.ketnoi();
			String sql="UPDATE hoadon SET damua = 1 WHERE MaHoaDon = ?";
			PreparedStatement cmd= kn.cn.prepareStatement(sql);
			cmd.setLong(1, maHD);
			cmd.executeUpdate();
			kn.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
	   hoadondao hd= new hoadondao();
	   System.out.println(hd.getmaxhd());

	}

}



