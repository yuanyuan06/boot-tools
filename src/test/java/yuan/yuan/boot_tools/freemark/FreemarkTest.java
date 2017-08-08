package yuan.yuan.boot_tools.freemark;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import freemarker.template.Configuration;
import freemarker.template.Version;


public class FreemarkTest {

	@Test
	public void testTemplate() throws IOException {
		Configuration configuration = new Configuration(new Version(0));
		configuration.setDirectoryForTemplateLoading(new File("hello.ftl"));
	}
}
