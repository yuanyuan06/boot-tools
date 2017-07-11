package yuan.yuan.boot_tools.javaScriptEngine;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.junit.Test;

public class TestJavaScript {

    @Test
    public void javaScriptEngine() throws ScriptException{
        ScriptEngine jse = new ScriptEngineManager().getEngineByName("JavaScript");
        String strs = "0.1+0.2";  
        System.out.println(jse.eval(strs));  
    }
}
