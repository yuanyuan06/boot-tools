package yuan.yuan.boot_tools.velocity;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class VelocityTest {
	
	@Test
	public void testVelocity() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("uVBean", "dsds");
		model.put("resAndLoginReports", "dsg");
	}
}
