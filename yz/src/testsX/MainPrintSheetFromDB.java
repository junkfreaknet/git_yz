package testsX;

public class MainPrintSheetFromDB {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//a modefication occured 2014/10/10(fri) 18:00
		
		//print B4 standard sheet by a block
		
		final String PGNAME="Print B4 standard haibun Sheet From DB";
		
		yz.logistic.print.common.CommonsApplication cmmnApplication=new yz.logistic.print.common.CommonsApplication(PGNAME);
		cmmnApplication.start();
		
		//java.util.logging.Logger logger=java.util.logging.Logger.getLogger("logger");
		//logger.info("start "+PGNAME+".");
		//mycommons.logging.Logging.info("start "+PGNAME+".");

		//db connecting parameters
		mycommons.db.connection.ParaConnection paraDBConnection=cmmnApplication.setParaConnectToDatabase();
		
		//para database test start
		//System.out.println(paraDBConnection.getConnectionString());
		System.out.println("database "+paraDBConnection.getDataBase().toStringName());
		System.out.println("for name "+paraDBConnection.getForName().toStringValue());
		System.out.println("host "+paraDBConnection.getHost().toStringName());
		System.out.println("instance "+paraDBConnection.getInstance().toStringName());
		System.out.println("password "+paraDBConnection.getPassWord().toStringValue());
		System.out.println("port "+paraDBConnection.getPort().toStringValue());
		System.out.println("server "+paraDBConnection.getServer().toStringName());
		System.out.println("user "+paraDBConnection.getUser().toStringName());
		//para database test end.
		
		//print technical parameters start
		yz.logistic.print.common.PrintParameter paraPrint=new yz.logistic.print.common.PrintParameter();
		paraPrint.setPrinter(new mycommons.print.Printer("Bullzip PDF Printer"));
		paraPrint.setPaperOrientation(new mycommons.print.PaperOrientation(mycommons.print.Constants.PAPERORIENTATION_LANDSCAPE));
		paraPrint.setPaperSize(new mycommons.print.PaperSize(mycommons.print.Constants.PAPERSIZE_B4));
		paraPrint.setSheet(new mycommons.print.Sheet("StandardSheetB4"));
		//print technical parameters end
		
		//print application parameters set start
		yz.logistic.print.sheets.parameters.ByBlock byBlock=new yz.logistic.print.sheets.parameters.ByBlock();
		
		//basic site,shipping date,shipping no
		yz.logistic.generic.Site site=new yz.logistic.generic.Site("0300");
		yz.logistic.generic.ShippingDate shippingDate=new yz.logistic.generic.ShippingDate("20140807");
		yz.logistic.generic.ShippingNo shippingNo=new yz.logistic.generic.ShippingNo("10");
		
		byBlock.setShippingDate(shippingDate);
		byBlock.setShippingNo(shippingNo);
		byBlock.setSite(site);
		
		//set block number s start
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
		
		//print application parameters set end
		
		//display parameters on console start
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
		
		//display parameters on console end
		
		//drawer
		yz.logistic.print.sheets.standard.FromDB drawer=new yz.logistic.print.sheets.standard.FromDB();
		//print
		yz.logistic.print.sheets.standard.PrintFromDB sheet=new yz.logistic.print.sheets.standard.PrintFromDB();
		sheet.print(drawer, paraDBConnection, paraPrint, byBlock);
		
		//end
		cmmnApplication.end();

	}

}
