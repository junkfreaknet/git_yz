package logExperiment;

public class Gen01 {

	public Gen01(){
		//System.out.println(this.getClass().getName()+" created. and ....");
		java.util.logging.Logger logger=java.util.logging.Logger.getLogger("loggingMain");
		logger.info("Create Gen01");
		Gen02 g02=new Gen02();
	}
}
