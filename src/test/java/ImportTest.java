import jun.config.JunBean;
import jun.config.RootBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ImportTest.Config.class)
public class ImportTest {
ju
    @Autowired
    RootBean rootBean;

    @Test
    public void IMPORT_CONFIGURATION_우선순위_및_주입_테스트() {
        rootBean.run();
    }


    @Configuration
    @Import(RootBean.class)
    @ImportResource("classpath:import-test.xml")
    public static class Config {}

}


