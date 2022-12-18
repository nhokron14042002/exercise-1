package bo;

import java.util.ArrayList;

import dao.lichsudao;
import entity.HistoryStore;

public class lichsubo {
	lichsudao lsdao = new lichsudao();
	ArrayList<HistoryStore> ls;
	public ArrayList<HistoryStore> getlichsu(int makhDangNhap){
		ls =lsdao.getlichsu(makhDangNhap);
		return ls;
	}

}