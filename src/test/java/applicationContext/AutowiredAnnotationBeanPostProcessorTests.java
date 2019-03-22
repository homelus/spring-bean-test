package applicationContext;

import jun.config.JunBean;
import org.junit.Test;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

public class AutowiredAnnotationBeanPostProcessorTests {

    @Test
    public void testIncompleteBeanDefinition() {
        DefaultListableBeanFactory bf = new DefaultListableBeanFactory();
        AutowiredAnnotationBeanPostProcessor bpp = new AutowiredAnnotationBeanPostProcessor();

        bpp.setBeanFactory(bf);
        bf.addBeanPostProcessor(bpp);
        bf.registerBeanDefinition("testBean", new GenericBeanDefinition());
        try {
            bf.getBean("testBean");
        } catch (BeanCreationException ex) {
            System.out.println(ex.getRootCause().getMessage());
            assertTrue(ex.getRootCause() instanceof IllegalStateException);
        }
    }

    @Test
    public void testResourceInjection() {
        DefaultListableBeanFactory bf = new DefaultListableBeanFactory();
        AutowiredAnnotationBeanPostProcessor bpp = new AutowiredAnnotationBeanPostProcessor();
        bpp.setBeanFactory(bf);
        bf.addBeanPostProcessor(bpp);

        RootBeanDefinition bd = new RootBeanDefinition(ResourceInjectionBean.class);
        bd.setScope(RootBeanDefinition.SCOPE_PROTOTYPE);
        bf.registerBeanDefinition("annotatedBean", bd);

        JunBean junBean = new JunBean();
        bf.registerSingleton("junBean", junBean);

        ResourceInjectionBean bean = bf.getBean("annotatedBean", ResourceInjectionBean.class);
        assertSame(junBean, bean.getJunBean());
        assertSame(junBean, bean.getJunBean2());

        bean = bf.getBean("annotatedBean", ResourceInjectionBean.class);
        assertSame(junBean, bean.getJunBean());
        assertSame(junBean, bean.getJunBean2());

    }

    public static class ResourceInjectionBean {
        @Autowired(required = false)
        private JunBean junBean;

        private JunBean junBean2;

        @Autowired
        public void setJunBean2(JunBean junBean2) {
            if (this.junBean2 != null) {
                throw new IllegalStateException("Alreay called");
            }
            this.junBean2 = junBean2;
        }

        public JunBean getJunBean() {
            return junBean;
        }

        public JunBean getJunBean2() {
            return junBean2;
        }
    }

}
