package yz.logistic.generic;

public class DisplayNo {
	

	private String displayno;
	
	//constructors
	public DisplayNo(){
		this.constructorCommon(mycommons.constants.Generic.CS_SPACE);
	}
	public DisplayNo(String source){
		this.constructorCommon(source);
	}
	public DisplayNo(DisplayNo source){
		
	}
	//public methods
	public DisplayNo getDisplayNo(){
		return this;
	}
	public void setDisplayNo(String source){
		this.displayno=source;
	}

	public void setDisplayNo(DisplayNo source){
		this.displayno=source.toString();
	}
	public String toString(){
		return this.displayno;
	}
	//private methods
	private void constructorCommon(String source){
		this.displayno=source;
	}
	private void constructorCommon(DisplayNo source){
		this.constructorCommon(source.toString());
	}
}
