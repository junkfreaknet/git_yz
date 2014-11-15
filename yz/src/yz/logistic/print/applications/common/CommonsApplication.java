package yz.logistic.print.applications.common;
//*************************************************************************
//***** APPLICATION COMMOM PROCEDURES
//***** &
//*****	APPLICATION GLOBAL VARiABLES
//*****
//*************************************************************************
public class CommonsApplication implements mycommons.applications.commons.CommonsApplication{

	//seting file name
	final String settingFileName="Setting.properties";

	String AppName;
	
	public CommonsApplication(String pgName){
	
		this.AppName=pgName;
	
	}
	
	public void start(){
		
		mycommons.logging.Logging.info("start "+this.AppName);
	}
	public void start(String pgName){
		
		this.AppName=pgName;
		this.start();
	
	}
	public void end(){}
	public void run(){}
	//get paramaters for connecting to database
	public static void getParamatersConnectToDatabase(){
		
		java.util.Properties properties=new java.util.Properties();
		try{
			
		}catch(Exception e){
			
		}
	}
	//get fields
	public static void getFieldsOfDatabaae(){
		
	}
	//private method
	/***
	static java.io.InputStream getSettingFile(){
		java.io.InputStream inputStream=null;
		try{
			inputStream=new java.io.FileInputStream(new java.io.File(settingFileName));	
			//return inputStream;
		}catch(Exception e){
			mycommons.logging.Logging.info("failed getting application setting file");
			System.exit(mycommons.constants.System.CS_EXIT_ERROR);
		}finally{
			return inputStream;
		}
	}
	***/
}
