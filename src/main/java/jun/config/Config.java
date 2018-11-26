package jun.config;

import jun.config.aware.JunService;
import jun.config.aware.JunServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public JunBean junBean() {
        return new JunBean();
    }

    @Bean
    public JunService junService() {
        return new JunServiceImpl();
    }

}
