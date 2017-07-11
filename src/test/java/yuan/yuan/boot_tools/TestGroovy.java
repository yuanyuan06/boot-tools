package yuan.yuan.boot_tools;

import java.io.IOException;

import org.junit.Test;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import groovy.util.GroovyScriptEngine;

public class TestGroovy {

    
    @Test
    public void testCalculate(){
        Binding binding = new Binding();
        binding.setVariable("x", 10);
        binding.setVariable("language", "groovy");
        
        GroovyShell shell = new GroovyShell(binding);
        Object value = shell.evaluate("println \"Welcome to $language\"; y = x * 2; z = x * 3; return z ");
        System.out.println(value);
    }
    
    @Test
    public void testEngine(){
        try {
            GroovyScriptEngine engine = new GroovyScriptEngine("");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    
}
