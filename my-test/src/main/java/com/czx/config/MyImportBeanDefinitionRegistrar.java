package com.czx.config;

import com.czx.dao.UserDao;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(UserDao.class);
        GenericBeanDefinition beanDefinition = (GenericBeanDefinition) beanDefinitionBuilder.getBeanDefinition();
        //因为FactoryBean需要一个接口去进行代理
        beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(beanDefinition.getBeanClassName());
        //因为注册的bd是个接口，没有子类实现，所以getBean()的时候new不出来，
        // 这里设置BeanClass为FactoryBean时，getBean()的时候就直接获取FactoryBean里面getObject()返回的对象了
        beanDefinition.setBeanClass(MyFactoryBean.class);
        registry.registerBeanDefinition("userDao", beanDefinition);
    }

}
