package yuan.yuan.boot_tools.groovy;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSON;

public class AppContext {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring_groovy.xml");
		RuleRoleService rule = (RuleRoleService) context.getBean("roleRule");
		List<String> assignRole = rule.findRolesForTask("任务3");
		System.out.println(JSON.toJSONString(assignRole));
		
		String task = rule.findTaskByIncident("事件1");
		System.out.println(task);
	}
}
