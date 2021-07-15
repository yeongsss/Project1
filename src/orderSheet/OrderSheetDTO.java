package orderSheet;

public class OrderSheetDTO {
	
	private int orderNumber;	// 주문번호
	private int orderDate;		// 주문일자
	private String orderAdd1;  // 배송지1
	private String orderAdd2;  // 배송지2
	private int payPrice;	  //결제금액
	private String payState;	//결제상태
	private String memberId;	//아이디
	
	public OrderSheetDTO(int orderNumber, int orderDate, String orderAdd1, String orderAdd2, int payPrice,
			String payState, String memberId) {
		this.orderNumber = orderNumber;
		this.orderDate = orderDate;
		this.orderAdd1 = orderAdd1;
		this.orderAdd2 = orderAdd2;
		this.payPrice = payPrice;
		this.payState = payState;
		this.memberId = memberId;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public int getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(int orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderAdd1() {
		return orderAdd1;
	}

	public void setOrderAdd1(String orderAdd1) {
		this.orderAdd1 = orderAdd1;
	}

	public String getOrderAdd2() {
		return orderAdd2;
	}

	public void setOrderAdd2(String orderAdd2) {
		this.orderAdd2 = orderAdd2;
	}

	public int getPayPrice() {
		return payPrice;
	}

	public void setPayPrice(int payPrice) {
		this.payPrice = payPrice;
	}

	public String getPayState() {
		return payState;
	}

	public void setPayState(String payState) {
		this.payState = payState;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
		result = prime * result + ((orderAdd1 == null) ? 0 : orderAdd1.hashCode());
		result = prime * result + ((orderAdd2 == null) ? 0 : orderAdd2.hashCode());
		result = prime * result + orderDate;
		result = prime * result + orderNumber;
		result = prime * result + payPrice;
		result = prime * result + ((payState == null) ? 0 : payState.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderSheetDTO other = (OrderSheetDTO) obj;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		if (orderAdd1 == null) {
			if (other.orderAdd1 != null)
				return false;
		} else if (!orderAdd1.equals(other.orderAdd1))
			return false;
		if (orderAdd2 == null) {
			if (other.orderAdd2 != null)
				return false;
		} else if (!orderAdd2.equals(other.orderAdd2))
			return false;
		if (orderDate != other.orderDate)
			return false;
		if (orderNumber != other.orderNumber)
			return false;
		if (payPrice != other.payPrice)
			return false;
		if (payState == null) {
			if (other.payState != null)
				return false;
		} else if (!payState.equals(other.payState))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrdsheetDTO [orderNumber=" + orderNumber + ", orderDate=" + orderDate + ", orderAdd1=" + orderAdd1
				+ ", orderAdd2=" + orderAdd2 + ", payPrice=" + payPrice + ", payState=" + payState + ", memberId="
				+ memberId + "]";
	}
	
}
