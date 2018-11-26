package jun.config.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;


public class JunServiceImpl implements JunService, BeanNameAware, ApplicationContextAware {

    @PostConstruct
    public void loadBean() {
        System.out.println("Load Bean!");
    }

    public void helloJun() {
        System.out.println("Hello Jun!");
    }

    public void setBeanName(String name) {
        System.out.println("Bean Name: " + name);
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ApplicationContext: " + applicationContext.toString());

        String className = applicationContext.getBean("junService").getClass().getName();
        System.out.println("Class Name: " + className);
    }

}
