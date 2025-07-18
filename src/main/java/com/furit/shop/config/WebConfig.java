package com.furit.shop.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	@Value("${file.view.path}") 
	private String fileViewPath;
	
	@Autowired
	private AuthInterceptor authInterceptor;
	
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/files/**")
		.addResourceLocations(fileViewPath);
	}
	
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(authInterceptor)
						.addPathPatterns("/**")
						.excludePathPatterns("/","/views/user/login",
								"/views/user/join","/css/**","/img/**","/js/**","/lib/**","/scss/**"
								,"/users/join", "/users/login","/files/**");
	}
	
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/files/**")
		.allowedOrigins("http://localhost:3000")
		.allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
		.allowedHeaders("*")
		.allowCredentials(true);
	}
	
}
