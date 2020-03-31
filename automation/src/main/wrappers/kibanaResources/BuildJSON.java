package kibanaResources;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.ALWAYS)
@JsonPropertyOrder({
	"reportName",
	"reportType",
	"environment",
	"testRunDate",
	"testSuite",
	"testCaseName",
	"Steps",
	"totalSteps",
	"testCaseStatus",
	"reportURL"
})

public class BuildJSON {
	
	
	@JsonProperty("reportName")
	private String reportName;
	
	@JsonProperty("reportType")
	private String reportType;
	
	@JsonProperty("environment")
	private String environment;
	
	@JsonProperty("testRunDate")
	private String testRunDate;
	
	@JsonProperty("testSuite")
	private String testSuite;
	
	@JsonProperty("testCaseName")
	private String testCaseName;
	
	@JsonProperty("Steps")
	private MapSteps steps;
	
	@JsonProperty("totalSteps")
	private Integer totalSteps;
	
	@JsonProperty("testCaseStatus")
	private String testCaseStatus;
	
	@JsonProperty("reportRepositoryURL")
	private String reportRepositoryURL;
	
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("reportName")
	public String getReportName() {
		return reportName;
	}

	@JsonProperty("reportName")
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	@JsonProperty("reportType")
	public String getReportType() {
		return reportType;
	}

	@JsonProperty("reportType")
	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	@JsonProperty("environment")
	public String getEnvironment() {
		return environment;
	}

	@JsonProperty("environment")
	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	@JsonProperty("testRunDate")
	public String getTestRunDate() {
		return testRunDate;
	}

	@JsonProperty("testRunDate")
	public void setTestRunDate(String testRunDate) {
		this.testRunDate = testRunDate;
	}

	@JsonProperty("testSuite")
	public String getTestSuite() {
		return testSuite;
	}

	@JsonProperty("testSuite")
	public void setTestSuite(String testSuite) {
		this.testSuite = testSuite;
	}

	@JsonProperty("testCaseName")
	public String getTestCaseName() {
		return testCaseName;
	}

	@JsonProperty("testCaseName")
	public void setTestCaseName(String testCaseName) {
		this.testCaseName = testCaseName;
	}

	@JsonProperty("Steps")
	public MapSteps getSteps() {
		return steps;
	}

	@JsonProperty("Steps")
	public void setSteps(MapSteps steps) {
		this.steps = steps;
	}

	@JsonProperty("totalSteps")
	public Integer getTotalSteps() {
		return totalSteps;
	}

	@JsonProperty("totalSteps")
	public void setTotalSteps(Integer totalSteps) {
		this.totalSteps = totalSteps;
	}

	@JsonProperty("testCaseStatus")
	public String getTestCaseStatus() {
		return testCaseStatus;
	}

	@JsonProperty("testCaseStatus")
	public void setTestCaseStatus(String testCaseStatus) {
		this.testCaseStatus = testCaseStatus;
	}
	
	@JsonProperty("reportRepositoryURL")
	public String getReportRepositoryURL() {
		return reportRepositoryURL;
	}

	@JsonProperty("reportRepositoryURL")
	public void setReportRepositoryURL(String reportRepositoryURL) {
		this.reportRepositoryURL = reportRepositoryURL;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
