package yz.logistic.print.parameters;

public class ByBlock {

	//members
	private yz.logistic.generic.Site site;
	private yz.logistic.generic.ShippingDate shippingdate;
	private yz.logistic.generic.ShippingNo shippingno;
	private yz.logistic.generic.BlockNo[] blockno_s;
	
	//create an empty object
	public ByBlock(){
		
	}
	public ByBlock(yz.logistic.generic.Site inSite,yz.logistic.generic.ShippingDate inShippingDate,yz.logistic.generic.ShippingNo inShippingNo,yz.logistic.generic.BlockNo[] inBlockNo_s){
		
		site=inSite;
		shippingdate=inShippingDate;
		shippingno=inShippingNo;
		blockno_s=inBlockNo_s;
		
	}
	public yz.logistic.generic.Site getSite(){
		return this.site;
	}
	public yz.logistic.generic.ShippingDate getShippingDate(){
		return this.shippingdate;
	}
	public yz.logistic.generic.ShippingNo getShippingNo(){
		return this.shippingno;
	}
	public yz.logistic.generic.BlockNo[] getBlockNo_s(){
		return this.blockno_s;
	}
}
