package cn.phr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.phr.dao")
public class SpringbootStart {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootStart.class,args);
    }
}
