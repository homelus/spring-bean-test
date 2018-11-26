package jun.config.importConfig;

import jun.config.JunBean;
import jun.config.MinBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(ImportConfig.class)
public class EmptyConfig {

    @Bean(name = "junBean")
    public JunBean getJunBean() {
        return new JunBean();
    }

}
