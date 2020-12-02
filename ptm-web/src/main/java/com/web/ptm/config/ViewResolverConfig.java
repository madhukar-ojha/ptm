package com.web.ptm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.web.ptm.converter.spring.GenderStringConverter;
import com.web.ptm.listener.RequestInterceptor;

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
