package easymapping.mapping;

import java.io.IOException;

import com.google.gson.Gson;

public class Json implements Response{
	
	private Object jsonObj;
	Gson gson = new Gson();

	public Json(Object obj){
		this.jsonObj = obj;
	}
	
	@Override
	public void render(Http http) throws IOException {
		http.setContentType("application/json");
		http.write(gson.toJson(jsonObj));
	}

	@Override
	public String getRenderedText() {
		return gson.toJson(jsonObj);
	}
}
