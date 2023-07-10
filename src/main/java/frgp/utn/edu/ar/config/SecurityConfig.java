package frgp.utn.edu.ar.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity(debug = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth
		.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
			.authorizeRequests()
			.antMatchers("/","/home","/registro").permitAll()
			.antMatchers("/clientes").hasAnyAuthority("ADMIN","USUARIO")
			.antMatchers("/usuarios").hasAnyAuthority("ADMIN")
			.antMatchers("/prestamos").hasAnyAuthority("CLIENTE","ADMIN")
			.and()
				.formLogin().loginPage("/home").loginProcessingUrl("/home").permitAll()
				.successForwardUrl("/loginSuccesful").permitAll()
				.and()
				.httpBasic()
				.and().logout().permitAll()
				.and().exceptionHandling().accessDeniedPage("/access-denied");
	}
	
}
