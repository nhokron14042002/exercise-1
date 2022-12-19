package bo;

import dao.hoadondao;

public class hoadonbo {
	hoadondao hdao= new hoadondao();
	public long  getmaxhd() {
		return hdao.getmaxhd();
		
	}
	public int  Them(int makh) {
		return hdao.Them(makh);		
	}
	
	public void capnhat(long maxhd) {
		hdao.capnhatdamua(maxhd);
	}
}
