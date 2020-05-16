package com.czx.config;

import com.czx.com.czx.anno.Select;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

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
    public Class<?> getObjectType() {
        return clazz;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Class[] clazzs = new Class[args.length];
        for (int i = 0; i < args.length; i++) {
            clazzs[i] = args[i].getClass();
        }
        Method methodInf = proxy.getClass().getInterfaces()[0].getMethod(method.getName(), clazzs);
        Select select = methodInf.getDeclaredAnnotation(Select.class);
        System.out.println(select.value());
        return null;
    }
}
