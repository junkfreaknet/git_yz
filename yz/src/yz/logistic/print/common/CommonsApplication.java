package yz.logistic.print.common;

import mycommons.db.connection.DataBase;
import mycommons.db.connection.ParaConnection;
import mycommons.net.tcp.Port;

//*************************************************************************
//***** APPLICATION COMMOM PROCEDURES
//***** &
//*****	APPLICATION GLOBAL VARiABLES
//*****
//*************************************************************************
public class CommonsApplication implements mycommons.applications.commons.CommonsApplication{

	//seting file name
	//final String defaultSettingFileName="DefaultSetting.properties";
	
	//type of db
	//final String DBSourceProperty="DBSource";	
	//final String DBSourcePropertyFile="DBSource.properties";
	//final String DBDistProperty="DBDist";
	//final String DBDistPropertyFile="DBDist.properties";
	//final String DBWorkProperty="DBWork";
	//final String DBWorkPropertyFile="DBWork.properties";

	private String AppName;
	
	public CommonsApplication(String pgName){
		
		this.setApplicationName(pgName);
	
	}
	
	public void start(String pgName){
		
		this.AppName=pgName;
		this.start();
	
	}
	public void start(){
		
		mycommons.logging.Logging.info("start "+this.AppName);
	}
	public void end(){
		
		mycommons.logging.Logging.info("end "+this.AppName);
	
	}
	
	public void run(){}
	
	//*****misc*****
	public void setApplicationName(String pgName){
		this.AppName=pgName;
	}
	//*****get paramaters for connecting to database*****
	
	public mycommons.db.connection.ParaConnection setParaConnectToDatabase(){
		
		mycommons.db.connection.ParaConnection rv=this.setParaConnectToDatabase(new mycommons.routines.file.Filename(yz.logistic.print.common.Constants.DEFAULT_SETTING_PROPERTIES_FILE));
		return rv;
	}
	
	public mycommons.db.connection.ParaConnection setParaConnectToDatabase(mycommons.routines.file.Filename propertiesFile){
		
		mycommons.db.connection.ParaConnection rv=new mycommons.db.connection.ParaConnection();

		try{
			java.util.Properties properties=new java.util.Properties();
			java.io.InputStream is=new java.io.FileInputStream(propertiesFile.getName());
			properties.load(is);
			//System.out.println(properties.getProperty(yz.logistic.print.common.Constants.KEY_VALUE_DATABASE_CONNECTION_SETTING));
			rv=this.setParaConnectToDatabaseCommon(new mycommons.routines.file.Filename(properties.getProperty(yz.logistic.print.common.Constants.KEY_VALUE_DATABASE_CONNECTION_SETTING)));
		}catch(Exception e){
			mycommons.logging.Logging.severe("setting database connection parameters failed.stop this program.");
			System.exit(mycommons.constants.System.CS_EXIT_ERROR);	
		}
		return rv;
	}
	private mycommons.db.connection.ParaConnection setParaConnectToDatabaseCommon(mycommons.routines.file.Filename databaseConnectionXML){
		
		//sequence is ....
		//1.factory
		//2.builder
		//3.document
		//4.root element
		
		mycommons.db.connection.ParaConnection rv=new mycommons.db.connection.ParaConnection();
		
		try{
			javax.xml.parsers.DocumentBuilderFactory factory=javax.xml.parsers.DocumentBuilderFactory.newInstance();
			javax.xml.parsers.DocumentBuilder documentBuilder=factory.newDocumentBuilder();
			org.w3c.dom.Document document=documentBuilder.parse(databaseConnectionXML.getName());
			org.w3c.dom.Element root=document.getDocumentElement();//get root element
			
			org.w3c.dom.Element connection=document.getDocumentElement();//get element for database connection
			
			rv.setDataBase(new mycommons.db.connection.DataBase(connection.getAttribute(yz.logistic.print.common.Constants.ATTRIBUTE_NAME_DATABASE_CONNECTION_DATABASE)));
			rv.setForName(new mycommons.db.connection.ForName(mycommons.constants.DB.MS_SQL_SERVER_FOR_NAME));
			rv.setHost(new mycommons.db.connection.Host(connection.getAttribute(yz.logistic.print.common.Constants.ATTRIBUTE_NAME_DATABASE_CONNECTION_HOST)));
			rv.setInstance(new mycommons.db.connection.Instance(connection.getAttribute(yz.logistic.print.common.Constants.ATTRIBUTE_NAME_DATABASE_CONNECTION_INSTANCE)));
			rv.setPassWord(new mycommons.db.connection.Password(connection.getAttribute(yz.logistic.print.common.Constants.ATTRIBUTE_NAME_DATABASE_CONNECTION_PASSWORD)));
			rv.setPort(new mycommons.net.tcp.Port(connection.getAttribute(yz.logistic.print.common.Constants.ATTRIBUTE_NAME_DATABASE_CONNECTION_PORT)));
			rv.setServer(new mycommons.db.connection.Server(mycommons.constants.DB.SERVER_SQLSERVER));
			rv.setUser(new mycommons.db.connection.User(connection.getAttribute(yz.logistic.print.common.Constants.ATTRIBUTE_NAME_DATABASE_CONNECTION_USER)));
			
		}catch(Exception e){
			mycommons.logging.Logging.severe("setting database connection COMMON parameters failed.stop this program.");
			System.exit(mycommons.constants.System.CS_EXIT_ERROR);
		}
		
		return rv;
	}
	
	/***
	public mycommons.db.connection.ParaConnection setParaSourceConnectToDatabase(){
		mycommons.db.connection.ParaConnection rv=this.setParaConnectToDatabase();
		return rv;
	}
	public mycommons.db.connection.ParaConnection setParaSourceConnectToDatabase(mycommons.routines.file.Filename settingFile){
		mycommons.db.connection.ParaConnection rv=this.setParaConnectToDatabase(settingFile);
		return rv;
	}
	***/
}
