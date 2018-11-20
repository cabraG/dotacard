package cabra.dotacard;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cabra.dotacard.dao")
public class DotacardApplication {

    public static void main(String[] args) {
        SpringApplication.run(DotacardApplication.class, args);
    }
}
