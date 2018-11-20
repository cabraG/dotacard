package cabra.dotacard.dao;


import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(locations= {"classpath*:application.properties"})
public class ReferencesMapperTest {

    @Autowired
    private ReferencesMapper ReferencesMapper;




}
