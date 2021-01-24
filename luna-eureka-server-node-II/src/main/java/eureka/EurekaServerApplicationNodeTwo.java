package eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author luna@mac
 * @className EurekaServerApplication.java
 * @description TODO
 * @dateTime 2021年01月22日 18:20:00
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableEurekaServer
public class EurekaServerApplicationNodeTwo {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplicationNodeTwo.class, args);
    }

}
