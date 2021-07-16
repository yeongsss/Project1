package product;

import java.util.Objects;

public class ProductDTO {
	private String productId; //상품코드
	private String productName; //상품명
	private String classificationCode; //상품 분류코드
	private String classificationName; //상품 분류명
	private int price; //상품 판매 가격
	private int inventoryQuantity; //상품재고량
	
	public ProductDTO(String productId, String productName, String classificationCode, String classificationName,
			int price, int inventoryQuantity) {
		this.productId = productId;
		this.productName = productName;
		this.classificationCode = classificationCode;
		this.classificationName = classificationName;
		this.price = price;
		this.inventoryQuantity = inventoryQuantity;
	}

	public ProductDTO() {
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getClassificationCode() {
		return classificationCode;
	}

	public void setClassificationCode(String classificationCode) {
		this.classificationCode = classificationCode;
	}

	public String getClassificationName() {
		return classificationName;
	}

	public void setClassificationName(String classificationName) {
		this.classificationName = classificationName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getInventoryQuantity() {
		return inventoryQuantity;
	}

	public void setInventoryQuantity(int inventoryQuantity) {
		this.inventoryQuantity = inventoryQuantity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(classificationCode, classificationName, inventoryQuantity, price, productId, productName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductDTO other = (ProductDTO) obj;
		return Objects.equals(classificationCode, other.classificationCode)
				&& Objects.equals(classificationName, other.classificationName)
				&& inventoryQuantity == other.inventoryQuantity && price == other.price
				&& Objects.equals(productId, other.productId) && Objects.equals(productName, other.productName);
	}

	@Override
	public String toString() {
		return "ProductDTO [productId=" + productId + ", productName=" + productName + ", classificationCode="
				+ classificationCode + ", classificationName=" + classificationName + ", price=" + price
				+ ", inventoryQuantity=" + inventoryQuantity + "]";
	}
	
	

}
