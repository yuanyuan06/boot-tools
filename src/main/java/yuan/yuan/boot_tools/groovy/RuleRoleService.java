package yuan.yuan.boot_tools.groovy;

import java.util.List;

public interface RuleRoleService {
	
	/**
	 * 获取任务所属角色
	 */
	List<String> assignRole(String task);
	
	/**
	 * 获取事件所属任务
	 * @param incident
	 * @return
	 */
	String findTaskByIncident(String incident);
}
