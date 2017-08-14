package yuan.yuan.boot_tools.groovy;

import java.io.Serializable;

public class TestReturn implements Serializable {
	
	private static final long serialVersionUID = -7313093887302224991L;

	private String fieldA;
	
	private String fieldB;

	public String getFieldA() {
		return fieldA;
	}

	public void setFieldA(String fieldA) {
		this.fieldA = fieldA;
	}

	public String getFieldB() {
		return fieldB;
	}

	public void setFieldB(String fieldB) {
		this.fieldB = fieldB;
	}
}
