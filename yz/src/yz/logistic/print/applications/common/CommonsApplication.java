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
	
	//misc
	public void setApplicationName(String pgName){
		this.AppName=pgName;
	}
	//get paramaters for connecting to database
	
	public mycommons.db.connection.ParaConnection setParaConnectToDatabase(){
		
		mycommons.db.connection.ParaConnection rv=this.setParaConnectToDatabase(new mycommons.routines.file.Filename(settingFileName));
		return rv;
	}
	
	public mycommons.db.connection.ParaConnection setParaConnectToDatabase(mycommons.routines.file.Filename settingFile){
		
		mycommons.db.connection.ParaConnection rv=new mycommons.db.connection.ParaConnection();
		return rv;
	}
	public mycommons.db.connection.ParaConnection setParaSourceConnectToDatabase(){
		mycommons.db.connection.ParaConnection rv=this.setParaConnectToDatabase();
		return rv;
	}
	public mycommons.db.connection.ParaConnection setParaSourceConnectToDatabase(mycommons.routines.file.Filename settingFile){
		mycommons.db.connection.ParaConnection rv=this.setParaConnectToDatabase(settingFile);
		return rv;
	}
}
