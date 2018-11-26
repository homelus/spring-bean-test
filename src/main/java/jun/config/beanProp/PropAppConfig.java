package jun.config.beanProp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PropAppConfig {

    @Bean(name = "propBean", initMethod = "initProperty", destroyMethod = "destroyProperty")
    public PropBean getPropBean() {
        return new PropBean();
    }


}
