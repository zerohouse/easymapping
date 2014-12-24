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
		HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
		http = new Http(request, response);

	}

	@Test
	public void test() {
		TestClass test = http.getJsonObject(TestClass.class);
		assertEquals(http.getJsonObject(TestClass.class), test);
		assertEquals(http.getJsonObject(TestClass.class, "test"), test);
	}

}
