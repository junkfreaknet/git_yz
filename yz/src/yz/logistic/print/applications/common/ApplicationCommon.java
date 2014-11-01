package yz.logistic.print.applications.common;
//*************************************************************************
//***** APPLICATION COMMOM PROCEDURES
//***** &
//*****	APPLICATION GLOBAL VARiABLES
//*****
//*************************************************************************
public class ApplicationCommon {

	//name of application
	static String AplicationName;
	//seting file name
	static final String settingFileName="Setting.properties";
	//
	public static void startUP(){
		
	}
	public static void end(){
		
	}
	//get paramaters for connecting to database
	public static void getParamatersConnectToDatabase(){
		
		java.util.Properties properties=new java.util.Properties();
		try{
			
		}catch(Exception e){
			
		}
	}
	//private method 
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
}
