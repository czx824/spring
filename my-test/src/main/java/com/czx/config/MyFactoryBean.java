package com.czx.config;

import com.czx.anno.Select;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@SuppressWarnings("rawtypes")
public class MyFactoryBean implements FactoryBean, InvocationHandler {

    private Class clazz;

    public MyFactoryBean(Class clazz) {
        this.clazz = clazz;
    }

    @Override
    public Object getObject() throws Exception {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{clazz}, this);
    }

    @Override
    public Class getObjectType() {
        return clazz;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Method methodInf = proxy.getClass().getInterfaces()[0].getMethod(method.getName(), method.getParameterTypes());
        Select select = methodInf.getDeclaredAnnotation(Select.class);
        System.out.println(select.value());
        return null;
    }
}
