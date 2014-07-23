package yz.logistic.generic;

public class BlockNo {

	private String blockno;
	
	//constructors
	public BlockNo(){
		this.constructorCommon(mycommons.constants.Generic.CS_SPACE);
	}
	public BlockNo(String blockno){
		this.constructorCommon(blockno);
	}
	public BlockNo(BlockNo blockno){
		this.constructorCommon(blockno);
	}

	//public methods
	public BlockNo getBlockNo(){
		return this;
	}
	public void setBlockNo(String blockno){
		this.blockno=blockno;
	}
	
	public void setBlockNo(BlockNo source){
		this.blockno=source.toString();
	}
	
	public String toString(){
		return this.blockno;
	}

	//private methods
	private void constructorCommon(String blockno){
		this.blockno=blockno;
	}
	private void constructorCommon(BlockNo source){
		this.constructorCommon(source.toString());
	}	
}
