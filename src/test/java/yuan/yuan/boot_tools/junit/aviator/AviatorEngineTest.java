package yuan.yuan.boot_tools.junit.aviator;

import java.math.BigDecimal;

import org.junit.Test;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Options;

public class AviatorEngineTest {

    @Test
    public void testEcute(){
        // 浮点解析为 BigDecimal
        AviatorEvaluator.setOption(Options.ALWAYS_USE_DOUBLE_AS_DECIMAL, true);
        BigDecimal result = (BigDecimal) AviatorEvaluator.exec("0.1+0.2");
        System.out.println(result);
    }
}
