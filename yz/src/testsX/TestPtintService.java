package testsX;

//import javax.print.attribute.standard.JobName;
//import javax.print.attribute.standard.OrientationRequested;

public class TestPtintService implements java.awt.print.Printable{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//serach printing service
		//can print B4 size paper.paper orientation is landacape.
		
		//doc flavor
		javax.print.DocFlavor docFlavor=javax.print.DocFlavor.SERVICE_FORMATTED.PRINTABLE;
		//attribute
		javax.print.attribute.HashPrintRequestAttributeSet printAttributes=new javax.print.attribute.HashPrintRequestAttributeSet();
		
		printAttributes.add(javax.print.attribute.standard.OrientationRequested.LANDSCAPE);
		String dateTime=mycommons.routines.generic.Useful.getYYYYMMDD_HHMMSS(java.util.Calendar.getInstance());
		printAttributes.add(new javax.print.attribute.standard.JobName("TestPtintService-"+dateTime,null));
		printAttributes.add(javax.print.attribute.standard.MediaSizeName.ISO_B4);
		
		//search services
		javax.print.PrintService[] service_s=javax.print.PrintServiceLookup.lookupPrintServices(docFlavor, printAttributes);
		
		if (service_s.length==mycommons.constants.Generic.CS_ARRAY_HAS_NO_ELEMENT){
			System.out.println("have no printer.");
			System.exit(1);
		}else{
			for(int i=0;i<service_s.length;i++){
				System.out.println(service_s[i].getName());
			}
		}
		
		//create print job
		javax.print.DocPrintJob job=service_s[0].createPrintJob();
		
		java.awt.print.PrinterJob pj=java.awt.print.PrinterJob.getPrinterJob();
		pj.setPrintable(new TestPtintService());
		try{
			//pj.print();
			System.out.println("end print.");
		}catch(Exception e){
			System.out.println("failed print.");
		}
	}
	public int print(java.awt.Graphics g,java.awt.print.PageFormat pf,int page) throws java.awt.print.PrinterException{


		if(page==0){
			g.drawString("abcdefg", 100, 100);
			return java.awt.print.Printable.PAGE_EXISTS;
		}else{
			return java.awt.print.Printable.NO_SUCH_PAGE;
		}

	}
}
