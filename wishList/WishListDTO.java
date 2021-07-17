package wishList;

import java.util.Objects;

public class WishListDTO {
	
	private String memberId; //아이디
	private String productId; //상품코드
	private String wishListAddDate; //위시리스트 추가일
	
	public WishListDTO(String memberId, String productId, String wishListAddDate) {
		super();
		this.memberId = memberId;
		this.productId = productId;
		this.wishListAddDate = wishListAddDate;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getWishListAddDate() {
		return wishListAddDate;
	}

	public void setWishListAddDate(String wishListAddDate) {
		this.wishListAddDate = wishListAddDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(memberId, productId, wishListAddDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WishListDTO other = (WishListDTO) obj;
		return Objects.equals(memberId, other.memberId) && Objects.equals(productId, other.productId)
				&& wishListAddDate == other.wishListAddDate;
	}

	@Override
	public String toString() {
		return "WishListDTO [memberId=" + memberId + ", productId=" + productId + ", wishListAddDate=" + wishListAddDate
				+ "]";
	}
	
	
	
	

}
