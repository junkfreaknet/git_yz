package yz.logistic.print.parameters;

public class ByBlock {

	//members
	private Basic basic;
	private yz.logistic.generic.BlockNo[] blockno_s;
	
	//constructors
	//create an empty object
	public ByBlock(){
		
	}
	//
	public ByBlock(yz.logistic.generic.Site inSite,yz.logistic.generic.ShippingDate inShippingDate,yz.logistic.generic.ShippingNo inShippingNo,yz.logistic.generic.BlockNo[] inBlockNo_s){

		this.basic.setSite(inSite);
		this.basic.setShippingDate(inShippingDate);
		this.basic.setShippingNo(inShippingNo);
		this.blockno_s=inBlockNo_s;
		
	}
	
	public ByBlock(Basic inBasic,yz.logistic.generic.BlockNo[] inBlockNo_s){
		
		this.basic.copy(inBasic);
		this.blockno_s=inBlockNo_s;
		
	}
	//public methods
	public yz.logistic.generic.Site getSite(){
		return this.basic.getSite();
	}
	public yz.logistic.generic.ShippingDate getShippingDate(){
		return this.getShippingDate();
	}
	public yz.logistic.generic.ShippingNo getShippingNo(){
		return this.basic.getShippingNo();
	}
	public yz.logistic.generic.BlockNo[] getBlockNo_s(){
		return this.blockno_s;
	}
}
