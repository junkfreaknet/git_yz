package xml;
import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;

public class MainTestXML3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try {
            DocumentBuilderFactory factory 
                 = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
  
            File f = new File( "DBSetting.xml" );
            Document doc = builder.parse( f );
            Element root = doc.getDocumentElement();
            System.out.println("root is "+root.getNodeName());
            NodeList children = root.getChildNodes();

            for( int i=0; i<children.getLength(); i++ ) {
            
                 Node child = children.item(i);
                 
                 if( child instanceof Element ) {
                 
                      Element childElement = (Element) child;
                      
                      System.out.println( childElement.getTagName() );
                                          
                 }
            
            }
            
       }
       catch( ParserConfigurationException e ) {
       }
       catch( SAXException e ) {
       }
       catch( IOException e ) {
       }
	}

}
