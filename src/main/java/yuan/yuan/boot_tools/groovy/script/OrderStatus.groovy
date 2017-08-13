package yuan.yuan.boot_tools.groovy.script

/**
 * 单据状态:
 * 新建1
 * 挂起2
 * 人工处理3
 * 已提交4
 * 库房准备中5
 * 在途6
 * 完成7
 * 作废8
 * 取消9
 * @author oo
 *
 */
enum OrderStatus {

	NEW(1),
	HANG(2),
	MANUAL(3),
	COMMIT(4),
	PREPARE(5),
	DELIVERY(6),
	FINISH(7),
	DEL(8),
	CANCEl(9)
	
	private Integer value;
	
	OrderStatus(status){
		this.value = status;
	}
    private Code(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}

