package ru.education.bootlab.config;
import org.springframework.context.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
public class SecurityConfig {
 @Bean PasswordEncoder passwordEncoder() {return new BCryptPasswordEncoder();}
 /** Stateless JSON REST API: Basic authentication with no browser cookie session. */
 @Bean @Order(1) SecurityFilterChain api(HttpSecurity http) throws Exception {
  return http.securityMatcher("/api/**").authorizeHttpRequests(a->a.anyRequest().authenticated())
   .sessionManagement(s->s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
   .csrf(c->c.disable()).httpBasic(Customizer.withDefaults()).build();
 }
 /** Legacy REST exercises retain their public interface, independent of student forms. */
 @Bean @Order(2) SecurityFilterChain feedback(HttpSecurity http) throws Exception {
  return http.securityMatcher("/feedback","/hello","/update-array","/show-array","/update-map","/show-map","/show-all-lenght")
   .authorizeHttpRequests(a->a.anyRequest().permitAll()).csrf(c->c.disable()).build();
 }
 @Bean @Order(3) SecurityFilterChain browser(HttpSecurity http) throws Exception {
  return http.authorizeHttpRequests(a->a
    .requestMatchers("/","/index","/register","/register/save","/login","/style.css","/error","/actuator/health").permitAll()
    .anyRequest().authenticated())
   .formLogin(f->f.loginPage("/login").defaultSuccessUrl("/list",true).permitAll())
   .logout(l->l.logoutSuccessUrl("/login?logout")).build();
 }
}
