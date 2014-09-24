package testsX;

public class Logging {

	private java.util.logging.Logger logger;
	private String pgName;
	//static String pgName;
	private String methodName;
	
	//constructor
	public Logging(String name_pg){
		this.logger=java.util.logging.Logger.getLogger(name_pg);
		this.pgName=name_pg;
	}
	
	//public method
	//
	public void logINFO(String name_method,String message){
		logger.info(this.pgName+" "+name_method+":"+message);
	}
	//
	/***
	static void logINFO(String name_method,String message){
		this.logger.info(pgName+" "+name_method+":"+message);
	}
	***/
}
