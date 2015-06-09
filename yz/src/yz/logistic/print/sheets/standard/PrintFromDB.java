package yz.logistic.print.sheets.standard;

public class PrintFromDB {

	//print sheets by a block number
	/***
	public void print(yz.logistic.print.sheets.StandardSheetFromDB drawer,mycommons.db.connection.ParaConnection paraConnection,yz.logistic.print.sheets.PrintParameter paraPrintParameter,yz.logistic.print.sheets.parameters.ByBlock paraBlock){

		// EXPLANATION
		// drawer...an object of sheet drawer 
		
		if(paraBlock.getBlockNo_s().length==mycommons.constants.Generic.CS_ZERO_AS_INT){
			System.exit(mycommons.constants.Generic.CS_ZERO_AS_INT);
		}	
		
		//print sheet by a block
		for(int i=0;i<paraBlock.getBlockNo_s().length;i++){
			//init db db connection and initialize recordset
			drawer.initConnection(paraConnection);
			this.printCore(drawer, paraPrintParameter,paraBlock,paraBlock.getBlockNo_s()[i]);
		}
		
	}
	***/

	//print sheets by a block
	public void print(yz.logistic.print.sheets.standard.FromDB drawer,mycommons.db.connection.ParaConnection paraConnection,yz.logistic.print.common.PrintParameter paraPrintParameter,yz.logistic.print.sheets.parameters.ByBlock paraBlock){
		/***
		 EXPLANATION
		 drawer...an object of sheet drawer 
		***/
		
		if(paraBlock.getBlockNo_s().length==mycommons.constants.Generic.CS_ZERO_AS_INT){
			System.exit(mycommons.constants.Generic.CS_ZERO_AS_INT);
		}	
		
		//print sheet by a block
		for(int i=0;i<paraBlock.getBlockNo_s().length;i++){
			//init db db connection and initialize recordset
			String logBuff="start printing block "+paraBlock.getBlockNo_s()[i].getBlockNo()+".";
			//java.util.logging.Logger logger=java.util.logging.Logger.getLogger("logger");
			//logger.info(logBuff);
			mycommons.logging.Logging.info(logBuff);
			drawer.initConnection(paraConnection);
			this.printCore(drawer, paraPrintParameter,paraBlock,paraBlock.getBlockNo_s()[i]);
		}
		
	}
	
	private void printCore(yz.logistic.print.sheets.standard.FromDB drawer,yz.logistic.print.common.PrintParameter paraPrintParameter,yz.logistic.print.sheets.parameters.ByBlock byBlock,yz.logistic.generic.BlockNo blockno){
		
		//create DocFlavor
		javax.print.DocFlavor docFlavor=javax.print.DocFlavor.SERVICE_FORMATTED.PRINTABLE;
		//attribute set
		javax.print.attribute.HashPrintRequestAttributeSet attributeSet=this.getPrintReauestAttributeSet(paraPrintParameter, blockno);
		
		//get print service
		//if print service can't find,exit print 
		javax.print.PrintService printService=this.getPrintService(paraPrintParameter.getPrinter(), docFlavor, attributeSet);
		
		//doc print job
		javax.print.DocPrintJob docPrintJob=printService.createPrintJob();
		
		//init record set
		//drawer.initRecordSet(createSQL(byBlock,blockno));
		if(drawer.initRecordSet(createSQL(byBlock,blockno))){
			//simple doc
			javax.print.SimpleDoc simpledoc=new javax.print.SimpleDoc(drawer, docFlavor, null);
		
			//print
			try{
				docPrintJob.print(simpledoc, attributeSet);
			}catch(Exception e){
				//System.out.println("error:doc print job ");
				//java.util.logging.Logger logger=java.util.logging.Logger.getLogger("logger");
				//logger.severe("error:doc print job ");
				mycommons.logging.Logging.severe("error:doc print job ");
				System.exit(mycommons.constants.System.CS_EXIT_ERROR);
			}
		}else{
			//System.out.println("goto next block");
			mycommons.logging.Logging.info("goto next block");
		}
		
	}
	
