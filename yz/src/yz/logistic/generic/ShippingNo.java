package yz.logistic.generic;

public class ShippingNo {

	private String shippingno;
	
	//constructor
	public ShippingNo(){
		this.constructorCommon(mycommons.constants.Generic.CS_SPACE);			
	}
	public ShippingNo(String source){
		this.constructorCommon(source);
	}
	public ShippingNo(ShippingNo source){
		this.constructorCommon(source);
	}
	//constructor common
	private void constructorCommon(String source){
		this.shippingno=source;
	}
	private void constructorCommon(ShippingNo source){
		this.shippingno=source.toString();
	}
	//public method
	public ShippingNo get(){
		return this;
	}
	public String getShippingNo(){
		return this.shippingno;
	}
	public void setShippingNo(String source){
		this.shippingno=source;
	}
	public void setShippingNo(ShippingNo source){
		this.shippingno=source.getShippingNo();
	}
}
