package testsX;

import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.util.Calendar;

import yz.logistic.print.StandardSheetB4FromDB;

public class TestPrintStandardSheetB4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//setting db start
		String SQLString;

		SQLString="select distinct ";
		SQLString=SQLString+"syu_ymd,bin_kb,haibun_mad,ad_ten_no,haiso_course,haiso_order,ten_no,ten_nm_kanji ";
		SQLString=SQLString+" from dbo.tbl_outfile ";
		SQLString=SQLString+" where syu_ymd='20140807' and bin_kb='10' ";
		SQLString=SQLString+" order by haibun_mad,ad_ten_no,haiso_course,haiso_order,ten_no";
		
		mycommons.db.SQLString sql=new mycommons.db.SQLString(SQLString);

		mycommons.db.connection.ParaConnection paraConnection=new mycommons.db.connection.ParaConnection();
		paraConnection.setForName(new mycommons.db.connection.ForName(mycommons.constants.DB.MS_SQL_SERVER_FOR_NAME));
		paraConnection.setServer(new mycommons.db.connection.Server(mycommons.constants.DB.MS_SQL_SERVER_SERVER_NAME));
		paraConnection.setHost(new mycommons.db.connection.Host("127.0.0.1"));
		paraConnection.setInstance(new mycommons.db.connection.Instance("SQLEXPRESS"));
		paraConnection.setPort(new mycommons.net.tcp.Port("1433"));
		paraConnection.setDataBase(new mycommons.db.connection.DataBase("TESTDBJAVA"));
		paraConnection.setUser(new mycommons.db.connection.User("sa"));
		paraConnection.setPassWord(new mycommons.db.connection.Password("sanoriyuki"));
		
		//setting db end
		
		//***setting print start
		//In using "JAVA Print Service",you do under this line.
		//1.set a document flavor.
		//2.create a document attribute.
		//3.look up printing services that can work with the document flavor and the document attribute. and select one of them.
		//4.create a printing job from a selected printing service
		//5.call "print" from registered printing job.
		
		//javax.print.DocFlavor docFlavor=javax.print.DocFlavor.SERVICE_FORMATTED.PRINTABLE;
		
		javax.print.attribute.PrintRequestAttributeSet attributeSet=new javax.print.attribute.HashPrintRequestAttributeSet();
		attributeSet.add(javax.print.attribute.standard.OrientationRequested.LANDSCAPE);
		attributeSet.add(javax.print.attribute.standard.MediaName.NA_LETTER_WHITE);
		
		String dateTime=mycommons.routines.generic.Useful.getYYYYMMDD_HHMMSS(java.util.Calendar.getInstance());
		attributeSet.add(new javax.print.attribute.standard.JobName("StandardSheetB4-"+dateTime,null));
		
		//javax.print.PrintService[] printService_s=javax.print.PrintServiceLookup.lookupPrintServices(docFlavor, attributeSet);
		java.awt.print.PrinterJob pj=java.awt.print.PrinterJob.getPrinterJob();
		pj.setPrintable(new yz.logistic.print.StandardSheetB4FromDB(paraConnection, sql));
		
		
		/***
		java.awt.print.PageFormat pf=new java.awt.print.PageFormat();
		pf.setOrientation(java.awt.print.PageFormat.LANDSCAPE);
		java.awt.print.Paper paper=new java.awt.print.Paper();
		pf.setPaper(new java.awt.print.Paper());
		
		java.awt.print.PrinterJob pj=java.awt.print.PrinterJob.getPrinterJob();		
		pj.setPrintable(new yz.logistic.print.StandardSheetB4FromDB(paraConnection, sql), pf);
		***/
		//***setting print end
		
		if(StandardSheetB4FromDB.StatusCreate){
			
		}else{
			System.out.println("Creating sheet is failed.");
			System.exit(1);
		}
		
		javax.print.PrintService[] printService_s=java.awt.print.PrinterJob.lookupPrintServices();
		if(printService_s.length>mycommons.constants.Generic.CS_ARRAY_HAS_NO_ELEMENT){
			for(int i=0;i<printService_s.length;i++){
				System.out.println(printService_s[i].getName());
			}
				try{
					pj.setPrintService(printService_s[3]);
					pj.pageDialog(attributeSet);
					if(pj.printDialog(attributeSet)){
						pj.print(attributeSet);
					}
			}catch(Exception e){
				
			}
		}else{
			System.out.println("no priter job.");
			System.exit(1);
		}
		/***
		//pj.print();
		try{
			pj.print();
			if(StandardSheetB4FromDB.StatusRead){
				
			}else{
				System.out.println("Reading recordset is failed.");
				System.exit(1);
			}
			System.out.println("printing is end.");
		}catch(Exception e){
			System.out.println("printing is failed.");
		}
		***/
	}

}
