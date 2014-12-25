package easymapping.mapping;

import static org.junit.Assert.*;

import org.junit.Test;

public class MatchTest {

	@Test
	public void test() throws NoSuchMethodException, SecurityException {
		Match map = new Match();

		map.put("/index/{}.my", MatchTest.class.getMethod("test"));
		map.put("/users/login.my", MatchTest.class.getMethod("test"));
		assertEquals(map.get("/users/login.my").getMethod().getName(), "test");
		assertNull(map.get("i/"));
		assertEquals(map.get("/index/asdfas.my").getMethod(), map.get("/index/asdzdzdfdas.my").getMethod());
	}

}
