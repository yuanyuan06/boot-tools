package yuan.yuan.boot_tools.groovyScripts

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

println taskRole.keySet();
println taskRole.values();
println taskRole.entrySet();

def s = taskRole.entrySet();
for(ss in s) {
	println ss.getValue().contains("角色5");
}
println s
