package com.yicuojin.football;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;

@MapperScan("com.yicuojin.football.mapper")
@SpringBootApplication
@ServletComponentScan
public class FootballApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(FootballApplication.class);
    }

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(FootballApplication.class, args);


    }
}
