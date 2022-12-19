package bo;

import dao.Chitietdao;

public class chitietbo {

		Chitietdao ctdao = new Chitietdao();
		
		 public int Them(String masach, long soluongmua, long mahd) {
			 return ctdao.Them(masach, soluongmua, mahd);

		}
		 
		 public void capNhatDaMua (long maCTHD) {
			 
			 new chitietbo().capNhatDaMua(maCTHD);
		 }
}
