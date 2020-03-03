package analyticalDashboard;


/*
 * Use the methods within any reporting structure or test cases to hold a count of each test case status
 */

public class LogSteps {
	
	
	public static MapSteps sm = new MapSteps();

	public static int passCount=0;
	public static int failCount=0;
	public static int skipCount=0;
	public static int fatalCount=0;
	public static int warnCount=0;
	public static int infoCount=0;

	public static void PassStep() {
		passCount = passCount+1;
	}

	public static void FailStep() {
		failCount = failCount+1;
	}

	public static void SkipStep() {
		skipCount = skipCount+1;
	}

	public static void FatalStep() {
		fatalCount = fatalCount+1;
	}

	public static void WarnStep() {
		warnCount = warnCount+1;
	}
	
	public static void InfoStep() {
		infoCount = infoCount+1;
	}
	
	
	public MapSteps setStepMap() {
		
		sm.setPassed(passCount);
		sm.setFailed(failCount);
		sm.setSkipped(skipCount);
		sm.setFatal(fatalCount);
		sm.setOther(warnCount + infoCount);
		
		return sm;
		
	}
	

	public int totalSteps() {

		int totalSteps = passCount + failCount + skipCount + fatalCount + warnCount + infoCount;
		return totalSteps;
	}

	public String testCaseStatus() {
		String status = "";

		if (fatalCount > 0) {
			status = "EXCEPTION";
		}else if (skipCount > 0) {
			status = "SKIPPED";
		}else if (failCount > 0) {
			status = "FAILED";
		}else {
			status = "PASSED";
		}

		return status;
	}

	public void resetStepCount() {

		passCount = 0;
		failCount = 0;
		skipCount = 0;
		fatalCount = 0;
		warnCount = 0;
		infoCount = 0;
	}

}
