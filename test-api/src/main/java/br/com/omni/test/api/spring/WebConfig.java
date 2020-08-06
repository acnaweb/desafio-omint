package br.com.omni.test.api.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		final String[] headers = new String[] { "Authorization", "Access-Control-Allow-Origin",
				"Access-Control-Allow-Headers", "Origin", "Accept", "X-Requested-With", "Content-Type",
				"Access-Control-Request-Method", "Access-Control-Request-Headers" };

		CorsRegistration cors = registry.addMapping("/**");
		cors.allowedHeaders(headers);
		cors.allowedOrigins("*");
		cors.allowCredentials(true);
		cors.allowedMethods("GET", "HEAD", "OPTIONS", "POST", "PUT", "DELETE");
		cors.maxAge(3600);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html")
				.addResourceLocations("classpath:/META-INF/resources/swagger-ui.html");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");

		WebMvcConfigurer.super.addResourceHandlers(registry);
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {

	}

}
