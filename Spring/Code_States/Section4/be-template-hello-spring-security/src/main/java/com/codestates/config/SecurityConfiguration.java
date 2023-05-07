package com.codestates.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
    // (1)
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // HttpSecurity를 통해 HTTP 요청에 대한 보안 설정을 구성한다.
        http
                .csrf().disable()
                .formLogin()
                .loginPage("/auths/login-form")
                .loginProcessingUrl("/process_login")
                .failureUrl("/auths/login-form?error")
//                .and()
//                .authorizeHttpRequests()
//                .anyRequest()
//                .permitAll();
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .and()
                .exceptionHandling().accessDeniedPage("/auths/access-denied")
                .and()
                .authorizeHttpRequests(authorize -> authorize
                        .antMatchers("/orders/**").hasRole("ADMIN")
                        .antMatchers("/members/my-page").hasRole("USER")
                        .antMatchers("/**").permitAll()
                );
        return http.build();
    }

    @Bean
    public UserDetailsManager userDetailsService() {
        // (1)
        UserDetails userDetails = User.withDefaultPasswordEncoder()  // (1-1)
                .username("kevin@gmail.com")                         // (1-2)
                .password("1111")                                    // (1-3)
                .roles("USER")                                       // (1-4)
                .build();

        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin@gmail.com")
                .password("2222")
                .roles("ADMIN")
                .build();

        // (2)
        return new InMemoryUserDetailsManager(userDetails, admin);
    }
}
