package applicationContext;

import jun.config.JunBean;
import org.junit.Test;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.validation.beanvalidation.BeanValidationPostProcessor;

import javax.annotation.PostConstruct;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertTrue;

public class BeanValidationPostProcessorTests {

    @Test
    public void testNotNullConstraint() {
        GenericApplicationContext ac = new GenericApplicationContext();
        ac.registerBeanDefinition("bvpp", new RootBeanDefinition(BeanValidationPostProcessor.class));
        ac.registerBeanDefinition("capp", new RootBeanDefinition(CommonAnnotationBeanPostProcessor.class));
        ac.registerBeanDefinition("bean", new RootBeanDefinition(NotNullConstraintedBean.class));

        try {
            ac.refresh();
            fail("Should have thrown BeanCreationException");
        }
        catch (BeanCreationException ex) {
            System.out.println(ex.getRootCause().getMessage());
            assertTrue(ex.getRootCause().getMessage().contains("junBean"));
            assertTrue(ex.getRootCause().getMessage().contains("invalid"));
        }
    }

    @Test
    public void testNotNullConstraintSatisfied() {
        GenericApplicationContext ac = new GenericApplicationContext();

        ac.registerBeanDefinition("bypp", new RootBeanDefinition(BeanValidationPostProcessor.class));
        ac.registerBeanDefinition("capp", new RootBeanDefinition(CommonAnnotationBeanPostProcessor.class));
        RootBeanDefinition bd = new RootBeanDefinition(NotNullConstraintedBean.class);
        bd.getPropertyValues().add("junBean", new JunBean());
        ac.registerBeanDefinition("bean", bd);
        ac.refresh();
    }

    public static class NotNullConstraintedBean {

        @NotNull
        private JunBean junBean;

        @Size(min = 2)
        private String stringValue;

        public JunBean getJunBean() {
            return junBean;
        }

        public void setJunBean(JunBean junBean) {
            this.junBean = junBean;
        }

        public String getStringValue() {
            return stringValue;
        }

        public void setStringValue(String stringValue) {
            this.stringValue = stringValue;
        }

        @PostConstruct
        public void init() {
            assertNotNull("Shouldn't be here after constraint checking", this.junBean);
        }
    }

}
