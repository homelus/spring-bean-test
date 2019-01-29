import jun.config.JunBean;
import jun.config.MinBean;
import jun.config.SubBean;
import jun.config.aware.JunService;
import jun.config.beanProp.PropAppConfig;
import jun.config.beanProp.PropBean;
import jun.config.dependson.AppConfig;
import jun.config.dependson.BeanOne;
import jun.config.importConfig.EmptyConfig;
import jun.config.qualifier.QualifierAppConfig;
import org.junit.Test;
import jun.config.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanTest {

    @Test
    public void configBean() {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        JunBean junBean = context.getBean("junBean", JunBean.class);
        junBean.setCount(10);
        System.out.println(junBean.getCount());

    }

    @Test
    public void junServiceTest() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        JunService junService = context.getBean("junService", JunService.class);
        junService.helloJun();
    }

    @Test
    public void dependsOnTest() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        BeanOne bean = context.getBean(BeanOne.class);
        bean.doSomething();
        context.close();
    }

    @Test
    public void importConfigTest() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EmptyConfig.class);
        JunBean junBean = context.getBean("junBean", JunBean.class);
        MinBean minBean = context.getBean("minBean", MinBean.class);
        SubBean subBean = context.getBean("subBean", SubBean.class);

        junBean.doSomething();
        minBean.doSomething();
        subBean.doSomething();

    }

    @Test
    public void propertyBeanTest() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PropAppConfig.class);
        PropBean propBean = context.getBean("propBean", PropBean.class);
        propBean.doSomething();
        context.close();
    }

    @Test
    public void qualifierTest() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(QualifierAppConfig.class);
    }

    @Test
    public void xmlTest() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:import-config.xml");
        JunBean junBean = context.getBean("junBean", JunBean.class);
        junBean.doSomething();
    }

}
