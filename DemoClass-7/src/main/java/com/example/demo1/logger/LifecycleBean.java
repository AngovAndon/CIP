package com.example.demo1.logger;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class LifecycleBean implements InitializingBean, DisposableBean {

    @Override
    public void destroy() throws Exception {
        System.out.println("Bean is destroyed at " + System.currentTimeMillis());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Bean is created at " + System.currentTimeMillis());
    }
}
