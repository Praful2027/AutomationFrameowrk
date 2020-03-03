package analyticalDashboard;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.Unirest;

public class SendObjectToElastic {

	private static final ObjectMapper OMAP = new ObjectMapper();

	public static void sendJSONObject(final Object jsonObject, String elastic_url){
		try {
			Unirest.post(elastic_url)
			.header("Content-Type", "application/json")
			.body(OMAP.writeValueAsString(jsonObject)).asJson();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
