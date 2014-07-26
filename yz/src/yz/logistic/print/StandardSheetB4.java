package yz.logistic.print;

public class StandardSheetB4 implements java.awt.print.Printable{

	private mycommons.db.SQLString SQL;
	
	//constructor
	public StandardSheetB4(mycommons.db.SQLString in_sql){
		
		this.SQL=in_sql.getSQLString();
		
	}
	//print routine
	public int print(java.awt.Graphics g,java.awt.print.PageFormat pf,int page) throws java.awt.print.PrinterException{

		return 0;
		
	}
}
