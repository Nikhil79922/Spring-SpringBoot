package org.example;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component("NikkssyBeans")
public class UserService implements BeanNameAware , ApplicationContextAware {
    public UserService() {
        System.out.println("UserService created ");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("setBeanName " + name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("setApplicationContext " + applicationContext.getClass().getName());
    }
}
