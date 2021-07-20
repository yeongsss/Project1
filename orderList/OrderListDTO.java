package orderList;

public class OrderListDTO {

	  private int orderNumber;
	   private String productId;
	   private int orderQuantity;
	   private int orderListNo;
	   
	   public OrderListDTO() {}

	   public OrderListDTO(int orderNumber, String productId, int orderQuantity,int orderListNo) {
	      super();
	      this.orderNumber = orderNumber;
	      this.productId = productId;
	      this.orderQuantity = orderQuantity;
	      this.orderListNo = orderListNo;
	   }


	   public int getOrderListNo() {
		return orderListNo;
	}

	public void setOrderListNo(int orderListNo) {
		this.orderListNo = orderListNo;
	}

	public int getOrderNumber() {
	      return orderNumber;
	   }

	   public void setOrderNumber(int orderNumber) {
	      this.orderNumber = orderNumber;
	   }

	   public String getProductId() {
	      return productId;
	   }

	   public void setProductId(String productId) {
	      this.productId = productId;
	   }

	   public int getOrderQuantity() {
	      return orderQuantity;
	   }

	   public void setOrderQuantity(int orderQuantity) {
	      this.orderQuantity = orderQuantity;
	   }

	@Override
	public String toString() {
		return " 주문번호: " + orderNumber + "상품코드: " + productId + "수량: "
				+ orderQuantity + "목록번호: " + orderListNo + "]";
	}

	
}