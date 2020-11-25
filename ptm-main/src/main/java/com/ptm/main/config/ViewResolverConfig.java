package com.ptm.main.config;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ptm.main.converter.spring.GenderStringConverter;
import com.ptm.main.listener.RequestInterceptor;

@Component
public class ViewResolverConfig implements WebMvcConfigurer {
	@Autowired private RequestInterceptor requestInterceptor;
	
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/images/**").addResourceLocations("classpath:/static/images/");
		registry.addResourceHandler("/styles/css/**").addResourceLocations("classpath:/static/styles/css/");
		registry.addResourceHandler("/styles/js/**").addResourceLocations("classpath:/static/styles/js/");

	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(requestInterceptor).addPathPatterns("/**").excludePathPatterns("/", "/login",
				"/logout", "/styles/**", "/images/**", "/public/**");
	}

	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addFormatter(new GenderStringConverter());
	}

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:spring/application_en_US");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}

}
