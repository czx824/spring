package com.czx.config;

import com.czx.dao.impl.IndexDaoImpl2;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{IndexDaoImpl2.class.getName()};
    }

}
