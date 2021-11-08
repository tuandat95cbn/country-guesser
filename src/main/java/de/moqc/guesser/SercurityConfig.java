package de.moqc.guesser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Configuration
public class SercurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailsService;
    
	@Autowired
	private BasicAuthenticationEndPoint basicAuthenticationEndPoint;
    
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	    auth
		    .userDetailsService(this.userDetailsService)
		    .passwordEncoder(new BCryptPasswordEncoder());
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http
		    .authorizeRequests()
		    .anyRequest().authenticated()
    
		    .and()
		    .httpBasic().authenticationEntryPoint(basicAuthenticationEndPoint)
		    .and()
		    .csrf().disable();
    
	}	
}
