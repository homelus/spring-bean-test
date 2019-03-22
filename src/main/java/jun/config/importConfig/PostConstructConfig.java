package jun.config.importConfig;

import jun.config.JunBean;
import jun.config.service.PostBeanService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PostConstructConfig {

    @Bean
    public JunBean junBean() {
        return new JunBean();
    }

    @Bean
    public PostBeanService postBeanService() {
        return new PostBeanService();
    }


}
