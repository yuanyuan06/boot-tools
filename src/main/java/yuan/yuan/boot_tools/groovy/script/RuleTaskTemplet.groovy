package yuan.yuan.boot_tools.groovy.script

import yuan.yuan.boot_tools.groovy.RuleTaskService
import yuan.yuan.boot_tools.groovy.TestSo
import yuan.yuan.boot_tools.groovy.TestSoLine
import yuan.yuan.boot_tools.groovy.TestReturn

class RuleTaskTemplet implements RuleTaskService{

	@Override
	public String createTask(def bill) {
//		if(so instanceof TestSo) {
//			TestSo ts = so;
//			ts.setField1("TestSo")
//			ts.with {
//				if(field1 == "TestSo" || field2 == "2") {
//					"new";
//				}else {
//					"hang"
//				}
//			}
//		}else if(so instanceof TestSoLine) {
//			TestSoLine ts = so;
//			ts.setFieldLine1("TestSoLine")
//			ts.getFieldLine1();
//		}else {
//			println "IllegalArgumentException";
//			throw new IllegalArgumentException();
//		}
		
		switch(bill) {
			case TestSo:
				def status 
				((TestSo)bill).with {
					if(field1 == "TestSo" || field2.length() == 0) {
						for (line in lines) {
							line.with{
								if(fieldLine1 == "TestSo" || fieldLine2.length() ==  0) {
									status = OrderStatusEnum.NEW.getValue();
								}else {
									OrderStatusEnum.HANG.getValue();
								} 
							}
						}
						OrderStatusEnum.NEW;
						status
					}else {
						OrderStatusEnum.HANG;
					}
				}
				break
			case TestReturn:
				((TestReturn)bill).with {
					if(fieldA == "TestSo" || fieldB.length() ==  1) {
						OrderStatusEnum.NEW.getValue();
					}else {
						OrderStatusEnum.HANG.getValue();
					}
				}
				break
			default:
				println "IllegalArgumentException";
				break
		}
	}
}
