package yuan.yuan.boot_tools.groovy;

import java.io.Serializable;
import java.util.List;

public class TestSo implements Serializable {
	
	private static final long serialVersionUID = 3129897106734342981L;

	private String field1;
	
	private String field2;
	
	private List<TestSoLine> lines;

	public String getField1() {
		return field1;
	}

	public void setField1(String field1) {
		this.field1 = field1;
	}

	public String getField2() {
		return field2;
	}

	public void setField2(String field2) {
		this.field2 = field2;
	}

	public List<TestSoLine> getLines() {
		return lines;
	}

	public void setLines(List<TestSoLine> lines) {
		this.lines = lines;
	}
}
