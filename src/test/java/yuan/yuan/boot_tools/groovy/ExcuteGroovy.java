package yuan.yuan.boot_tools.groovy;

import java.io.IOException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.scripting.ScriptSource;
import org.springframework.scripting.support.ResourceScriptSource;


public class ExcuteGroovy {
	
	@Test
	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring_junit_config.xml");
		RoleRuleService rule = (RoleRuleService) context.getBean("roleRule");
		while(true) {
			rule.assignRole();
		}
	}
	
	@Test
	public void getFromResource() throws IOException {
//		class path resource [yuan/yuan.boot_tools/groovy/script/RoleRuleTemplet.groovy]
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//		Resource resource = resolver.getResource("yuan/yuan.boot_tools/groovy/script/RoleRuleTemplet.groovy");
		Resource resource = resolver.getResource("classpath:groovyScripts/RoleRuleTemplet.groovy");
		System.out.println(resource.exists());
		ScriptSource source = new ResourceScriptSource(resource);
		String scriptAsString = source.getScriptAsString();
		System.out.println(scriptAsString);
	}
	
	@Test
	public void getFromMain() throws IOException {
//		class path resource [yuan/yuan.boot_tools/groovy/script/RoleRuleTemplet.groovy]
				PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//				Resource resource = resolver.getResource("classpath:yuan/yuan/boot_tools/groovy/script/RoleRuleTemplet.groovy");
				Resource resource = resolver.getResource("classpath:yuan/yuan/boot_tools/groovy/script/RoleRuleTemplet.groovy");
//				Resource resource = resolver.getResource("classpath:groovyScripts/RoleRuleTemplet.groovy");
				System.out.println(resource.exists());
				ScriptSource source = new ResourceScriptSource(resource);
				String scriptAsString = source.getScriptAsString();
				System.out.println(scriptAsString);
	}
}
