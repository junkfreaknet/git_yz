package yz.logistic.print.sheets.parameters;
import java.util.*;

public class ByBlock {

	//members
	private Basic basic;
	private yz.logistic.generic.BlockNo[] blockno_s;
	//private java.util.List<yz.logistic.generic.BlockNo> blocks;
	
	//constructors
	//create an empty object
	public ByBlock(){
		this.basic=new yz.logistic.print.sheets.parameters.Basic();
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
	//get
	public yz.logistic.generic.Site getSite(){
		return this.basic.getSite();
	}
	public yz.logistic.generic.ShippingDate getShippingDate(){
		return this.basic.getShippingDate();
	}
	public yz.logistic.generic.ShippingNo getShippingNo(){
		return this.basic.getShippingNo();
	}
	public yz.logistic.generic.BlockNo[] getBlockNo_s(){
		return this.blockno_s;
	}
	//public methods
	//set
	public void setSite(yz.logistic.generic.Site site){
		this.basic.setSite(site);
		
	}
	public void setShippingDate(yz.logistic.generic.ShippingDate shippingdate){
		this.basic.setShippingDate(shippingdate);
	}
	public void setShippingNo(yz.logistic.generic.ShippingNo shippingno){
		this.basic.setShippingNo(shippingno);
	}
	public void setBlockNo_s(yz.logistic.generic.BlockNo[] in_blockno_s){
		this.blockno_s=in_blockno_s;
	}
	public void setBasic(yz.logistic.print.sheets.parameters.Basic basic){
		this.basic.copy(basic);
	}
}
