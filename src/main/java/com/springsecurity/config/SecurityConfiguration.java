package com.springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.context.annotation.Configuration;

import com.springsecurity.handlers.RESTAuthenticationEntryPoint;
import com.springsecurity.handlers.RESTAuthenticationFailureHandler;
import com.springsecurity.handlers.RESTAuthenticationSuccessHandler;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	RESTAuthenticationEntryPoint authenticationEntryPoint;
	@Autowired
	RESTAuthenticationSuccessHandler authenticationSuccessHandler;
	@Autowired
	RESTAuthenticationFailureHandler authenticationFailureHandler;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
					.withUser("test").password("test").roles("ADMIN").and()
					.withUser("test1").password("test2").roles("USER");
	}
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
					.authorizeRequests()
					//.anyRequest()
					.antMatchers("/rest/**")
					//.permitAll();
					.fullyAuthenticated().and().httpBasic();
		httpSecurity.csrf().disable();
		//httpSecurity.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint);
		//httpSecurity.formLogin().successHandler(authenticationSuccessHandler);
		//httpSecurity.formLogin().failureHandler(authenticationFailureHandler);
		//httpSecurity.logout().logoutSuccessUrl("/");
	}
	
}
