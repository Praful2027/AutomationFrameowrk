package reporting;

import extentReportResources.BuildExtent;
import log4jResources.LogBuilder;

public class ReportLogger {
	
	
	private static BuildExtent extent;
	
	private static LogBuilder log;
	
	
	public static BuildExtent getExtent() {
		return extent;
	}


	public static void setExtent(BuildExtent extent) {
		ReportLogger.extent = extent;
	}


	public ReportLogger(Object obj) {
		setExtent(new BuildExtent());
		log = new LogBuilder(obj);
		
		
	}
	
	
	//Pass step
		public static void passStep(String stepDescription) {
			BuildExtent.passStep(stepDescription);
			log.debug("Step Passed: "+stepDescription);
		}

		//Fail step
		public static void failStep(String stepDescription) {
			BuildExtent.failStep(stepDescription);
			log.debug("Step Failed: "+stepDescription);
		}

		//Skip step
		public static void skipStep(String stepDescription) {
			BuildExtent.skipStep(stepDescription);
			log.info("Step Skipped: "+stepDescription);
		}

		//Info step
		public static void infoStep(String stepDescription) {
			BuildExtent.infoStep(stepDescription);
			log.info(stepDescription);
		}

		//Warning step
		public static void warningStep(String stepDescription) {
			BuildExtent.warningStep(stepDescription);
			log.warn(stepDescription);
		}

		//Error step
		public static void errorStep(String stepDescription) {
			BuildExtent.errorStep(stepDescription);
			log.error(stepDescription);
		}

		//Exception step
		public static void fatalStep(String stepDescription) {
			BuildExtent.fatalStep(stepDescription);
			log.fatal(stepDescription);
		}



}
