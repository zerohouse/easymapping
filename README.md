컨트롤러를 쉽게.
===========

Json형식으로 WEB-INF/controller.setting 파일을 읽음

	{
		"url" : "http://localhost:8080", //사이트 주소
		"controllerPath" : "mytoday.controller", // 컨트롤러 패키지
		"jspPath" : "/jsp/", //jsp패스
		"charEncoding" : "utf-8" //캐릭터 인코딩
	}
	
	
web.xml 샘플

	<?xml version="1.0" encoding="UTF-8"?>
	<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		xmlns="http://java.sun.com/xml/ns/javaee"
		xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd"
		version="3.0">
		<display-name>Web Application</display-name>
	
		<servlet>
			<servlet-name>easymapping</servlet-name>
			<servlet-class>easymapping.mapping.Dispatcher</servlet-class>
		</servlet>
	
		<servlet-mapping>
			<servlet-name>easymapping</servlet-name>
			<url-pattern>*.easy</url-pattern>
		</servlet-mapping>
	
		<welcome-file-list>
			<welcome-file>index.jsp</welcome-file>
		</welcome-file-list>
	</web-app>

어노테이션 -------------
	
	@Controller // 클래스에 선언
	@Get("겟주소") // 메소드에 선언
	@Post("post 주소") //메소드에 선언

Controller 샘플
	
	@Controller
	public class HomeController {
		private static final Logger logger = LoggerFactory
				.getLogger(HomeController.class);
	
		@Get("/home.my")
		public Response home(Http http) { //Response를 리턴해야함
			logger.debug("home");
			return new Jsp("home.jsp");
		}
	
		@Get("/index/{}.my")     // {}변수 받을 수 잇고.
		public Response ss(Http http) {
			System.out.println(http.getUriVariable(0));
			return new Jsp("home.jsp");
		}
	
		@Get("/test.my")
		public Response sss(Http http) throws IOException {
			
			return new Json("고로니");
		}
	
	}
	
