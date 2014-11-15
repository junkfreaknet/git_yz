package testsX;

public class MainPrintSheetFromDB {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//a modefication occured 2014/10/10(fri) 18:00
		
		//print B4 standard sheet by a block
		
		final String PGNAME="Print B4 standard haibun Sheet From DB";
		
		yz.logistic.print.applications.common.CommonsApplication cmmnApplication=new yz.logistic.print.applications.common.CommonsApplication(PGNAME);
		cmmnApplication.start();
		
		//java.util.logging.Logger logger=java.util.logging.Logger.getLogger("logger");
		//logger.info("start "+PGNAME+".");
		//mycommons.logging.Logging.info("start "+PGNAME+".");

		//drawer
		yz.logistic.print.sheets.StandardSheetFromDB drawer=new yz.logistic.print.sheets.StandardSheetFromDB();

		//db connecting paramaters
		mycommons.db.connection.ParaConnection paraConnection=cmmnApplication.setParaConnectToDatabase();
		/***
		mycommons.db.connection.ParaConnection paraConnection=new mycommons.db.connection.ParaConnection();
		paraConnection.setForName(new mycommons.db.connection.ForName(mycommons.constants.DB.MS_SQL_SERVER_FOR_NAME));
		paraConnection.setServer(new mycommons.db.connection.Server(mycommons.constants.DB.MS_SQL_SERVER_SERVER_NAME));
		paraConnection.setHost(new mycommons.db.connection.Host("127.0.0.1"));
		paraConnection.setInstance(new mycommons.db.connection.Instance("SQLEXPRESS"));
		paraConnection.setPort(new mycommons.net.tcp.Port("1433"));
		paraConnection.setDataBase(new mycommons.db.connection.DataBase("TESTDBJAVA"));
		paraConnection.setUser(new mycommons.db.connection.User("sa"));
		paraConnection.setPassWord(new mycommons.db.connection.Password("sanoriyuki"));
		***/
		//print paramater
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
		
		byBlock.setShippingDate(shippingDate);
		byBlock.setShippingNo(shippingNo);
		byBlock.setSite(site);
		
		//byBlock.setBasic(paraBasic);
		
		yz.logistic.generic.BlockNo[] blockno_s=new yz.logistic.generic.BlockNo[13];
		blockno_s[0]=new yz.logistic.generic.BlockNo("01");
		blockno_s[1]=new yz.logistic.generic.BlockNo("02");
		blockno_s[2]=new yz.logistic.generic.BlockNo("03");
		blockno_s[3]=new yz.logistic.generic.BlockNo("04");
		blockno_s[4]=new yz.logistic.generic.BlockNo("05");
		blockno_s[5]=new yz.logistic.generic.BlockNo("06");
		blockno_s[6]=new yz.logistic.generic.BlockNo("07");
		blockno_s[7]=new yz.logistic.generic.BlockNo("08");
		blockno_s[8]=new yz.logistic.generic.BlockNo("09");
		blockno_s[9]=new yz.logistic.generic.BlockNo("10");
		blockno_s[10]=new yz.logistic.generic.BlockNo("11");
		blockno_s[11]=new yz.logistic.generic.BlockNo("12");
		blockno_s[12]=new yz.logistic.generic.BlockNo("13");
		byBlock.setBlockNo_s(blockno_s);
		
		//display parameters on console
		//System.out.println("site "+byBlock.getSite().getSite());
		//System.out.println("shipping date "+byBlock.getShippingDate().getYYYYMMDD());
		//System.out.println("shipping number "+byBlock.getShippingNo().getShippingNo());
		String buff;
		buff="site="+byBlock.getSite().getSite()+":";
		buff=buff+"shipping date="+byBlock.getShippingDate().getYYYYMMDD()+":";
		buff=buff+"shipping number="+byBlock.getShippingNo().getShippingNo();
		//logger.info(buff);
		mycommons.logging.Logging.info(buff);
		blockno_s=byBlock.getBlockNo_s();
		for(int i=0;i<blockno_s.length;i++){
			//System.out.println("block no "+blockno_s[i].getBlockNo());
			//logger.info("block no "+blockno_s[i].getBlockNo());
		}
		//
		yz.logistic.print.sheets.PrintStandardSheetFromDB sheet=new yz.logistic.print.sheets.PrintStandardSheetFromDB();
		sheet.print(drawer, paraConnection, paraPrint, byBlock);
		//logger.info("end "+PGNAME+".");
		mycommons.logging.Logging.info("end "+PGNAME+".");
	}

}
