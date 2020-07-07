package de.kreidler.sarah;

import de.kreidler.sarah.services.DataProcessorImpl;
import de.kreidler.sarah.services.interfaces.DataProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("BeansAutowire.xml");

		DataProcessor dataService = (DataProcessorImpl) context.getBean("dataProcessor");

		dataService.process();
	}
}