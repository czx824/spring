package com.czx.test;

import com.czx.config.AppConfig;
import com.czx.dao.IndexDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext();
		app.register(AppConfig.class);
//		app.addBeanFactoryPostProcessor(new MyBeanFactoryPostProcessor());
//		app.addBeanFactoryPostProcessor(new MyBeanDefinitionRegistryPostProcessor());
		app.refresh();
		IndexDao indexDao = (IndexDao) app.getBean("indexDaoImpl");
		indexDao.query();
	}

}