	private mycommons.db.SQLString createSQL(yz.logistic.print.sheets.parameters.ByBlock byBlock,yz.logistic.generic.BlockNo blockno){

		String sql;
		
		sql="select distinct ";
		sql=sql+"ad_ten_no,haibun_mad,ten_no,haiso_course,haiso_order ";
		sql=sql+" from dbo.tbl_outfile ";
		sql=sql+" where ";
		sql=sql+" jigyo_cd="+"'"+byBlock.getSite().getSite()+"'"+ " and ";
		sql=sql+" syu_ymd="+"'"+byBlock.getShippingDate().getYYYYMMDD()+"'"+" and ";
		sql=sql+"bin_kb="+"'"+byBlock.getShippingNo().getShippingNo()+"'"+" and ";
		sql=sql+"haibun_mad="+"'"+blockno.getBlockNo()+"'";
		sql=sql+" order by haibun_mad,ad_ten_no,haiso_course,haiso_order,ten_no";
		//System.out.println("sql is "+sql);
		return new mycommons.db.SQLString(sql);

	}
	//print by a block number end
	
	
	//misc
	//get attributes
	private javax.print.attribute.HashPrintRequestAttributeSet getPrintReauestAttributeSet(yz.logistic.print.common.PrintParameter paraPrint,yz.logistic.generic.BlockNo blockNo){
		
		javax.print.attribute.HashPrintRequestAttributeSet rv=new javax.print.attribute.HashPrintRequestAttributeSet();
		
		//orientation
		if(paraPrint.getPaperOrientation().toStringOrientation()==mycommons.print.Constants.PAPERORIENTATION_LANDSCAPE){
			rv.add(javax.print.attribute.standard.OrientationRequested.LANDSCAPE);
		}
		if(paraPrint.getPaperOrientation().toStringOrientation()==mycommons.print.Constants.PAPERORIENTATION_PORTLAIT){
			rv.add(javax.print.attribute.standard.OrientationRequested.PORTRAIT);
		}
		//paper size
		if(paraPrint.getPeperSize().toStringSize()==mycommons.print.Constants.PAPERSIZE_B4){
			rv.add(javax.print.attribute.standard.MediaSizeName.ISO_B4);
		}
		if(paraPrint.getPeperSize().toStringSize()==mycommons.print.Constants.PAPERSIZE_A4){
			rv.add(javax.print.attribute.standard.MediaSizeName.ISO_A4);
		}
		
		//job name
		String dateTime=mycommons.routines.generic.Useful.getYYYYMMDD_HHMMSS(java.util.Calendar.getInstance());
		rv.add(new javax.print.attribute.standard.JobName(paraPrint.getSheet().toStringName()+"-"+blockNo.getBlockNo()+"-"+dateTime,java.util.Locale.getDefault()));
		
		return rv;
		
	}
	
	//get print service
	private javax.print.PrintService getPrintService(mycommons.print.Printer printer,javax.print.DocFlavor docFlavor,javax.print.attribute.HashPrintRequestAttributeSet attributeSet){
		
		javax.print.PrintService rv=null;
		boolean flgPrinterExist;
		flgPrinterExist=false;
		
		javax.print.PrintService[] printService_s=javax.print.PrintServiceLookup.lookupPrintServices(docFlavor, attributeSet);
		if(printService_s.length==mycommons.constants.Generic.CS_ARRAY_HAS_NO_ELEMENT){
			//System.out.println("we have no printer fits your condition.");
			mycommons.logging.Logging.severe("we have no printer fits your condition.");
			System.exit(mycommons.constants.System.CS_EXIT_ERROR);
		}
		//
		for(int i=0;i<printService_s.length;i++){
			if(printService_s[i].getName().equalsIgnoreCase(printer.toStringName())){
				rv=printService_s[i];
				flgPrinterExist=true;
				break;
			}
		}
		return rv;
		
	}
}
