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
		javax.print.attribute.HashPrintRequestAttributeSet serviceAttributes=new javax.print.attribute.HashPrintRequestAttributeSet();
		
		serviceAttributes.add(javax.print.attribute.standard.OrientationRequested.LANDSCAPE);
		String dateTime=mycommons.routines.generic.Useful.getYYYYMMDD_HHMMSS(java.util.Calendar.getInstance());
		serviceAttributes.add(new javax.print.attribute.standard.JobName("TestPtintService-"+dateTime,java.util.Locale.getDefault()));
		serviceAttributes.add(javax.print.attribute.standard.MediaSizeName.ISO_B4);

		javax.print.attribute.Attribute[] attribute_s=serviceAttributes.toArray();
		for(int i=0;i<attribute_s.length;i++){
			System.out.println("attribute is "+attribute_s[i].getName());
		}
		
		//search services
		javax.print.PrintService[] service_s=javax.print.PrintServiceLookup.lookupPrintServices(docFlavor, serviceAttributes);
		
		if (service_s.length==mycommons.constants.Generic.CS_ARRAY_HAS_NO_ELEMENT){
			System.out.println("have no printer.");
			System.exit(1);
		}else{
			for(int i=0;i<service_s.length;i++){
				System.out.println(service_s[i].getName());
			}
		}
		
		//create print job
		int sn=1;//print service index
		javax.print.DocPrintJob job=service_s[sn].createPrintJob();
		
		//create doc attributes set
		/***
		javax.print.attribute.HashDocAttributeSet docAttributes=new javax.print.attribute.HashDocAttributeSet();
		docAttributes.add(javax.print.attribute.standard.OrientationRequested.LANDSCAPE);
		String dateTime=mycommons.routines.generic.Useful.getYYYYMMDD_HHMMSS(java.util.Calendar.getInstance());
		docAttributes.add(new javax.print.attribute.standard.JobName("TestPrintService-"+dateTime,null));
		docAttributes.add(javax.print.attribute.standard.MediaSizeName.ISO_B4);
		***/
		//create simple doc
		javax.print.Doc doc=new javax.print.SimpleDoc(new PrintClass(),docFlavor,null);
		//javax.print.Doc doc=new javax.print.SimpleDoc(new PrintClass(),docFlavor,null);
		//print
		try{
			/***
			for(int i=0;i<attribute_s.length;i++){
				System.out.println("attribute is "+attribute_s[i].getName());
			}
			***/
			job.print(doc, serviceAttributes);
			System.out.println("write document.");
		}catch(Exception e){
			System.out.println("doc printing is failed.");
		}
		System.out.println("end program.");
	}

}

