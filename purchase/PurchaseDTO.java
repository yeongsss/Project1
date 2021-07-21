package purchase;

import java.util.Objects;

public class PurchaseDTO {
	private int purchaseNumber;
	private String productId;
	private int puroductDate;
	private int puroductQuantity;
	
	
	public PurchaseDTO() {
	}

	
	public PurchaseDTO(int purchaseNumber, String productId, int puroductDate, int puroductQuantity) {
		this.purchaseNumber = purchaseNumber;
		this.productId = productId;
		this.puroductDate = puroductDate;
		this.puroductQuantity = puroductQuantity;
	}


	public int getPurchaseNumber() {
		return purchaseNumber;
	}

	public void setPurchaseNumber(int purchaseNumber) {
		this.purchaseNumber = purchaseNumber;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getPuroductDate() {
		return puroductDate;
	}

	public void setPuroductDate(int puroductDate) {
		this.puroductDate = puroductDate;
	}

	public int getPuroductQuantity() {
		return puroductQuantity;
	}

	public void setPuroductQuantity(int puroductQuantity) {
		this.puroductQuantity = puroductQuantity;
	}


	@Override
	public int hashCode() {
		return Objects.hash(productId, purchaseNumber, puroductDate, puroductQuantity);
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
		return Objects.equals(productId, other.productId) && purchaseNumber == other.purchaseNumber
				&& puroductDate == other.puroductDate && puroductQuantity == other.puroductQuantity;
	}


	@Override
	public String toString() {
		return "PurchaseDTO [purchaseNumber=" + purchaseNumber + ", productId=" + productId + ", puroductDate="
				+ puroductDate + ", puroductQuantity=" + puroductQuantity + "]";
	}
	
	
	
}