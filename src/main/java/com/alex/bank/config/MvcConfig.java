package com.alex.bank.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by Shishkov A.V. on 16.05.18.
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {
	/*@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/accounts").setViewName("accounts");
		registry.addViewController("/greeting").setViewName("greeting");
	}*/
}
