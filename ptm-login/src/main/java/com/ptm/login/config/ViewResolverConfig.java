package com.ptm.login.config;

//import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class ViewResolverConfig implements WebMvcConfigurer {
//	@Autowired private RequestInterceptor requestInterceptor;
	
	/*
	 * @Override public void addFormatters(FormatterRegistry registry) {
	 * registry.addFormatter(new GenderStringConverter()); }
	 */

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:application_en_US");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}

}
