package xml;

import java.security.KeyStore.Builder;

public class MainTestXML {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("*****start MainTestXML.*****");
		javax.xml.parsers.DocumentBuilderFactory factory=javax.xml.parsers.DocumentBuilderFactory.newInstance();
		
		try{
			javax.xml.parsers.DocumentBuilder builder=factory.newDocumentBuilder();
			String uri="DBSetting.xml";
			//String uri="myfile.xml";
			
			org.w3c.dom.Node root=builder.parse(uri);
			if(root.getNodeType()==org.w3c.dom.Node.DOCUMENT_NODE){
				System.out.println("root is document.");
			}
			org.w3c.dom.Document document=(org.w3c.dom.Document)root;
			org.w3c.dom.Element element=document.getDocumentElement();
			System.out.println("element name is "+element.getNodeName());
			
			org.w3c.dom.Node firstLevel=root.getFirstChild();
			System.out.println("first child is "+firstLevel.getNodeName()+".");
			org.w3c.dom.Node lastnode=root.getLastChild();
			System.out.println("last chile is "+lastnode.getNodeName());
			org.w3c.dom.Node secondLevel=firstLevel.getFirstChild();
			if(secondLevel==null){
				System.out.println("can't get second level child.");
			}else{
				System.out.println("second child is "+secondLevel.getNodeName()+".");
			}
			
			
		}catch(Exception e){
			System.out.println("Error:on building document builder ");
			System.out.println(e.toString());
			System.exit(mycommons.constants.System.CS_EXIT_ERROR);
		}
		
		System.out.println("*****end MainTestXML.*****");
	}

}
