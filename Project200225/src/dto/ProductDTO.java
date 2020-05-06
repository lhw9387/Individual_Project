package dto;

public class ProductDTO {
	
	private int productno;
	private String productname;
	private String category;
	private int price;
	private int hit;
	private String date;
	private String pfile;
	private String size;
	
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPfile() {
		return pfile;
	}
	public void setPfile(String pfile) {
		this.pfile = pfile;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	
	@Override
	public String toString() {
		return "ProductDTO [productno=" + productno + ", productname=" + productname + ", category=" + category
				+ ", price=" + price + ", hit=" + hit + ", date=" + date + ", pfile=" + pfile + ", size=" + size + "]";
	}
	

	
}
