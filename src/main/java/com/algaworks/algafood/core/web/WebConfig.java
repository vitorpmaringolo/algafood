package com.algaworks.algafood.core.web;

import javax.servlet.Filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.ShallowEtagHeaderFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	
//	@Autowired
//	private ApiRetirementHandler apiRetirementHandler;

//	@Override
//	public void addCorsMappings(CorsRegistry registry) {
//		registry.addMapping("/**").allowedMethods("*");
//	}
//	
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(apiRetirementHandler);
//	}

	@Bean
    Filter shallowEtagHeaderFilter() {
		return new ShallowEtagHeaderFilter();
	}
    
}
