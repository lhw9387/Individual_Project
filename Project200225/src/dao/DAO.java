package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.CartDTO;
import dto.MemberDTO;
import dto.OrderDTO;
import dto.ProductDTO;
import dto.ReviewDTO;

public class DAO {

	Connection con; 
	PreparedStatement pstmt; 
	ResultSet rs;
	
	private static DAO dao;
	public static DAO getInstance() {
		if(dao==null) {
			dao = new DAO();
		}
		return dao;
	}
	 
	public void setConnection(Connection con) {
		this.con = con;
	}
	
//  회원가입

	public int MemberJoin(MemberDTO memberDTO) {
		String sql = "INSERT INTO MEMBER VALUES(?,?,?,?,?,?,0)"; 		
		int result = 0;		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberDTO.getId());
			pstmt.setString(2, memberDTO.getPassword());
			pstmt.setString(3, memberDTO.getName());
			pstmt.setString(4, memberDTO.getAddress());
			pstmt.setString(5, memberDTO.getPhone());
			pstmt.setString(6, memberDTO.getEmail());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			  close(pstmt);
		  }		
		return result;
	}

// 로그인
	
	public boolean memberLogin(String id, String password) {
		String sql = "SELECT * FROM MEMBER WHERE ID = ? AND PASSWORD = ?";
		boolean result = false;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return result;
	}

	public List<MemberDTO> memberList() {
		String sql = "SELECT * FROM MEMBER";
		
		List<MemberDTO> MemberList = new ArrayList<MemberDTO>();
		MemberDTO member = null;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				member = new MemberDTO();
				member.setId(rs.getString("ID"));
				member.setPassword(rs.getString("PASSWORD"));
				member.setName(rs.getString("NAME"));
				member.setAddress(rs.getString("ADDRESS"));
				member.setPhone(rs.getString("PHONE"));
				member.setEmail(rs.getString("EMAIL"));		
				member.setCash(rs.getInt("CASH"));
				MemberList.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return MemberList;
	}

	public MemberDTO memberView(String id) {
		String sql = "SELECT * FROM MEMBER WHERE ID=?";
		MemberDTO member = new MemberDTO();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member.setId(rs.getString(1));
				member.setPassword(rs.getString(2));
				member.setName(rs.getString(3));
				member.setAddress(rs.getString(4).replace(".", " "));
				member.setPhone(rs.getString(5));
				member.setEmail(rs.getString(6));
				member.setCash(rs.getInt(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return member;
	}

	public int memberDelete(String id) {
		String sql = "DELETE FROM MEMBER WHERE ID = ?";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int cashCaharge(String id, int cash) {
		String sql = "UPDATE MEMBER SET CASH=CASH+? WHERE ID = ?";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cash);
			pstmt.setString(2, id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int ProductMake(ProductDTO product) {
		String sql = "INSERT INTO PRODUCT VALUES(PRODUCT_SEQ.NEXTVAL,?,?,?,0,SYSDATE,?,?)";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, product.getProductname());
			pstmt.setString(2, product.getCategory());
			pstmt.setInt(3, product.getPrice());
			pstmt.setString(4, product.getPfile());
			pstmt.setString(5, product.getSize());
			
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int listCount() {
		String sql = "SELECT COUNT(*) FROM PRODUCT";
		int listCount = 0;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return listCount;
	}

	public List<ProductDTO> productList(int startRow, int endRow) {
		String sql = "SELECT * FROM PRODUCTLIST WHERE RN BETWEEN ? AND ?";
		List<ProductDTO> productList = new ArrayList<ProductDTO>();	
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductDTO product = new ProductDTO();
				product.setProductno(rs.getInt(1));
				product.setProductname(rs.getString(2));
				product.setCategory(rs.getString(3));
				product.setPrice(rs.getInt(4));
				product.setHit(rs.getInt(5));
				product.setDate(rs.getString(6));
				product.setPfile(rs.getString(7));
				product.setSize(rs.getString(8));
				productList.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return productList;
	}

	public int listCountOuter() {
		String sql = "SELECT COUNT(*) FROM PRODUCT WHERE CATEGORY = 'OUTER'";
		int listCount = 0;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return listCount;
	}

	public List<ProductDTO> productListOuter(int startRow, int endRow) {
		String sql = "SELECT * FROM PRODUCTOUTERLIST WHERE RN BETWEEN ? AND ?";
		List<ProductDTO> productList = new ArrayList<ProductDTO>();	
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductDTO product = new ProductDTO();
				product.setProductno(rs.getInt(1));
				product.setProductname(rs.getString(2));
				product.setCategory(rs.getString(3));
				product.setPrice(rs.getInt(4));
				product.setHit(rs.getInt(5));
				product.setDate(rs.getString(6));
				product.setPfile(rs.getString(7));
				product.setSize(rs.getString(8));
				productList.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return productList;
	}

	public int listCountTop() {
		String sql = "SELECT COUNT(*) FROM PRODUCT WHERE CATEGORY = 'TOP'";
		int listCount = 0;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return listCount;
	}

	public List<ProductDTO> productListTop(int startRow, int endRow) {
		String sql = "SELECT * FROM PRODUCTTOPLIST WHERE RN BETWEEN ? AND ?";
		List<ProductDTO> productList = new ArrayList<ProductDTO>();	
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductDTO product = new ProductDTO();
				product.setProductno(rs.getInt(1));
				product.setProductname(rs.getString(2));
				product.setCategory(rs.getString(3));
				product.setPrice(rs.getInt(4));
				product.setHit(rs.getInt(5));
				product.setDate(rs.getString(6));
				product.setPfile(rs.getString(7));
				product.setSize(rs.getString(8));
				productList.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return productList;
	}

	public int listCountBottom() {
		String sql = "SELECT COUNT(*) FROM PRODUCT WHERE CATEGORY = 'BOTTOM'";
		int listCount = 0;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return listCount;
	}

	public List<ProductDTO> productListBottom(int startRow, int endRow) {
		String sql = "SELECT * FROM PRODUCTBOTTOMLIST WHERE RN BETWEEN ? AND ?";
		List<ProductDTO> productList = new ArrayList<ProductDTO>();	
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductDTO product = new ProductDTO();
				product.setProductno(rs.getInt(1));
				product.setProductname(rs.getString(2));
				product.setCategory(rs.getString(3));
				product.setPrice(rs.getInt(4));
				product.setHit(rs.getInt(5));
				product.setDate(rs.getString(6));
				product.setPfile(rs.getString(7));
				product.setSize(rs.getString(8));
				productList.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return productList;
	}

	public int listCountShoes() {
		String sql = "SELECT COUNT(*) FROM PRODUCT WHERE CATEGORY = 'SHOES'";
		int listCount = 0;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return listCount;
	}

	public List<ProductDTO> productListShoes(int startRow, int endRow) {
		String sql = "SELECT * FROM PRODUCTSHOESLIST WHERE RN BETWEEN ? AND ?";
		List<ProductDTO> productList = new ArrayList<ProductDTO>();	
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductDTO product = new ProductDTO();
				product.setProductno(rs.getInt(1));
				product.setProductname(rs.getString(2));
				product.setCategory(rs.getString(3));
				product.setPrice(rs.getInt(4));
				product.setHit(rs.getInt(5));
				product.setDate(rs.getString(6));
				product.setPfile(rs.getString(7));
				product.setSize(rs.getString(8));
				productList.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return productList;
	}

	public int listCountAcc() {
		String sql = "SELECT COUNT(*) FROM PRODUCT WHERE CATEGORY = 'ACC'";
		int listCount = 0;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return listCount;
	}

	public List<ProductDTO> productListAcc(int startRow, int endRow) {
		String sql = "SELECT * FROM PRODUCTACCLIST WHERE RN BETWEEN ? AND ?";
		List<ProductDTO> productList = new ArrayList<ProductDTO>();	
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductDTO product = new ProductDTO();
				product.setProductno(rs.getInt(1));
				product.setProductname(rs.getString(2));
				product.setCategory(rs.getString(3));
				product.setPrice(rs.getInt(4));
				product.setHit(rs.getInt(5));
				product.setDate(rs.getString(6));
				product.setPfile(rs.getString(7));
				product.setSize(rs.getString(8));
				productList.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return productList;
	}

	public List<ProductDTO> productNameList(int startRow, int endRow) {
		String sql = "SELECT * FROM PRODUCTNAMELIST WHERE RN BETWEEN ? AND ?";
		List<ProductDTO> productList = new ArrayList<ProductDTO>();	
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductDTO product = new ProductDTO();
				product.setProductno(rs.getInt(1));
				product.setProductname(rs.getString(2));
				product.setCategory(rs.getString(3));
				product.setPrice(rs.getInt(4));
				product.setHit(rs.getInt(5));
				product.setDate(rs.getString(6));
				product.setPfile(rs.getString(7));
				product.setSize(rs.getString(8));
				productList.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return productList;
	}

	public List<ProductDTO> productPriceAscList(int startRow, int endRow) {
		String sql = "SELECT * FROM PRODUCTPRICEASCLIST WHERE RN BETWEEN ? AND ?";
		List<ProductDTO> productList = new ArrayList<ProductDTO>();	
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductDTO product = new ProductDTO();
				product.setProductno(rs.getInt(1));
				product.setProductname(rs.getString(2));
				product.setCategory(rs.getString(3));
				product.setPrice(rs.getInt(4));
				product.setHit(rs.getInt(5));
				product.setDate(rs.getString(6));
				product.setPfile(rs.getString(7));
				product.setSize(rs.getString(8));
				productList.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return productList;
	}

	public List<ProductDTO> productPriceDescList(int startRow, int endRow) {
		String sql = "SELECT * FROM PRODUCTPRICEDESCLIST WHERE RN BETWEEN ? AND ?";
		List<ProductDTO> productList = new ArrayList<ProductDTO>();	
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductDTO product = new ProductDTO();
				product.setProductno(rs.getInt(1));
				product.setProductname(rs.getString(2));
				product.setCategory(rs.getString(3));
				product.setPrice(rs.getInt(4));
				product.setHit(rs.getInt(5));
				product.setDate(rs.getString(6));
				product.setPfile(rs.getString(7));
				product.setSize(rs.getString(8));
				productList.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return productList;
	}

	public List<ProductDTO> ProductSearch(String search) {
		String sql = "SELECT * FROM PRODUCT WHERE PRODUCTNAME LIKE '"+search+"'";
		List<ProductDTO> productList = new ArrayList<ProductDTO>();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductDTO product = new ProductDTO();
				product.setProductno(rs.getInt(1));
				product.setProductname(rs.getString(2));
				product.setCategory(rs.getString(3));
				product.setPrice(rs.getInt(4));
				product.setHit(rs.getInt(5));
				product.setDate(rs.getString(6));
				product.setPfile(rs.getString(7));
				product.setSize(rs.getString(8));
				productList.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rs);
			close(pstmt);
		}
	return productList;
	}

	public int setHit(int productno) {
		String sql = "UPDATE PRODUCT SET HIT = HIT+1 WHERE PRODUCTNO =?";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, productno);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public ProductDTO productView(int productno) {
		String sql = "SELECT * FROM PRODUCT WHERE PRODUCTNO = ?";
		ProductDTO product = new ProductDTO();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,productno);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				product.setProductno(rs.getInt(1));
				product.setProductname(rs.getString(2));
				product.setCategory(rs.getString(3));
				product.setPrice(rs.getInt(4));
				product.setHit(rs.getInt(5));
				product.setDate(rs.getString(6));
				product.setPfile(rs.getString(7));
				product.setSize(rs.getString(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return product;
	}

	public int productModify(ProductDTO product) {
		String sql = "UPDATE PRODUCT SET PRODUCTNAME=?,CATEGORY=?, PRICE=?, PFILE=? WHERE PRODUCTNO=?";
		int result = 0;
		try {
			System.out.println(product.getProductname());
			System.out.println(product.getCategory());
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, product.getProductname());
			pstmt.setString(2, product.getCategory());
			pstmt.setInt(3, product.getPrice());
			pstmt.setString(4, product.getPfile());
			pstmt.setInt(5, product.getProductno());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int productDelete(int productno) {
		String sql = "DELETE FROM PRODUCT WHERE PRODUCTNO=?";
		int result =0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, productno);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public MemberDTO MemberMypage(String id) {
		String sql = "SELECT * FROM MEMBER WHERE ID = ?";
		MemberDTO member = new MemberDTO();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member.setId(rs.getString(1));
				member.setPassword(rs.getString(2));
				member.setName(rs.getString(3));
				member.setAddress(rs.getString(4).replace(".", " "));
				member.setPhone(rs.getString(5));
				member.setEmail(rs.getString(6));
				member.setCash(rs.getInt(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return member;
	}

	public MemberDTO memberSelect(String id) {
		String sql = "SELECT * FROM MEMBER WHERE ID=?";
		MemberDTO member = new MemberDTO();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member.setId(rs.getString(1));
				member.setPassword(rs.getString(2));
				member.setName(rs.getString(3));
				member.setAddress(rs.getString(4));
				member.setPhone(rs.getString(5));
				member.setEmail(rs.getString(6));
				member.setCash(rs.getInt(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return member;
	}

	public int memberModify(MemberDTO memberDTO) {
		String sql = "UPDATE MEMBER SET PASSWORD=?,NAME=?,ADDRESS=?,PHONE=?,EMAIL=? WHERE ID=?";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberDTO.getPassword());
			pstmt.setString(2, memberDTO.getName());
			pstmt.setString(3, memberDTO.getAddress());
			pstmt.setString(4, memberDTO.getPhone());
			pstmt.setString(5, memberDTO.getEmail());
			pstmt.setString(6, memberDTO.getId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int CartInsert(CartDTO cart) {
		String sql = "INSERT INTO CART VALUES(CART_SEQ.NEXTVAL,?,?,?,?,?,?,?)";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cart.getId());
			pstmt.setInt(2, cart.getProductno());
			pstmt.setString(3, cart.getProductname());
			pstmt.setInt(4, cart.getPrice());
			pstmt.setInt(5, cart.getAmount());
			pstmt.setString(6, cart.getSize());
			pstmt.setInt(7, cart.getTotalprice());
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int ProductReview(ReviewDTO review) {
		String sql = "INSERT INTO REVIEW VALUES(REVIEW_SEQ.NEXTVAL,?,?,?,?,SYSDATE,?)";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, review.getProductno());
			pstmt.setString(2, review.getId());
			pstmt.setString(3, review.getTitle());
			pstmt.setString(4, review.getContents());
			pstmt.setString(5, review.getRfile());
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int reviewlistCount() {
		String sql = "SELECT COUNT(*) FROM REVIEW";
		int listCount = 0;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return listCount;
	}

	public List<ReviewDTO> productreviewList(int startRow, int endRow) {
		String sql = "SELECT * FROM PRODUCTREVIEW WHERE RN BETWEEN ? AND ?";
		List<ReviewDTO> productreviewList = new ArrayList<ReviewDTO>();	
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ReviewDTO review = new ReviewDTO();
				review.setReviewno(rs.getInt(1));
				review.setProductno(rs.getInt(2));
				review.setId(rs.getString(3));
				review.setTitle(rs.getString(4));
				review.setContents(rs.getString(5));
				review.setDate(rs.getString(6));
				review.setRfile(rs.getString(7));
				productreviewList.add(review);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return productreviewList;
	}

	public List<ReviewDTO> ReviewList() {
		String sql = "SELECT * FROM REVIEW";
		
		List<ReviewDTO> ReviewList = new ArrayList<ReviewDTO>();
		ReviewDTO review = null;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				review = new ReviewDTO();
				review.setId(rs.getString("ID"));
				review.setTitle(rs.getString("TITLE"));
				review.setContents(rs.getString("CONTENTS"));
				review.setDate(rs.getString("DATE"));
				review.setRfile(rs.getString("RFILE"));
				ReviewList.add(review);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return ReviewList;
	}

	public int OrderBuy(OrderDTO orderDTO) {
		String sql = "INSERT INTO ORDERS VALUES(ORDER_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,0)"; 		
		int result = 0;		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, orderDTO.getId());
			pstmt.setInt(2, orderDTO.getProductno());
			pstmt.setString(3, orderDTO.getProductname());
			pstmt.setInt(4, orderDTO.getPrice());
			pstmt.setString(5, orderDTO.getName());
			pstmt.setString(6, orderDTO.getAddress());
			pstmt.setString(7, orderDTO.getPhone());
			pstmt.setString(8, orderDTO.getEmail());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			  close(pstmt);
		  }		
		return result;
	}

	public List<OrderDTO> OrderBuyList() {
		String sql = "SELECT * FROM ORDERS";
		
		List<OrderDTO> OrderBuyList = new ArrayList<OrderDTO>();
		OrderDTO order = null;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				order = new OrderDTO();
				order.setOrderno(rs.getInt("ORDERNO"));
				order.setId(rs.getString("ID"));
				order.setProductno(rs.getInt("PRODUCTNO"));
				order.setProductname(rs.getString("PRODUCTNAME"));
				order.setPrice(rs.getInt("PRICE"));
				order.setName(rs.getString("NAME"));
				order.setAddress(rs.getString("ADDRESS"));
				order.setPhone(rs.getString("PHONE"));
				order.setEmail(rs.getString("EMAIL"));
				order.setState(rs.getInt("STATE"));	
				OrderBuyList.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return OrderBuyList;
	}

	public int OrderBuyDelete(int orderno) {
		String sql = "DELETE FROM ORDERS WHERE ORDERNO=?";
		int result =0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, orderno);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	
}