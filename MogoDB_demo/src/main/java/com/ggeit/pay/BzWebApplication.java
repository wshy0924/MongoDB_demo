package com.ggeit.pay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import com.ggeit.pay.entity.DiseaseInfo;


@SpringBootApplication
public class BzWebApplication extends SpringBootServletInitializer{


	@Override
	//要使用tomcat来支持加载JSP必须继承SpringBootServletInitializer类并重写其中configure方法
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(BzWebApplication.class);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(BzWebApplication.class, args);
	}
	

}

