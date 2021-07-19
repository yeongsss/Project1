package orderList;

public class OrderListDTO {

	  private int orderNumber;
	   private String productId;
	   private int orderQuantity;
	   
	   public OrderListDTO() {}

	   public OrderListDTO(int orderNumber, String productId, int orderQuantity) {
	      super();
	      this.orderNumber = orderNumber;
	      this.productId = productId;
	      this.orderQuantity = orderQuantity;
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
	   public int hashCode() {
	      final int prime = 31;
	      int result = 1;
	      result = prime * result + orderNumber;
	      result = prime * result + orderQuantity;
	      result = prime * result + ((productId == null) ? 0 : productId.hashCode());
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
	      OrderListDTO other = (OrderListDTO) obj;
	      if (orderNumber != other.orderNumber)
	         return false;
	      if (orderQuantity != other.orderQuantity)
	         return false;
	      if (productId == null) {
	         if (other.productId != null)
	            return false;
	      } else if (!productId.equals(other.productId))
	         return false;
	      return true;
	   }

	   @Override
	   public String toString() {
	      return "주문목록 [주문번호: " + orderNumber + ", \t상품코드: " + productId + ", \t주문수량: "
	            + orderQuantity + "]";
	   }
}