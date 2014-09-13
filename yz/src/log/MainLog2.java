package log;

public class MainLog2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final String LOGFILE="logfile2";
		
		final java.util.logging.Logger logger=java.util.logging.Logger.getLogger(LOGFILE);
		
		logger.finest("finest");
		logger.finer("finer");
		logger.fine("fine");
		
		logger.config("config");
		logger.info("info");
		logger.warning("warnig");
		logger.severe("sever");
		
	}

}
