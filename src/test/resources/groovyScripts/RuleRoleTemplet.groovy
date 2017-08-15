package yuan.yuan.boot_tools.groovy.script

import java.util.List

import org.codehaus.groovy.antlr.Main

import yuan.yuan.boot_tools.groovy.RuleRoleService

class RuleRoleTemplet implements RuleRoleService {
	
	// 任务角色关系
	def taskRole = ["任务1": [
							"角色1",
							"角色2",
							"角色3"
							],
					"任务2": [
							"角色3",
							"角色6",
							"角色9"
							],
					"任务3": [
						"角色5",
						"角色7",
						"角色3"
						]
					];
	
	@Override
	public List<String> findRolesForTask(String task) {
		taskRole.get(task);
	}

	// 事件任务关系
	def tasks=[:];
	def task = ["事件1", 
				"事件2", 
				"事件3", 
				"事件4", 
				"事件5"].each{
						tasks.put(it, "任务0")
							};
	
	@Override
	public String findTaskByIncident(String incident) {
		tasks.containsKey(incident);
		tasks.get(incident);
	}
	
	static void main() {
		println "fdfd";
	}
} 
