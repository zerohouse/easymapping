컨트롤러를 쉽게.
===========

Json형식으로 WEB-INF/controller.setting 파일을 읽음

	{
		"url" : "http://localhost:8080",
		"controllerPath" : "mytoday.controller",
		"jspPath" : "/jsp/",
		"charEncoding" : "utf-8"
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

