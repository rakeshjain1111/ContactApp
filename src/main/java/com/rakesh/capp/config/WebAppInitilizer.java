package com.rakesh.capp.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitilizer  implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
		applicationContext.setServletContext(servletContext);
		applicationContext.register(DispatcherConfig.class);
		DispatcherServlet ds =new DispatcherServlet(applicationContext)	;	
		ServletRegistration.Dynamic servlet = servletContext.addServlet("front-controller", ds);
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
		}
}
