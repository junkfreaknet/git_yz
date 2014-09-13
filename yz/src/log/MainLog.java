package log;
import java.util.logging.*;

public class MainLog {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final String LOGNAME="logfile";
		final java.util.logging.Logger logger=java.util.logging.Logger.getLogger(LOGNAME);
		logger.info("hello guests!");
		logger.warning("don't miss you!!");
	}

}
