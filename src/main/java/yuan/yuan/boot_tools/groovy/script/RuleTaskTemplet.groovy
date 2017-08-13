package yuan.yuan.boot_tools.groovy.script

import yuan.yuan.boot_tools.groovy.RuleTaskService
import yuan.yuan.boot_tools.groovy.TestSo
import yuan.yuan.boot_tools.groovy.TestSoLine

class RuleTaskTemplet implements RuleTaskService{

	@Override
	public String createTask(def so) {
		if(so instanceof TestSo) {
			TestSo ts = so;
			ts.setField1("TestSo")
			ts.getField1();
		}else if(so instanceof TestSoLine) {
			TestSoLine ts = so;
			ts.setFieldLine1("TestSoLine")
			ts.getFieldLine1();
		}else {
			println "IllegalArgumentException";
			throw new IllegalArgumentException();
		}
	}
}
