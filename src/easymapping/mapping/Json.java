package easymapping.mapping;

import java.io.IOException;

import com.google.gson.Gson;

public class Json implements Response{
	
	private Object jsonObj;

	public Json(Object obj){
		this.jsonObj = obj;
	}
	
	@Override
	public void render(Http http) throws IOException {
		Gson gson = new Gson();
		http.setContentType("application/json");
		http.write(gson.toJson(jsonObj));
	}
}