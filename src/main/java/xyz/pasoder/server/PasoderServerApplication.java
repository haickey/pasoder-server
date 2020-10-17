package xyz.pasoder.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "xyz.pasoder.server")
@MapperScan(basePackages = {"xyz.pasoder.server.password.store.dao"})
public class PasoderServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PasoderServerApplication.class, args);
    }

}
