package orderSheet;

public class OrderSheetDTO {
	
	private int orderNumber;	// 주문번호
	private String orderDate;		// 주문일자
	private String orderAdd1;  // 배송지1
	private String orderAdd2;  // 배송지2
	private int payPrice;	  //결제금액
	private String payState;	//결제상태
	private String memberId;	//아이디
	private String deliveryState;  //배송상태
	

	public OrderSheetDTO() {}
	
	public OrderSheetDTO(int orderNumber, String orderDate, String orderAdd1, String orderAdd2, int payPrice,
			String payState, String memberId, String deliveryState) {
		this.orderNumber = orderNumber;
		this.orderDate = orderDate;
		this.orderAdd1 = orderAdd1;
		this.orderAdd2 = orderAdd2;
		this.payPrice = payPrice;
		this.payState = payState;
		this.memberId = memberId;
		this.deliveryState = deliveryState;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
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

	public String getDeliveryState() {
		return deliveryState;
	}
	
	public void setDeliveryState(String deliveryState) {
		this.deliveryState = deliveryState;
	}

	@Override
	public String toString() {
		return orderNumber +  "\t" + memberId + "\t" + orderDate +  "\t" + orderAdd1 +  "\t" + orderAdd2 
				+  "\t" + payPrice +  "\t" + payState  +  "\t" + deliveryState;
	}
	


	
}
