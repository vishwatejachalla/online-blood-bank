package com.cognizant.authenticationservice.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.cognizant.authenticationservice.AuthenticationServiceApplication;




@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationServiceApplication.class);

	@Autowired
	AppUserDetailsService appUserDetailsService;

	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// auth.userDetailsService(inMemoryUserDetailsManager());
		auth.userDetailsService(appUserDetailsService).passwordEncoder(passwordEncoder());

		// auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder().
		// encode("pwd")).roles("ADMIN").and()
		// .withUser("user").password(passwordEncoder().encode("pwd")).roles("USER");

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		LOGGER.info("Start of password encoding");
		return new BCryptPasswordEncoder();
	}

	/*
	 * @SuppressWarnings("rawtypes")
	 * 
	 * @Override protected void configure(HttpSecurity httpSecurity) throws
	 * Exception {
	 * 
	 * httpSecurity.cors();
	 * httpSecurity.csrf().disable().httpBasic().and().authorizeRequests().
	 * antMatchers("/users").permitAll().anyRequest();
	 * httpSecurity.csrf().disable().httpBasic().and().authorizeRequests().
	 * antMatchers("/menu-items").permitAll()
	 * .anyRequest().authenticated().and().addFilter(new
	 * JwtAuthorizationFilter(authenticationManager()));
	 * 
	 * 
	 * httpSecurity.csrf().disable().httpBasic().and().authorizeRequests().
	 * antMatchers("/authenticate")
	 * .permitAll().anyRequest().authenticated().and() .addFilter(new
	 * //hasAnyRole("USER","ADMIN")
	 * JwtAuthorizationFilter(authenticationManager()));
	 * 
	 * 
	 * }
	 */
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.cors();
		httpSecurity.csrf().disable().httpBasic().and().authorizeRequests().antMatchers("/menu-items").permitAll()
				.antMatchers("/users").permitAll()
				// .anyRequest().authenticated();

				// httpSecurity.csrf().disable().httpBasic().and()
				// .authorizeRequests()
				.antMatchers("/authenticate").hasAnyRole("USER", "ADMIN")
				.antMatchers("/requirement").permitAll()
				.antMatchers("/hospitals/**").permitAll()
				.antMatchers("/feedback").permitAll()
				.antMatchers("/states").permitAll()
				.antMatchers("/areas/**").permitAll()
				.antMatchers("/pincodes/**").permitAll()
				.antMatchers("/**").permitAll()
				.antMatchers("/slot").permitAll()
				.antMatchers("/hospitalid/**/**").permitAll()
				.antMatchers("/**").permitAll()

				.anyRequest().authenticated().and().addFilter(new JwtAuthorizationFilter(authenticationManager()));

		/*
		 * httpSecurity.csrf().disable().httpBasic().and() .addFilter(new
		 * JwtAuthorizationFilter(authenti`cationManager()));
		 */

	}

	/*
	 * @Bean public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
	 * LOGGER.info("Start of inMemoryUserDetailsManager");
	 * 
	 * List<UserDetails> uDetailsList = new ArrayList<>();
	 * 
	 * uDetailsList.add(User.withUsername("user").password(passwordEncoder().
	 * encode("pwd")).roles("USER").build());
	 * 
	 * uDetailsList
	 * .add(User.withUsername("admin").password(passwordEncoder().encode("pwd"))
	 * .roles("ADMIN").build());
	 * 
	 * LOGGER.info("End of inMemoryUserDetailsManager");
	 * 
	 * return new InMemoryUserDetailsManager(uDetailsList);
	 * 
	 * }
	 */

}
