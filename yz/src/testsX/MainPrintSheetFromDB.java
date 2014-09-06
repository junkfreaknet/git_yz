package testsX;

public class MainPrintSheetFromDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//print B4 standard shet by a block
		
		final String PGNAME="MainPrintSheetFromDB";
		
		System.out.println(PGNAME+"is start.");
		
		yz.logistic.print.sheets.StandardSheetFromDB drwer=new yz.logistic.print.sheets.StandardSheetFromDB();

		mycommons.db.connection.ParaConnection paraConnection=new mycommons.db.connection.ParaConnection();
		paraConnection.setForName(new mycommons.db.connection.ForName(mycommons.constants.DB.MS_SQL_SERVER_FOR_NAME));
		paraConnection.setServer(new mycommons.db.connection.Server(mycommons.constants.DB.MS_SQL_SERVER_SERVER_NAME));
		paraConnection.setHost(new mycommons.db.connection.Host("127.0.0.1"));
		paraConnection.setInstance(new mycommons.db.connection.Instance("SQLEXPRESS"));
		paraConnection.setPort(new mycommons.net.tcp.Port("1433"));
		paraConnection.setDataBase(new mycommons.db.connection.DataBase("TESTDBJAVA"));
		paraConnection.setUser(new mycommons.db.connection.User("sa"));
		paraConnection.setPassWord(new mycommons.db.connection.Password("sanoriyuki"));

		yz.logistic.print.sheets.PrintParameter paraPrint=new yz.logistic.print.sheets.PrintParameter();
		paraPrint.setPrinter(new mycommons.print.Printer("Bullzip PDF Printer"));
		paraPrint.setPaperOrientation(new mycommons.print.PaperOrientation(mycommons.print.Constants.PAPERORIENTATION_LANDSCAPE));
		paraPrint.setPaperSize(new mycommons.print.PaperSize(mycommons.print.Constants.PAPERSIZE_B4));
		paraPrint.setSheet(new mycommons.print.Sheet("StandardSheetB4"));
		
		yz.logistic.print.sheets.parameters.ByBlock byBlock=new yz.logistic.print.sheets.parameters.ByBlock();
		
		yz.logistic.generic.Site site=new yz.logistic.generic.Site("0300");
		yz.logistic.generic.ShippingDate shippingDate=new yz.logistic.generic.ShippingDate("20140807");
		yz.logistic.generic.ShippingNo shippingNo=new yz.logistic.generic.ShippingNo("10");
		yz.logistic.print.sheets.parameters.Basic paraBasic=new yz.logistic.print.sheets.parameters.Basic(site, shippingDate,shippingNo);
		
		//byBlock.setBasic(paraBasic);
		
		yz.logistic.generic.BlockNo[] blockno_s=new yz.logistic.generic.BlockNo[3];
		blockno_s[0].setBlockNo("01");
		blockno_s[1].setBlockNo("02");
		blockno_s[2].setBlockNo("03");
		byBlock.setBlockNo_s(blockno_s);
		
		
		System.out.println(PGNAME+"is end.");
	}

}
