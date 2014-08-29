package yz.logistic.generic;

public class Site {


	private String sitecode;
	
	//constructors
	public Site(){
		this.constructorCommon(mycommons.constants.Generic.CS_SPACE);
	}
	public Site(String source){
		this.constructorCommon(source);
	}
	public Site(Site source){
		this.constructorCommon(source);
	}

	//public methods
	public Site getSite(){
		return this;
	}

	public void setSiteCode(String source){
		this.sitecode=source;
	}
	
	public void setBlockNo(BlockNo source){
		this.sitecode=source.toString();
	}
	
	public String toString(){
		return this.sitecode;
	}

	//private methods
	private void constructorCommon(String blockno){
		this.sitecode=blockno;
	}
	private void constructorCommon(Site source){
		this.constructorCommon(source.toString());
	}
}
