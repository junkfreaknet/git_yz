package xml;

public class MainSAXXML {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String PGNAME="saxXML";
		String XMLFILE="DBSetting2.xml";
		String logBuff;
		java.util.logging.Logger logger=java.util.logging.Logger.getLogger(PGNAME);
		try{
			logBuff="***** "+"start "+PGNAME+"."+" *****";
			logger.info(logBuff);
			//create sax factory
			javax.xml.parsers.SAXParserFactory saxParserFactory=javax.xml.parsers.SAXParserFactory.newInstance();
			//create sax parser
			javax.xml.parsers.SAXParser saxParser=saxParserFactory.newSAXParser();
			//get a sax reader
			org.xml.sax.XMLReader xmlReader=saxParser.getXMLReader();
			//get a xml handler
			org.xml.sax.helpers.DefaultHandler df=new myHandler();
			xmlReader.setContentHandler(df);
			//parse xml document
			xmlReader.parse(XMLFILE);
			//end program safely.
			logBuff="***** "+"end "+PGNAME+"."+" *****";
			logger.info(logBuff);
		}catch(Exception e){
			//end program by caused an error.
			logger.severe("an error coursed.");
			logger.severe(e.toString());
			logBuff="***** "+"end "+PGNAME+"."+" *****";
			logger.severe(logBuff);
			System.exit(0);
		}
	}

}
class myHandler extends org.xml.sax.helpers.DefaultHandler{
	String HANDLER="MyHandler";
	String logBuff;
	public void startDocument() throws org.xml.sax.SAXException{
		java.util.logging.Logger logger=java.util.logging.Logger.getLogger(this.HANDLER);
		logger.info("start document.");
	}
	public void endDocument() throws org.xml.sax.SAXException{
		java.util.logging.Logger logger=java.util.logging.Logger.getLogger(this.HANDLER);
		logger.info("end document.");
	}
	public void startElement(String uri,String localName,String qName,org.xml.sax.Attributes attr) throws org.xml.sax.SAXException{
		java.util.logging.Logger logger=java.util.logging.Logger.getLogger(this.HANDLER);
		logger.info("start "+qName+".");
		//logBuff=uri+","+localName+","+qName;
		logger.info(logBuff);
		for(int i=0;i<attr.getLength();i++){
			logBuff=attr.getQName(i);
			logBuff=logBuff+":"+"\""+attr.getValue(i)+"\"";
			logger.info(logBuff);
		}
		
	}
	public void endElement(String uri,String localName,String qName) throws org.xml.sax.SAXException{
		java.util.logging.Logger logger=java.util.logging.Logger.getLogger(this.HANDLER);
		logger.info("end "+qName+".");
		//logBuff=uri+","+localName+","+qName;
		/***
		logger.info(logBuff);
		for(int i=0;i<attr.getLength();i++){
			logBuff=attr.getQName(i);
			logBuff=logBuff+":"+"\""+attr.getValue(i)+"\"";
			logger.info(logBuff);
		}
		***/
	}	
	/***
	public void skippedEntity(String name) throws org.xml.sax.SAXException{
		java.util.logging.Logger logger=java.util.logging.Logger.getLogger(this.HANDLER);
		logger.info("skipped "+name);
	}
	***/
	/***
	public void characters(char[] ch,int start,int length) throws org.xml.sax.SAXException{
		java.util.logging.Logger logger=java.util.logging.Logger.getLogger(this.HANDLER);

		logBuff=String.valueOf(ch);
		logger.info(logBuff);
	}
	***/
}
