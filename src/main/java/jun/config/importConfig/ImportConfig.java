package jun.config.importConfig;

import jun.config.JunBean;
import jun.config.MinBean;
import jun.config.SubBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:import-config.xml")
public class ImportConfig {

    @Autowired
    private SubBean subBean;

    @Bean(name = "minBean")
    public MinBean getMinBean() {
        subBean.doAutoWired();
        return new MinBean();
    }



}
