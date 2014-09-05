package yz.logistic.print.sheets;

public class PrintStandardSheetFromDB {

	//print sheets by a block number
	public void print(yz.logistic.print.sheets.StandardSheetFromDB drawer,mycommons.db.connection.ParaConnection paraConnection,yz.logistic.print.sheets.PrintParameter paraPrintParameter,yz.logistic.print.sheets.parameters.ByBlock paraBlock){
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
			drawer.initConnection(paraConnection);
			this.printCore(drawer, paraPrintParameter,paraBlock,paraBlock.getBlockNo_s()[i]);
		}
		
	}
	
	private void printCore(yz.logistic.print.sheets.StandardSheetFromDB drawer,yz.logistic.print.sheets.PrintParameter paraPrintParameter,yz.logistic.print.sheets.parameters.ByBlock byBlock,yz.logistic.generic.BlockNo blockno){
		
		//create DocFlavor
		javax.print.DocFlavor docFlavor=javax.print.DocFlavor.SERVICE_FORMATTED.PRINTABLE;
		//attribute set
		javax.print.attribute.HashPrintRequestAttributeSet attributeSet=this.getPrintReauestAttributeSet(paraPrintParameter, blockno);
		
		//print service
		javax.print.PrintService printService=this.getPrintService(paraPrintParameter.getPrinter(), docFlavor, attributeSet);

		//doc print job
		javax.print.DocPrintJob docPrintJob=printService.createPrintJob();
		
		//simple doc
		javax.print.SimpleDoc simpledoc=new javax.print.SimpleDoc(drawer, docFlavor, null);
		
		//print
		try{
			docPrintJob.print(simpledoc, attributeSet);
		}catch(Exception e){
			System.out.println("error:doc print job ");
			System.exit(mycommons.constants.System.CS_EXIT_ERROR);
		}
		
	}
	
	private mycommons.db.SQLString createSQL(yz.logistic.print.sheets.parameters.ByBlock byBlock,yz.logistic.generic.BlockNo blockno){

		String sql;
		
		sql="select at_ten";

		sql="select distinct ";
		sql=sql+"syu_ymd,bin_kb,haibun_mad,ad_ten_no,haiso_course,haiso_order,ten_no,ten_nm_kanji ";
		sql=sql+" from dbo.tbl_outfile ";
		sql=sql+" where jigyo_cd='0300' and syu_ymd='20140807' and bin_kb='10' ";
		sql=sql+" and haibun_mad between '01' and '13' ";
		sql=sql+" order by haibun_mad,ad_ten_no,haiso_course,haiso_order,ten_no";		
		return new mycommons.db.SQLString(sql);

	}
	//print by a block number end
	
	
	//misc
	//get attributes
	private javax.print.attribute.HashPrintRequestAttributeSet getPrintReauestAttributeSet(yz.logistic.print.sheets.PrintParameter paraPrint,yz.logistic.generic.BlockNo blockNo){
		
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
		rv.add(new javax.print.attribute.standard.JobName(paraPrint.getSheet().toStringName()+dateTime,java.util.Locale.getDefault()));
		
		return rv;
		
	}
	
	//get print service
	private javax.print.PrintService getPrintService(mycommons.print.Printer printer,javax.print.DocFlavor docFlavor,javax.print.attribute.HashPrintRequestAttributeSet attributeSet){
		
		javax.print.PrintService rv=null;
		boolean flgPrinterExist;
		flgPrinterExist=false;
		
		javax.print.PrintService[] printService_s=javax.print.PrintServiceLookup.lookupPrintServices(docFlavor, attributeSet);
		if(printService_s.length==mycommons.constants.Generic.CS_ARRAY_HAS_NO_ELEMENT){
			System.out.println("we have no printer fits your condition.");
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
