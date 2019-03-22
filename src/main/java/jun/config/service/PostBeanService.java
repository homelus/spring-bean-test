package jun.config.service;

import jun.config.JunBean;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class PostBeanService {

    @Autowired
    private JunBean junBean;

    @PostConstruct
    public void init() {
        System.out.println("Service Post Construct Jun bean doSomething");
        junBean.doSomething();
    }

}
