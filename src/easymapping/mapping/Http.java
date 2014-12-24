package easymapping.mapping;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class Http {

	private HttpServletRequest req;
	private HttpServletResponse resp;
	private ArrayList<String> params;

	public HttpServletRequest getReq() {
		return req;
	}

	public HttpServletResponse getResp() {
		return resp;
	}

	public <T> T getJsonObject(Class<T> cLass, String name) {
		return new Gson().fromJson(req.getParameter(name), cLass);

	}

	public <T> T getJsonObject(Class<T> cLass) {
		Gson gson = new Gson();
		return gson.fromJson(gson.toJson(req.getParameterMap()), cLass);
	}

	public String getParameter(String name) {
		return req.getParameter(name);
	}

	public Map<String, String[]> getParameterMap() {
		return req.getParameterMap();
	}

	public Http(HttpServletRequest req, HttpServletResponse resp) {
		this.req = req;
		this.resp = resp;
	}

	public void forword(String path) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher(path);
		rd.forward(req, resp);
	}

	public void setContentType(String type) {
		resp.setContentType(type);
	}

	public void write(String string) throws IOException {
		resp.getWriter().write(string);
	}

	public void setParams(ArrayList<String> params) {
		this.params = params;
	}

	public String getUriVariable(int number) {
		return params.get(number);
	}

	public void setCharacterEncoding(String encording) throws UnsupportedEncodingException {
		req.setCharacterEncoding(encording);
		resp.setCharacterEncoding(encording);
	}

	public void sendNotFound() {
		try {
			resp.sendError(404, req.getRequestURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
