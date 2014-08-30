package yz.logistic.print.sheets;

public class PrintStandardSheetB4FromDB {

	public PrintStandardSheetB4FromDB(mycommons.print.Printer printer,mycommons.db.connection.ParaConnection paraConnection,mycommons.db.SQLString sql){
		
		//final String printerTarget="Bullzip PDF Printer";
		boolean printerExist=false;
		int idxServices;
		//***setting print start
		//In using "JAVA Print Service",you do under this line.
		//1.set a document flavor.
		//2.create a document attribute.
		//3.look up printing services that can work with the document flavor and the document attribute. and select one of them.
		//4.create a printing job from a selected printing service
		//5.call "print" from registered printing job.
		
		//create DocFlavor
		javax.print.DocFlavor docFlavor=javax.print.DocFlavor.SERVICE_FORMATTED.PRINTABLE;
		
		//create PrintRequestAttributeSet
		javax.print.attribute.HashPrintRequestAttributeSet serviceAttributes=new javax.print.attribute.HashPrintRequestAttributeSet();
		
		serviceAttributes.add(javax.print.attribute.standard.OrientationRequested.LANDSCAPE);
		String dateTime=mycommons.routines.generic.Useful.getYYYYMMDD_HHMMSS(java.util.Calendar.getInstance());
		serviceAttributes.add(new javax.print.attribute.standard.JobName("TestPtintStandardSheetB4-"+dateTime,java.util.Locale.getDefault()));
		serviceAttributes.add(javax.print.attribute.standard.MediaSizeName.ISO_B4);
		
		//serach PrintService[]
		javax.print.PrintService[] printService_s=javax.print.PrintServiceLookup.lookupPrintServices(docFlavor, serviceAttributes);
		
		if (printService_s.length==mycommons.constants.Generic.CS_ARRAY_HAS_NO_ELEMENT){
			//log and exit program
			System.out.println("we have no printer can print B4 landscape no1.exit this program.");
			System.exit(mycommons.constants.System.CS_EXIT_ERROR);
		}
	
		for(idxServices=0;idxServices<printService_s.length;idxServices++){
			if(printService_s[idxServices].getName().equalsIgnoreCase(printer.toStringName())){
				printerExist=true;
				break;
			}
			
		}

		if(printerExist){
			
		}else{
			//log and exit
			System.out.println("we have no printer can print B4 landscape no2.exit this program.");
			System.exit(mycommons.constants.System.CS_EXIT_ERROR);			
		}
		
		//PrinterJob
		javax.print.DocPrintJob docPrintJob=printService_s[idxServices].createPrintJob();
		
		//SimpleDoc
		yz.logistic.print.sheets.StandardSheetB4FromDB printObj=new yz.logistic.print.sheets.StandardSheetB4FromDB();
		printObj.init(paraConnection, sql);
		javax.print.SimpleDoc doc=new javax.print.SimpleDoc(printObj,docFlavor , null);
		
		//print
		try{
			docPrintJob.print(doc, serviceAttributes);
		}catch(Exception e){
			//log and exit
			System.out.println("printing is failed.exit this program.");
			System.exit(mycommons.constants.System.CS_EXIT_ERROR);
		}		
	}
}
