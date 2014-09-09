package xml;

import java.security.KeyStore.Builder;

public class MainTestXML {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		javax.xml.parsers.DocumentBuilderFactory factory=javax.xml.parsers.DocumentBuilderFactory.newInstance();
		
		try{
			javax.xml.parsers.DocumentBuilder builder=factory.newDocumentBuilder();
			String uri="myfile.xml";
			org.w3c.dom.Node node=builder.parse(uri);
			
		}catch(Exception e){
			System.out.println("Error:on building document builder ");
			System.out.println(e.toString());
			System.exit(mycommons.constants.System.CS_EXIT_ERROR);
		}
		
	}

}
