package logExperiment;

//experimental class for logging.
public class LoggingMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.logging.Logger logger=java.util.logging.Logger.getLogger("loggingMain");
		logger.info("start program.");
		Gen01 gen01=new Gen01();
		logger.info("end program.");
	}

}
