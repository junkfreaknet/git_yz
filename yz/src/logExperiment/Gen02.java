package logExperiment;

public class Gen02 {

	public Gen02(){
		//System.out.println(this.getClass().getName()+" is noew created!!");
		java.util.logging.Logger logger=java.util.logging.Logger.getLogger("loggingMain");
		logger.info("Create Gen02.");
	}
}
