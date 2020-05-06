package dto;

public class CartDTO {

	private int cartno;
	private String id;
	private int productno;
	private String productname;
	private int price;
	private int amount;
	private String size;
	private int totalprice;
	
	public int getCartno() {
		return cartno;
	}
	public void setCartno(int cartno) {
		this.cartno = cartno;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getProductno() {
		return productno;
	}
	public void setProductno(int productno) {
		this.productno = productno;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	
	@Override
	public String toString() {
		return "CartDTO [cartno=" + cartno + ", id=" + id + ", productno=" + productno + ", productname=" + productname
				+ ", price=" + price + ", amount=" + amount + ", size=" + size + ", totalprice=" + totalprice + "]";
	}
	
}
