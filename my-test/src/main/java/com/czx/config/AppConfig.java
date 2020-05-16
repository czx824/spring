package com.czx.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.czx")
@Import(MyImportBeanDefinitionRegistrar.class)
public class AppConfig {
}
