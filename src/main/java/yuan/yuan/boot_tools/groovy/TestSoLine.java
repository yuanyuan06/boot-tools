package yuan.yuan.boot_tools.groovy;

import java.io.Serializable;

public class TestSoLine implements Serializable {
	
	private static final long serialVersionUID = 7357387563769782907L;

	private String fieldLine1;
	
	private String fieldLine2;

	public String getFieldLine1() {
		return fieldLine1;
	}

	public void setFieldLine1(String fieldLine1) {
		this.fieldLine1 = fieldLine1;
	}

	public String getFieldLine2() {
		return fieldLine2;
	}

	public void setFieldLine2(String fieldLine2) {
		this.fieldLine2 = fieldLine2;
	}
}
