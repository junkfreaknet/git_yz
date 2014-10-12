package xml;

import java.security.KeyStore.Builder;

public class MainTestXML2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("*****start MainTestXML.*****");
		javax.xml.parsers.DocumentBuilderFactory factory=javax.xml.parsers.DocumentBuilderFactory.newInstance();
		
		try{
			javax.xml.parsers.DocumentBuilder builder=factory.newDocumentBuilder();
			String uri="DBSetting.xml";
			//String uri="myfile.xml";
			
			org.w3c.dom.Document doc=builder.parse(uri);
			if(doc.getNodeType()==org.w3c.dom.Node.DOCUMENT_NODE){
				System.out.println("first node is document.");
			}
			System.out.println("doc name is "+doc.getNodeName());
			org.w3c.dom.NodeList children=doc.getChildNodes();
			for(int i=0;i<children.getLength();i++){
				org.w3c.dom.Node child=children.item(i);
				System.out.println(""+child.getNodeName());
			}
			/***
			org.w3c.dom.Document document=(org.w3c.dom.Document)root;
			org.w3c.dom.Element element=document.getDocumentElement();
			System.out.println("element name is "+element.getNodeName());
			System.out.println("len is "+document.getChildNodes().getLength());
			System.out.println("child of "+element.getNodeName()+" "+element.getFirstChild());
			***/
			/***
			org.w3c.dom.Node firstLevel=root.getFirstChild();
			System.out.println("first child is "+firstLevel.getNodeName()+".");
			org.w3c.dom.Node lastnode=root.getLastChild();
			System.out.println("last chile is "+lastnode.getNodeName());
			org.w3c.dom.Node secondLevel=firstLevel.getFirstChild();
			if(secondLevel==null){
				System.out.println("can't get second level child.");
			}else{
				System.out.println("second child is "+secondLevel.getNodeName()+".");
				org.w3c.dom.Node thirdLevel=secondLevel.getFirstChild();
				System.out.println("the third chile is "+thirdLevel.getNodeName());
			}
			***/
			
		}catch(Exception e){
			System.out.println("Error:on building document builder ");
			System.out.println(e.toString());
			System.exit(mycommons.constants.System.CS_EXIT_ERROR);
		}
		
		System.out.println("*****end MainTestXML.*****");
	}

}
