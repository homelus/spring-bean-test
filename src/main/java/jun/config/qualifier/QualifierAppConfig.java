package jun.config.qualifier;

import jun.config.JunBean;
import jun.config.MinBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QualifierAppConfig {

    @Bean
    public JunBean getJunBean(@Qualifier("qMinBean") MinBean minBean) {
        minBean.doSomething();
        return new JunBean();
    }

    @Bean
    @Qualifier("qMinBean")
    public MinBean getMinBean() {
        return new MinBean();
    }

}
