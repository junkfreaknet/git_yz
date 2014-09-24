package testsX;

//import java.util.logging.FileHandler;

public class LoggingX {

	static java.util.logging.Logger logger;
	static String appName;
	
	static java.util.logging.FileHandler fileHandler;
	
	public LoggingX(String pgName){
		init(pgName);
	}
	public static void init(String pgName){
		
		logger=java.util.logging.Logger.getLogger(pgName);
		fileHandler=getFileHandler(pgName);
		logger.addHandler(fileHandler);
		appName=pgName;
		
	}
	//
	public static void logInfo(String method,String message){
		
		String buff;
		buff=appName+" "+method+" "+message;
		logger.info(buff);
	}
	public static void logWarnig(String method,String message){
		
		String buff;
		buff=appName+" "+method+" "+message;
		logger.warning(buff);
	}
	public static void logError(String method,String message){
		
		String buff;
		buff=appName+" "+method+" "+message;
		logger.warning(buff);
	}
	//
	static java.util.logging.FileHandler getFileHandler(String nameHandler){
		
		java.util.logging.FileHandler rv=null;
		
		try{
			rv=new java.util.logging.FileHandler(nameHandler+".log");
		}catch(Exception e){
			System.out.println("failed creating logging handler to file. ");
			System.exit(0);
		}finally{

		}
		return rv;
	}
}
