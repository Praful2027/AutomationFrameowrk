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
	"Passed",
	"Failed",
	"Skipped",
	"Fatal",
	"Other"
})

public class MapSteps {
	
	
	@JsonProperty("Passed")
	private Integer passed;
	
	@JsonProperty("Failed")
	private Integer failed;
	
	@JsonProperty("Skipped")
	private Integer skipped;
	
	@JsonProperty("Fatal")
	private Integer fatal;
	
	@JsonProperty("Other")
	private Integer other;
	
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("Passed")
	public Integer getPassed() {
		return passed;
	}

	@JsonProperty("Passed")
	public void setPassed(Integer passed) {
		this.passed = passed;
	}

	@JsonProperty("Failed")
	public Integer getFailed() {
		return failed;
	}

	@JsonProperty("Failed")
	public void setFailed(Integer failed) {
		this.failed = failed;
	}

	@JsonProperty("Skipped")
	public Integer getSkipped() {
		return skipped;
	}

	@JsonProperty("Skipped")
	public void setSkipped(Integer skipped) {
		this.skipped = skipped;
	}
	
	@JsonProperty("Fatal")
	public Integer getFatal() {
		return fatal;
	}

	@JsonProperty("Fatal")
	public void setFatal(Integer fatal) {
		this.fatal = fatal;
	}

	@JsonProperty("Other")
	public Integer getOther() {
		return other;
	}

	@JsonProperty("Other")
	public void setOther(Integer other) {
		this.other = other;
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
