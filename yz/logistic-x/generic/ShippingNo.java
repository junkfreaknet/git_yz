package yz.logistic.generic;

public class ShippingNo {

	private String shippingno;
	
	public ShippingNo(){
		this.shippingno=mycommons.constants.Generic.CS_SPACE;
	}
	public ShippingNo(String shippingno){
		this.shippingno=shippingno;
	}
	public String getShippingNo(){
		return shippingno;
	}
	public void setShippingNo(String shippingno){
		this.shippingno=shippingno;
	}
}
