package easymapping.mapping;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.google.gson.Gson;

import easymapping.mapping.TestClass;

public class HttpTest {

	Http http;
	TestClass test = new TestClass(1, 2, 3);

	@Before
	public void setup() {
		HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
		Gson gson = new Gson();
		@SuppressWarnings("unchecked")
		Map<String, String[]> map = gson.fromJson(gson.toJson(test), new HashMap<String, String[]>().getClass());
		Mockito.when(request.getParameterMap()).thenReturn(map);
		Mockito.when(request.getParameter("test")).thenReturn(gson.toJson(test));
		Mockito.when(request.getParameter("schedule")).thenReturn("{\"time\":9,\"userId\":\"zerohouse\",\"head\":\"zdsf\",\"body\":\"asdf\",\"type\":\"운동\",\"term\":0,\"date\":\"2014-12-12\"}");
		HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
		http = new Http(request, response);

	}

	@Test
	public void test() {
		TestClass test = http.getJsonObject(TestClass.class);
		assertEquals(http.getJsonObject(TestClass.class), test);
		assertEquals(http.getJsonObject(TestClass.class, "test"), test);
	}
	
	@Test
	public void parseTest(){
		System.out.println(http.getJsonObject(Schedule.class,"schedule"));
	}

}
