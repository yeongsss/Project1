package payment;

public class PaymentDTO {
	   private int orderNumber;
	   private String paymentCode;
	   private int paymentDate;
	   
	   public PaymentDTO() {}

	   public PaymentDTO(int orderNumber, String paymentCode, int paymentDate) {
	      super();
	      this.orderNumber = orderNumber;
	      this.paymentCode = paymentCode;
	      this.paymentDate = paymentDate;
	   }

	   public int getOrderNumber() {
	      return orderNumber;
	   }

	   public void setOrderNumber(int orderNumber) {
	      this.orderNumber = orderNumber;
	   }

	   public String getPaymentCode() {
	      return paymentCode;
	   }

	   public void setPaymentCode(String paymentCode) {
	      this.paymentCode = paymentCode;
	   }

	   public int getPaymentDate() {
	      return paymentDate;
	   }

	   public void setPaymentDate(int paymentMethod) {
	      this.paymentDate = paymentMethod;
	   }

	   @Override
	   public int hashCode() {
	      final int prime = 31;
	      int result = 1;
	      result = prime * result + orderNumber;
	      result = prime * result + ((paymentCode == null) ? 0 : paymentCode.hashCode());
	      result = prime * result + paymentDate;
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
	      PaymentDTO other = (PaymentDTO) obj;
	      if (orderNumber != other.orderNumber)
	         return false;
	      if (paymentCode == null) {
	         if (other.paymentCode != null)
	            return false;
	      } else if (!paymentCode.equals(other.paymentCode))
	         return false;
	      if (paymentDate != other.paymentDate)
	         return false;
	      return true;
	   }

	   @Override
	   public String toString() {
	      return "결제 [주문번호:" + orderNumber + ", \t결제코드:" + paymentCode + ", \t결제일:"
	            + paymentDate + "]";
	   }
	   
	   
	}