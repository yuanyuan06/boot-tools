import yuan.yuan.boot_tools.groovy.HelloWorld

class HelloWorldImpl implements HelloWorld{

	public String sayHello(String name){
		return "hello world" + name;
	}
}