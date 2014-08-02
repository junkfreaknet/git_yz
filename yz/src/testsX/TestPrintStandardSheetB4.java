package testsX;

import yz.logistic.print.StandardSheetB4;

public class TestPrintStandardSheetB4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//java.awt.Graphics g;
		mycommons.db.SQLString sql=new mycommons.db.SQLString("");
		java.awt.print.PrinterJob pj=java.awt.print.PrinterJob.getPrinterJob();
		
		//yz.logistic.print.StandardSheetB4 sheet=new yz.logistic.print.StandardSheetB4(sql);
		//sheet.print();
		pj.setPrintable(new yz.logistic.print.StandardSheetB4(sql));
		
		//pj.print();
		try{
			pj.print();
		}catch(Exception e){
			System.out.println("print is failed.");
		}
	}

}
