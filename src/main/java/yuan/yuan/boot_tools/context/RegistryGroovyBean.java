package yuan.yuan.boot_tools.context;

import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;

import groovy.lang.GroovyClassLoader;

public class RegistryGroovyBean implements ApplicationListener<ContextRefreshedEvent> {

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		ApplicationContext context = event.getApplicationContext();
		ConfigurableApplicationContext configurableApplicationContext = (ConfigurableApplicationContext)context;
		BeanDefinitionRegistry beanDefinitonRegistry = (BeanDefinitionRegistry) configurableApplicationContext.getBeanFactory();
		GroovyClassLoader loader= new GroovyClassLoader();
		 Class fileCreator =loader.parseClass("");
		 RootBeanDefinition bd = new RootBeanDefinition(fileCreator);
			BeanDefinitionHolder holder = new BeanDefinitionHolder(bd, "test", null);
		BeanDefinitionReaderUtils.registerBeanDefinition(holder, beanDefinitonRegistry);
	}

}
