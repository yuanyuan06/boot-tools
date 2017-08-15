package yuan.yuan.boot_tools.junit.groovyEngine;

import java.io.File;
import java.io.IOException;

import org.codehaus.groovy.control.CompilerConfiguration;
import org.junit.Test;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.scripting.ScriptSource;
import org.springframework.scripting.support.ResourceScriptSource;

import groovy.lang.Binding;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyShell;
import groovy.util.GroovyScriptEngine;
import groovy.util.ResourceException;
import groovy.util.ScriptException;
import yuan.yuan.boot_tools.groovy.RuleRoleService;

public class TestGroovy {

    
    @Test
    public void testCalculate(){
        Binding binding = new Binding();
        binding.setVariable("x", 10);
        binding.setVariable("language", "groovy");
        
        GroovyShell shell = new GroovyShell(binding);
        Object value = shell.evaluate("println \"Welcome to $language\"; y = x * 2; z = x * 3; return z ");
        System.out.println(value);
        Object value1 = shell.evaluate("z = 0.1+0.2 ; return z ");
        System.out.println(value1);
    }
    
    
    
    @Test
    public void testEngine() throws IOException, ResourceException, ScriptException{
        @SuppressWarnings("unused")
        GroovyScriptEngine engine = new GroovyScriptEngine("groovy");
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		Resource resource = resolver.getResource("classpath:groovyScripts/RoleRuleTemplet.groovy");
		
		CompilerConfiguration config = new CompilerConfiguration();
		config.setClasspath(".;‪D:\\maven\\repository\\org\\codehaus\\groovy\\groovy-all\\2.4.11\\groovy-all-2.4.11.jar;");
		engine.setConfig(config);
		ScriptSource source = new ResourceScriptSource(resource);
		String scriptAsString = source.getScriptAsString();
		System.out.println(scriptAsString);
    }
    
    @Test
    public void testGroovyObject() throws IOException, InstantiationException, IllegalAccessException {
    	
    	PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		Resource resource = resolver.getResource("classpath:groovyScripts/RuleRoleTemplet.groovy");
    	 GroovyClassLoader loader= new GroovyClassLoader();
    	  
         while(true){
        	 long lastModified = resource.lastModified();
        	 System.out.println(lastModified);
        	 ScriptSource source = new ResourceScriptSource(resource);
        	 String scriptAsString = source.getScriptAsString();
        	 Class fileCreator =loader.parseClass(scriptAsString);
        	 RuleRoleService rule = (RuleRoleService) fileCreator.newInstance();
        	 String findTaskByIncident = rule.findTaskByIncident("事件1");
        	 System.out.println(findTaskByIncident);
         }
     
    	
    }
    
    
}
