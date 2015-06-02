package yz.logistic.print.applications.common;
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
	final String DBSourceProperty="DBSource";	
	final String DBSourcePropertyFile="DBSource.properties";
	final String DBDistProperty="DBDist";
	final String DBDistPropertyFile="DBDist.properties";
	final String DBWorkProperty="DBWork";
	final String DBWorkPropertyFile="DBWork.properties";

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
		
		mycommons.db.connection.ParaConnection rv=this.setParaConnectToDatabase(new mycommons.routines.file.Filename(yz.logistic.print.sheets.Constants.DEFAULT_SETTING_PROPERTIES_FILE));
		return rv;
	}
	
	public mycommons.db.connection.ParaConnection setParaConnectToDatabase(mycommons.routines.file.Filename propertiesFile){
		
		mycommons.db.connection.ParaConnection rv=new mycommons.db.connection.ParaConnection();

		try{
			java.util.Properties properties=new java.util.Properties();
			java.io.InputStream is=new java.io.FileInputStream(propertiesFile.getName());
			properties.load(is);
			System.out.println(properties.getProperty(yz.logistic.print.sheets.Constants.KEY_VALUE_PRINTER_SETTING));

		}catch(Exception e){
			mycommons.logging.Logging.severe("setting database connection parameters failed.stop this program.");
			System.exit(mycommons.constants.System.CS_EXIT_ERROR);	
			//return rv;
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
