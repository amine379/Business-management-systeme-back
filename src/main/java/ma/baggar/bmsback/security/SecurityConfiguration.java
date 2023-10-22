package ma.baggar.bmsback.security;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.AntPathMatcher;

import com.nimbusds.jose.jwk.source.ImmutableSecret;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration {
	/*
	@Value("${jwt.secret}")
	private String secretKey;
@Bean
public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
	PasswordEncoder passwordEncoder=passwordEncoder();
	return new InMemoryUserDetailsManager(
			User.withUsername("amine").password(passwordEncoder.encode("12345")).authorities("USER","ADMIN").build(),
			User.withUsername("badr").password(passwordEncoder.encode("12345")).authorities("USER").build()
			);
}
@Bean
public PasswordEncoder passwordEncoder() {
	return new BCryptPasswordEncoder();
}
@Bean 
public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
	return httpSecurity.
			sessionManagement(sm->sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) //l utiloisation de jwt 
			.csrf(csrf->csrf.disable()) //thr meaning of csrf
		
			//.authorizeHttpRequests(arr->arr.requestMatchers("api/auth/login/**").permitAll())
			//.authorizeHttpRequests(ar->ar.anyRequest().authenticated())
			.authorizeHttpRequests((requests) -> requests
		            .requestMatchers(new AntPathRequestMatcher("/api/auth/login/**")).permitAll()
		            .anyRequest().authenticated()) //other URLs are only allowed authenticated users
			//.httpBasic(Customizer.withDefaults())
			//.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt) 
			.oauth2ResourceServer(au->au.jwt(Customizer.withDefaults()))
			.build();
}
@Bean
JwtEncoder jwtEncoder() {
	return new NimbusJwtEncoder(new ImmutableSecret<>(secretKey.getBytes()));
}
@Bean
JwtDecoder jwtDecoder() {
	SecretKeySpec secretKeySpec=new SecretKeySpec(secretKey.getBytes(), "RSA");
return NimbusJwtDecoder.withSecretKey(secretKeySpec).macAlgorithm(MacAlgorithm.HS512).build();
}
//authenitification de user
@Bean
public AuthenticationManager authenticationManager(UserDetailsService userDetailsService) {
	DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
	authenticationProvider.setPasswordEncoder(passwordEncoder());
	authenticationProvider.setUserDetailsService(userDetailsService);
	return new ProviderManager(authenticationProvider);
}*/
}