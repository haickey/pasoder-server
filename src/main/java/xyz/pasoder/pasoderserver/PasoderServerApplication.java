package xyz.pasoder.pasoderserver;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "xyz.pasoder.pasoderserver")
@MapperScan(basePackages = {"xyz.pasoder.pasoderserver.password.store.dao"})
public class PasoderServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PasoderServerApplication.class, args);
    }

}
