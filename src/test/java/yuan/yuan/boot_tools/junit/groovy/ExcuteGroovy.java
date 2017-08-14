package yuan.yuan.boot_tools.junit.groovy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.scripting.ScriptSource;
import org.springframework.scripting.support.ResourceScriptSource;

import com.alibaba.fastjson.JSON;

import yuan.yuan.boot_tools.groovy.RuleRoleService;
import yuan.yuan.boot_tools.groovy.RuleTaskService;
import yuan.yuan.boot_tools.groovy.TestSo;
import yuan.yuan.boot_tools.groovy.TestSoLine;


public class ExcuteGroovy {
	
	private ApplicationContext context;
	
	@Before
	public void getContext() {
		context = new ClassPathXmlApplicationContext("spring_junit_config.xml");
	}
	
	@Test
	public void test() {
		
		RuleRoleService rule = (RuleRoleService) context.getBean("roleRule");
		List<String> assignRole = rule.findRolesForTask("任务3");
		System.out.println(JSON.toJSONString(assignRole));
		
		String task = rule.findTaskByIncident("事件1");
		System.out.println(task);
	}
	
	@Test
	public void testTaskRule() {
		RuleTaskService rule = (RuleTaskService) context.getBean("taskRule");
		
		
		TestSoLine sl = new TestSoLine();
		sl.setFieldLine2("");
		String s = rule.createTask(sl);
		System.out.println(s);
		
		rule.createTask("fdfd");
		
		TestSo ts = new TestSo();
		ts.setField1("TestSo");
		List<TestSoLine> add = new ArrayList<TestSoLine>();
		add.add(sl);
		ts.setLines(add);
		String so = rule.createTask(ts);
		
		System.out.println(so+ " " + ts.getField1());
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
