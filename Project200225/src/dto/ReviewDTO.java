package dto;

public class ReviewDTO {
	
	private int reviewno;
	private int productno;
	private String id;
	private String title;
	private String contents;
	private String date;
	private String rfile;
	
	public int getReviewno() {
		return reviewno;
	}
	public void setReviewno(int reviewno) {
		this.reviewno = reviewno;
	}
	public int getProductno() {
		return productno;
	}
	public void setProductno(int productno) {
		this.productno = productno;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getRfile() {
		return rfile;
	}
	public void setRfile(String rfile) {
		this.rfile = rfile;
	}
	
	@Override
	public String toString() {
		return "ReviewDTO [reviewno=" + reviewno + ", productno=" + productno + ", id=" + id + ", title=" + title
				+ ", contents=" + contents + ", date=" + date + ", rfile=" + rfile + "]";
	}

}
