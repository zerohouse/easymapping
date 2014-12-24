package easymapping.response;

import java.io.IOException;

import com.google.gson.Gson;

import easymapping.mapping.Http;

public class Json implements Response {

	private Object jsonObj;

	public Json(Object obj) {
		this.jsonObj = obj;
	}

	@Override
	public void render(Http http) throws IOException {
		Gson gson = new Gson();
		http.setContentType("application/json");
		http.write(gson.toJson(jsonObj));
	}

	public Object getJsonObj() {
		return jsonObj;
	}

}
