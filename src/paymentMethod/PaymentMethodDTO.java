package paymentMethod;

public class PaymentMethodDTO {
	   private String paymentCode;
	   private String paymentMethod;
	   
	   public PaymentMethodDTO() {}

	   public PaymentMethodDTO(String paymentCode, String paymentMethod) {
	      super();
	      this.paymentCode = paymentCode;
	      this.paymentMethod = paymentMethod;
	   }

	   public String getPaymentCode() {
	      return paymentCode;
	   }

	   public void setPaymentCode(String paymentCode) {
	      this.paymentCode = paymentCode;
	   }

	   public String getPaymentMethod() {
	      return paymentMethod;
	   }

	   public void setPaymentMethod(String paymentMethod) {
	      this.paymentMethod = paymentMethod;
	   }

	   @Override
	   public int hashCode() {
	      final int prime = 31;
	      int result = 1;
	      result = prime * result + ((paymentCode == null) ? 0 : paymentCode.hashCode());
	      result = prime * result + ((paymentMethod == null) ? 0 : paymentMethod.hashCode());
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
	      PaymentMethodDTO other = (PaymentMethodDTO) obj;
	      if (paymentCode == null) {
	         if (other.paymentCode != null)
	            return false;
	      } else if (!paymentCode.equals(other.paymentCode))
	         return false;
	      if (paymentMethod == null) {
	         if (other.paymentMethod != null)
	            return false;
	      } else if (!paymentMethod.equals(other.paymentMethod))
	         return false;
	      return true;
	   }

	   @Override
	   public String toString() {
	      return "결제수단 [결제코드: " + paymentCode + ", \t결제수단이름:" + paymentMethod + "]";
	   }
	   
	}