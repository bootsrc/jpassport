package com.appjishu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author liushaoming
 */
@SpringBootApplication
@MapperScan({"com.appjishu.passport.dao", "com.appjishu.web.biz.dao"})
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
