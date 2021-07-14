package purchase;

import java.util.Objects;

public class PurchaseDTO {
	
	private String purchaseNumber;
	private String productId;
	private int purchaseCost;
	private int purchaseDate;
	private int purchaseQuantity;
	
	public PurchaseDTO(String purchaseNumber, String productId, int purchaseCost, int purchaseDate,
			int purchaseQuantity) {
		this.purchaseNumber = purchaseNumber;
		this.productId = productId;
		this.purchaseCost = purchaseCost;
		this.purchaseDate = purchaseDate;
		this.purchaseQuantity = purchaseQuantity;
	}

	public String getPurchaseNumber() {
		return purchaseNumber;
	}

	public void setPurchaseNumber(String purchaseNumber) {
		this.purchaseNumber = purchaseNumber;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getPurchaseCost() {
		return purchaseCost;
	}

	public void setPurchaseCost(int purchaseCost) {
		this.purchaseCost = purchaseCost;
	}

	public int getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(int purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public int getPurchaseQuantity() {
		return purchaseQuantity;
	}

	public void setPurchaseQuantity(int purchaseQuantity) {
		this.purchaseQuantity = purchaseQuantity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(productId, purchaseCost, purchaseDate, purchaseNumber, purchaseQuantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PurchaseDTO other = (PurchaseDTO) obj;
		return Objects.equals(productId, other.productId) && purchaseCost == other.purchaseCost
				&& purchaseDate == other.purchaseDate && Objects.equals(purchaseNumber, other.purchaseNumber)
				&& purchaseQuantity == other.purchaseQuantity;
	}

	@Override
	public String toString() {
		return "PurchaseDTO [purchaseNumber=" + purchaseNumber + ", productId=" + productId + ", purchaseCost="
				+ purchaseCost + ", purchaseDate=" + purchaseDate + ", purchaseQuantity=" + purchaseQuantity + "]";
	}
	
	

}
