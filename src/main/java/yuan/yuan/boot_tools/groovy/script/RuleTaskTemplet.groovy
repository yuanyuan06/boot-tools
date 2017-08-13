package yuan.yuan.boot_tools.groovy.script

import yuan.yuan.boot_tools.groovy.RuleTaskService
import yuan.yuan.boot_tools.groovy.TestSo
import yuan.yuan.boot_tools.groovy.TestSoLine

class RuleTaskTemplet implements RuleTaskService{

	@Override
	public String createTask(def so) {
		
		if(so instanceof TestSo) {
			TestSo ts = ((TestSo) so);
			ts.setField1("ewew")
			ts.getField1();
		}else if(so instanceof TestSoLine) {
			TestSoLine ts = ((TestSoLine) so);
			ts.setFieldLine1("fdfdf")
			ts.getFieldLine1();
		}
	}

	
}
