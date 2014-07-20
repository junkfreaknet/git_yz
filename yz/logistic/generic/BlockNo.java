package yz.logistic.generic;

public class BlockNo {

	private String blockno;
	
	public BlockNo(){
		this.constructorCommon(mycommons.constants.Generic.CS_SPACE);
	}
	public BlockNo(String blockno){
		this.constructorCommon(blockno);
	}
	public BlockNo(BlockNo blockno){
		this.constructorCommon(blockno.getBlockNo());
	}
	private void constructorCommon(String blockno){
		this.blockno=blockno;		
	}
	public String getBlockNo(){
		return this.blockno;
	}
	public void setBlockNo(String blockno){
		this.blockno=blockno;
	)
	public void setBlockNo(BlockNo in){
		this.blockno=in.getBlockNo();
	}
}
