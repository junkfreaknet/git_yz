package testsX;

import yz.logistic.print.StandardSheetB4;

public class TestPrintStandardSheetB4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//java.awt.Graphics g;
		mycommons.db.SQLString sql=new mycommons.db.SQLString("select * from dbo.A_TABLE;");
		java.awt.print.PrinterJob pj=java.awt.print.PrinterJob.getPrinterJob();
		
		//yz.logistic.print.StandardSheetB4 sheet=new yz.logistic.print.StandardSheetB4(sql);
		//sheet.print();
		pj.setPrintable(new yz.logistic.print.StandardSheetB4(sql));
		
		if(StandardSheetB4.StatusCreate){
			
		}else{
			System.out.println("Creating sheet is failed.");
			System.exit(1);
		}
		
		//pj.print();
		try{
			pj.print();
			if(StandardSheetB4.StatusRead){
				
			}else{
				//System.out.println("Reading recordset is failed.");
				System.exit(1);
			}
			System.out.println("print end.");
		}catch(Exception e){
			System.out.println("print is failed.");
		}
	}

}
