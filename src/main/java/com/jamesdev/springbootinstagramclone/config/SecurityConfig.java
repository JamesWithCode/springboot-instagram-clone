package com.jamesdev.springbootinstagramclone.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig  extends WebSecurityConfigurerAdapter {

      @Bean
      public BCryptPasswordEncoder bCryptPasswordEncoder(){return  new BCryptPasswordEncoder();}

      @Override
      protected void configure(HttpSecurity http) throws Exception {
            http
                        .csrf().disable();
            http
                        .authorizeRequests()
                        .antMatchers("/","/user/**","/image/**","/comment/**","/api/**").authenticated()
                        .anyRequest().permitAll();

            //TODO: form 로그인 방식 ->  jwt 로그인 방식
            http
                        .formLogin()
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/")
                        .failureUrl("/login");

      }
}
