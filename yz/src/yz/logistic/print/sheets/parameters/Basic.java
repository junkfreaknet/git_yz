package yz.logistic.print.sheets.parameters;

public class Basic {

	//members
	private yz.logistic.generic.Site site;
	private yz.logistic.generic.ShippingDate shippingdate;
	private yz.logistic.generic.ShippingNo shippingno;

	//constructor empty
	public Basic(){
		this.site=new yz.logistic.generic.Site();
		this.shippingno=new yz.logistic.generic.ShippingNo();
		this.shippingdate=new yz.logistic.generic.ShippingDate();
	}
	//constructor
	public Basic(yz.logistic.generic.Site inSite,yz.logistic.generic.ShippingDate inShippingDate,yz.logistic.generic.ShippingNo inShippingNo){
		this.site=inSite;
		this.shippingdate=inShippingDate;
		this.shippingno=inShippingNo;
	}
	//public methods
	//set
	public void setSite(yz.logistic.generic.Site inSite){
		this.site=inSite;
	}
	public void setShippingDate(yz.logistic.generic.ShippingDate inShippingDate){
		this.shippingdate=inShippingDate;
	}
	public void setShippingNo(yz.logistic.generic.ShippingNo inShippingNo){
		this.shippingno=inShippingNo;
	}
	//public methods
	//get
	public yz.logistic.generic.Site getSite(){
		return this.site;
	}
	public yz.logistic.generic.ShippingDate getShippingDate(){
		return this.shippingdate;
	}
	public yz.logistic.generic.ShippingNo getShippingNo(){
		return this.shippingno;
	}
	//other public methods
	public void copy(Basic inBasic){
		
		this.site=inBasic.getSite();
		this.shippingdate=inBasic.getShippingDate();
		this.shippingno=inBasic.getShippingNo();
		
	}
	
}
