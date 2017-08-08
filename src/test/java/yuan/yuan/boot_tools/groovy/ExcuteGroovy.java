package yuan.yuan.boot_tools.groovy;

import java.io.IOException;

import org.codehaus.groovy.control.CompilationFailedException;
import org.junit.Test;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import groovy.lang.GroovyClassLoader;

public class ExcuteGroovy {

	@SuppressWarnings({ "unused", "resource", "rawtypes" })
	@Test
	public void tete() throws CompilationFailedException, IOException, InstantiationException, IllegalAccessException {
		ClassLoader parent = ClassLoader.getSystemClassLoader();
		GroovyClassLoader loader = new GroovyClassLoader(parent);
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		Resource resource = resolver.getResource("classpath:HelloWorld.groovy");
		System.out.println(resource.exists());
//		Resource[] resources = resolver.getResources("classpath*:HelloWorld.groovy");
//		Class parseClass = loader.parseClass(resources[0].getFile());
		Class parseClass = loader.parseClass(resource.getFile());
		HelloWorld hello = (HelloWorld) parseClass.newInstance();
		String sayHello = hello.sayHello("yuan.yuan");
		System.out.println(sayHello);
	}
}
