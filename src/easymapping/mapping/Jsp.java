package easymapping.mapping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import easymapping.setting.Setting;

public class Jsp implements Response {

	private static final String jspPath = Setting.get(Setting.JSP);
	private String jspFile;
	private List<String> keys = new ArrayList<String>();
	private List<Object> objs = new ArrayList<Object>();

	public Jsp(String jspFile) {
		this.jspFile = jspFile;
	}

	public void put(String key, Object obj) {
		keys.add(key);
		objs.add(obj);
	}

	@Override
	public void render(Http http) throws ServletException, IOException {
		for (int i = 0; i < keys.size(); i++) {
			http.getReq().setAttribute(keys.get(i), objs.get(i));
		}
		http.forword(jspPath + jspFile);
	}

	@Override
	public String getRenderedText() {
		return "Jsp [jspFile=" + jspFile + ", keys=" + keys + ", objs=" + objs + "]";
	}

}
