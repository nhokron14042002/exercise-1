package entity;

import java.util.Date;

public class HistoryStore {
   private String makh;
   private String tensach;
   private int soluongmua;
   private int gia;
   private int thanhtien;
   private Date ngaymua;
   private boolean damua;
public HistoryStore() {
	super();
	// TODO Auto-generated constructor stub
}
public HistoryStore(String makh, String tensach,int soluongmua, int gia, int thanhtien, Date ngaymua,
		boolean damua) {
	super();
	this.makh = makh;
	this.tensach = tensach;
	this.soluongmua = soluongmua;
	this.gia = gia;
	this.thanhtien = thanhtien;
	this.ngaymua = ngaymua;
	this.damua = damua;
}
public String getMakh() {
	return makh;
}
public void setMakh(String makh) {
	this.makh = makh;
}
public String getTensach() {
	return tensach;
}
public void setTensach(String tensach) {
	this.tensach = tensach;
}
public int getSoluongmua() {
	return soluongmua;
}
public void setSoluongmua(int soluongmua) {
	this.soluongmua = soluongmua;
}
public int getGia() {
	return gia;
}
public void setGia(int gia) {
	this.gia = gia;
}
public int getThanhtien() {
	return thanhtien;
}
public void setThanhtien(int thanhtien) {
	this.thanhtien = thanhtien;
}
public Date getNgaymua() {
	return ngaymua;
}
public void setNgaymua(Date ngaymua) {
	this.ngaymua = ngaymua;
}
public boolean isDamua() {
	return damua;
}
public void setDamua(boolean damua) {
	this.damua = damua;
}

}
