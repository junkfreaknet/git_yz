package testsX;

public class Logging {

	static java.util.logging.Logger logger;
	private String pgName;
	private String methodName;
	
	//constructor
	public Logging(String name_pg){
		this.logger=java.util.logging.Logger.getLogger(name_pg);
	}
	
	//public method
	public void log(String name_method,String message){
		logger.info(name_method+":"+message);
	}
}
