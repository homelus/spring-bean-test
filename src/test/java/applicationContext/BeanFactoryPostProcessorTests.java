package applicationContext;

import jun.config.JunBean;
import jun.config.MinBean;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.support.StaticApplicationContext;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BeanFactoryPostProcessorTests {

    @Test
    public void testRegisteredBeanFactoryPostProcessor() {
        StaticApplicationContext ac = new StaticApplicationContext();
        ac.registerSingleton("junBean", JunBean.class);
        ac.registerSingleton("minBean", MinBean.class);
        TestBeanFactoryPostProcessor bfpp = new TestBeanFactoryPostProcessor();
        ac.addBeanFactoryPostProcessor(bfpp);
        assertFalse(bfpp.wasCalled);
        System.out.println("before refresh");
        ac.refresh();
        assertTrue(bfpp.wasCalled);
    }


    public static class TestBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

        public boolean wasCalled = false;

        public String initValue;

        public void setInitValue(String initValue) {
            this.initValue = initValue;
        }

        public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

            for (String beanName : beanFactory.getBeanDefinitionNames()) {
                BeanDefinition bd = beanFactory.getBeanDefinition(beanName);
                System.out.println(bd.getBeanClassName() + " is called by Bean Factory Post Processor.");
            }

            wasCalled = true;

        }
    }

}
