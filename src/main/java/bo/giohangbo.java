package bo;

import java.util.ArrayList;

import entity.Cart;

public class giohangbo {
	public ArrayList<Cart> ds = new ArrayList<Cart>();

	public void Them(String id, String name, String image, long price, long amount) {
		for (Cart h : ds)
			if (h.getId().equals(id)) {
				h.setAmount(h.getAmount() + amount);
				return;
			}
		ds.add(new Cart(id, name, image, price, amount));
	}

	public void xoa(String pid) {

		for (Cart h : ds)

			if (h.getId().equals(pid)) {
				ds.remove(h);
				return;
			}
	}

	public void capnhatsoluong(String pid, long amount) {
		for (Cart gh : ds) {
			if (gh.getId().equals(pid)) {
				gh.setAmount(amount);
				return;
			}
		}
	}

}
