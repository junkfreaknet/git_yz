package testsX;

//import javax.print.attribute.standard.JobName;
//import javax.print.attribute.standard.OrientationRequested;

public class TestPtintService {


	/***
		print by using javax.print.
		print source is object.
	***/
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
		
		//create simple doc
		javax.print.Doc doc=new javax.print.SimpleDoc(new PrintClass(),docFlavor,null);
		//print
		try{
			job.print(doc, printAttributes);
		}catch(Exception e){
			System.out.println("doc printing is failed.");
		}
		System.out.println("end program.");
	}

}

