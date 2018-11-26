package jun.config.dependson;

import org.springframework.beans.factory.annotation.Autowired;

public class BeanOne {

    @Autowired
    private BeanTwo beanTwo;

    @Autowired
    private BeanThree beanThree;

    public BeanOne() {
        System.out.println("Bean One is Initialized");
    }

    public void doSomething() {
        System.out.println("Inside doSomething() method of BeanOne");
        beanTwo.doSomething();
        beanThree.doSomething();
    }
}
