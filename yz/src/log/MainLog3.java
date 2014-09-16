package log;

public class MainLog3 {

	protected static final String LOGGING_PROPERTIES = "javalog.properties";
	
	 static {
	        final java.util.logging.Logger logger = java.util.logging.Logger.getLogger("SampleLogging");

	        // クラスパスの中から ログ設定プロパティファイルを取得
	        logger.fine("ログ設定: " + LOGGING_PROPERTIES 
	            + " をもとにログを設定します。");
	        final java.io.InputStream inStream = MainLog3.class
	            .getClassLoader().getResourceAsStream(
	            LOGGING_PROPERTIES);
	        if (inStream == null) {
	            logger.info("ログ設定: " + LOGGING_PROPERTIES 
	                 + " はクラスパス上に見つかりませんでした。");
	        } else {
	            try {
	                java.util.logging.LogManager.getLogManager().readConfiguration(
	                    inStream);
	                logger.config(
	                    "ログ設定: LogManagerを設定しました。");
	            } catch (java.io.IOException e) {
	                logger.warning("ログ設定: LogManager設定の際に"
	                    +"例外が発生しました。:"+ e.toString());
	            } finally {
	                try {
	                    if (inStream != null) inStream.close(); 
	                } catch (java.io.IOException e) {
	                    logger.warning("ログ設定: ログ設定プロパティ"
	                        +"ファイルのストリームクローズ時に例外が"
	                        +"発生しました。:"+ e.toString());
	                }
	            }
	        }
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final String LOGFILE="SampleLogging";
		//final String LOGFILE="logfile2";		
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

