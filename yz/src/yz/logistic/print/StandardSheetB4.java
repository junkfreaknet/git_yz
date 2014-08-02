package yz.logistic.print;

public class StandardSheetB4 implements java.awt.print.Printable{

	private mycommons.db.SQLString SQL;
	private java.awt.Graphics localg;
	
	private int pageIdx;
	private static final int pageMax=5;
	//constructor
	public StandardSheetB4(mycommons.db.SQLString in_sql){
		
		this.SQL=in_sql.getSQLString();
		this.pageIdx=0;
	}
	//print routine
	public int print(java.awt.Graphics g,java.awt.print.PageFormat pf,int page) throws java.awt.print.PrinterException{

		this.pageIdx=this.pageIdx+1;
		if(this.pageIdx==this.pageMax){
			return this.NO_SUCH_PAGE;
		}else{
			System.out.println(this.pageIdx);
			return this.PAGE_EXISTS;
		}
		
	}
	//public methods
	public int getPageIdx(){
		return this.pageIdx;
	}
	public java.awt.Graphics getGrapchis(){
		return this.localg;
	}
}
