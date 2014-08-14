package testsX;

import yz.logistic.print.StandardSheetB4FromDB;

public class TestPrintStandardSheetB4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String SQLString;
		SQLString="select distinct ";
		SQLString=SQLString+"syu_ymd,bin_kb,haibun_mad,ad_ten_no,haiso_course,haiso_order,ten_no,ten_nm_kanji ";
		SQLString=SQLString+" from dbo.tbl_outfile ";
		SQLString=SQLString+" where syu_ymd='20140807' and bin_kb='10' ";
		SQLString=SQLString+" order by haibun_mad,ad_ten_no,haiso_course,haiso_order,ten_no";
		
		mycommons.db.SQLString sql=new mycommons.db.SQLString(SQLString);
		//mycommons.db.SQLString sql=new mycommons.db.SQLString("select * from dbo.A_TABLE;");
		java.awt.print.PrinterJob pj=java.awt.print.PrinterJob.getPrinterJob();
		
		
		mycommons.db.connection.ParaConnection paraConnection=new mycommons.db.connection.ParaConnection();
		paraConnection.setForName(new mycommons.db.connection.ForName(mycommons.constants.DB.MS_SQL_SERVER_FOR_NAME));
		paraConnection.setServer(new mycommons.db.connection.Server(mycommons.constants.DB.MS_SQL_SERVER_SERVER_NAME));
		paraConnection.setHost(new mycommons.db.connection.Host("127.0.0.1"));
		paraConnection.setInstance(new mycommons.db.connection.Instance("SQLEXPRESS"));
		paraConnection.setPort(new mycommons.net.tcp.Port("1433"));
		paraConnection.setDataBase(new mycommons.db.connection.DataBase("TESTDBJAVA"));
		paraConnection.setUser(new mycommons.db.connection.User("sa"));
		paraConnection.setPassWord(new mycommons.db.connection.Password("sanoriyuki"));
		
		pj.setPrintable(new yz.logistic.print.StandardSheetB4FromDB(paraConnection,sql));
		
		if(StandardSheetB4FromDB.StatusCreate){
			
		}else{
			System.out.println("Creating sheet is failed.");
			System.exit(1);
		}
		
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
	}

}
