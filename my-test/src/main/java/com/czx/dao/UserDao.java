package com.czx.dao;

import com.czx.com.czx.anno.Select;

/**
 * 模拟mybatis 通过实现ImportBeanDefinitionRegistrar接口完成
 * 1、生成代理对象
 * 2、把代理对象交给spring管理
 */
public interface UserDao {

    @Select("select * from t_user")
    void query();
}
