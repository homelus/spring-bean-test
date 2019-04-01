package jun.config;

import org.springframework.beans.factory.annotation.Autowired;

public class RootBean {

    @Autowired
    JunBean junBean;

    public void run() {
        junBean.doSomething();
    }

}
