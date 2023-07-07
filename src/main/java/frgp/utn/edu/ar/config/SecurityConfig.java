package frgp.utn.edu.ar.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity(debug = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth
		.inMemoryAuthentication()
		.withUser("admin")
		.password("{bCrypt}$2a$10$ugsq7jbksaEL1xfgXxiQGunwIbcccN3s53rwttBdcxGFh6rkbQvJ.")
		.roles("admin");
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers("/registro.html").permitAll()
			.antMatchers("/home.html").permitAll()
			.antMatchers("/clientes").authenticated()
			.antMatchers("/prestamos").authenticated()
			.and()
				.formLogin()
				.and()
				.httpBasic();
	}
	
	
}
