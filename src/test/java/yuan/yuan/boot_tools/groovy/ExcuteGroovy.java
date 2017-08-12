package yuan.yuan.boot_tools.groovy;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.scripting.ScriptSource;
import org.springframework.scripting.support.ResourceScriptSource;

import com.alibaba.fastjson.JSON;


public class ExcuteGroovy {
	
	@SuppressWarnings("resource")
	@Test
	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring_junit_config.xml");
		RuleRoleService rule = (RuleRoleService) context.getBean("roleRule");
//		while(true) {
			List<String> assignRole = rule.assignRole("任务3");
			System.out.println(JSON.toJSONString(assignRole));
			
			String task = rule.findTaskByIncident("事件1");
			System.out.println(task);
//		}
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
