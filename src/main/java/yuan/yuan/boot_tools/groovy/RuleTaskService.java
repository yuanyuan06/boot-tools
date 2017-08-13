package yuan.yuan.boot_tools.groovy;

public interface RuleTaskService {

	/**
	 * 规则决定了单据接下来的状态
	 * @param so
	 * @return
	 */
	String createTask(Object so);
	
}
