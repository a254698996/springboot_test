package org.tarzan.springtest.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter {
	/**
	 * 配置拦截器
	 * 
	 * @author lance
	 * @param registry
	 */
	@Autowired
	AccessTokenVerifyInterceptor accessTokenVerifyInterceptor;

	public void addInterceptors(InterceptorRegistry registry) {
		// registry.addInterceptor(new
		// AccessTokenVerifyInterceptor()).addPathPatterns("/user/**");
		System.out.println(" AccessTokenVerifyInterceptor registry ...");
		registry.addInterceptor(accessTokenVerifyInterceptor).addPathPatterns("/**");
	}
}