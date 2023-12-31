package com.Tienda.configuraciones;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	// Encriptacion
	@Bean
	PasswordEncoder passwordEnconder() {
		return new BCryptPasswordEncoder(12);
	}

	// AUTENTICACIÓN
		@Autowired
		public void configureGlobal(AuthenticationManagerBuilder auth, DataSource dataSource)
		  throws Exception {
		    auth.jdbcAuthentication().dataSource(dataSource)
		    	.usersByUsernameQuery("""
		    			SELECT email,password,1
		    			FROM usuarios
		    			WHERE email = ?
		    			""")  
		    	.authoritiesByUsernameQuery("""
		    			SELECT u.email, CONCAT('ROLE_', r.nombre) 
		    			FROM usuarios u
		    			JOIN roles r ON u.rol_id = r.id
		    			WHERE email = ?
		    			""");
		}

	// AUTORIZACIÓN
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((requests) -> requests.requestMatchers("/admin/**").hasRole("ADMIN")
				.requestMatchers("/detalle").authenticated().anyRequest().permitAll()
//				.requestMatchers("/", "/home").permitAll()
//				.anyRequest().authenticated()
		).exceptionHandling(handling -> handling.accessDeniedPage("/login?noautorizado"))
				.formLogin(form -> form.loginPage("/login").permitAll()).logout((logout) -> logout.permitAll());

		return http.build();
	}
}
