package entity;

public class Cart {
	
	   private String id;
	   private String name;
	   private String image;
	   private long price;
	   private long amount;
	   private long totalMoney;
	
	   public Cart(String id, String name, String image, long price, long amount) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.price = price;
		this.amount = amount;
		this.totalMoney = price*amount;
	}
	public Cart() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public long getTotalMoney() {
		return price*amount;
	}
	public void setTotalMoney(long totalMoney) {
		this.totalMoney = totalMoney;
	}
	@Override
	public String toString() {
		return "Cart [id=" + id + ", name=" + name + ", image=" + image + ", price=" + price + ", amount=" + amount
				+ ", totalMoney=" + totalMoney + "]";
	}
	   
	   
	   

}
