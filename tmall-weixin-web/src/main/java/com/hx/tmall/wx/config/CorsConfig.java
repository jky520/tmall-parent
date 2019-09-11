package com.hx.tmall.wx.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 跨域配置
 * @Create by jky1988@qq.com
 * @Version V1.0
 */
@Configuration
public class CorsConfig {

	@Bean
	public FilterRegistrationBean corsFilterRegistrationBean() {

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedHeader("*");
		config.addAllowedOrigin("*");
		config.addAllowedHeader("*");
		config.addAllowedHeader("Authorization");
		config.addAllowedHeader("Content-Type");
		config.addAllowedHeader("Accept");
		config.addAllowedMethod("POST");
		config.addAllowedMethod("GET");
		config.addAllowedMethod("DELETE");
		config.addAllowedMethod("PUT");
		config.addAllowedMethod("OPTIONS");
		config.setMaxAge(3600L);
		// source.registerCorsConfiguration("/oauth/token", config); // Add "/oauth/token" explicitly
		source.registerCorsConfiguration("/**", config); // Global for all paths

		FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}
}
