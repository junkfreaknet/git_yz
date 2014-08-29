package yz.logistic.generic;

public class BlockNo {

	private String blockno;
	
	//constructors
	public BlockNo(){
		this.constructorCommon(mycommons.constants.Generic.CS_SPACE);
	}
	public BlockNo(String source){
		this.constructorCommon(source);
	}
	public BlockNo(BlockNo source){
		this.constructorCommon(source);
	}

	//public methods
	public BlockNo get(){
		return this;
	}

	public void setBlockNo(String source){
		this.blockno=source;
	}
	
	public void setBlockNo(BlockNo source){
		this.blockno=source.getBlockNo();
	}
	
	public String getBlockNo(){
		return this.blockno;
	}

	//private methods
	private void constructorCommon(String blockno){
		this.blockno=blockno;
	}
	private void constructorCommon(BlockNo source){
		this.constructorCommon(source.getBlockNo());
	}	
}
