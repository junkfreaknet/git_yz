package yz.logistic.generic;

public class DisplayNo {
	

	private String displayno;
	
	public DisplayNo(){
		this.constructorCommon(mycommons.constants.Generic.CS_SPACE);
	}
	public DisplayNo(String displayno){
		this.constructorCommon(displayno);
	}
	private void constructorCommon(String displayno){
		this.displayno=displayno;
	}
	public String getDisplayNo(){
		return this.displayno;
	}
	public void setDisplayNo(String displayno){
		this.displayno=displayno;
	}
}
