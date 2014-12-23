package easymapping.test;

import java.io.IOException;


import easymapping.annotation.Controller;
import easymapping.annotation.Get;
import easymapping.annotation.Post;
import easymapping.mapping.Http;
import easymapping.mapping.Json;
import easymapping.mapping.Jsp;
import easymapping.mapping.Response;


@Controller
public class HomeController {

	@Get("/home.my")
	public Response home() {
		Jsp jsp = new Jsp("home.jsp");
		String userName = "name";
		jsp.put("user", userName); //jsp에서 ${user}로 사용
		return jsp;
	}

	@Get("/index/{}.my")
	public Response index(Http http) throws IOException {
		http.getUriVariable(0); // returns {}value
		http.getReq(); // servlet Request
		http.getReq().getRequestURI();
		http.getResp(); // servlet Response
		http.getResp().getWriter();
		return new Jsp("home.jsp");
	}

	@Post("/test.my") //Post requst api
	public Response sss(Http http) throws IOException {
		return new Json("고로니");
	}

}
