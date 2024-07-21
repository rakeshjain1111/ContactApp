package com.rakesh.capp.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
@Configuration
//@EnableWebMvc
//@ComponentScan(basePackages = "com.rakesh.capp")
public class DispatcherConfig extends WebMvcConfigurerAdapter{
	
	@Bean
   public ViewResolver viewResolver() {
	   InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	   viewResolver.setViewClass(JstlView.class);
	   viewResolver.setPrefix("/WEB-INF/views/");
	   viewResolver.setSuffix(".jsp");
	   return viewResolver;
   }
   
	
	
   @Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	}
   
   @Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	   configurer.enable();
	}
}
