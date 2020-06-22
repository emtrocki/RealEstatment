package com.example.ss.ss.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;




@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return passwordEncoder;
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("/updatecontact").hasRole("ADMIN")
                .antMatchers("/deletecontact").hasRole("ADMIN")
                .antMatchers("/updateinfo").hasRole("ADMIN")
                .antMatchers("/deleteinfo").hasRole("ADMIN")
                .antMatchers("/addpayment").hasRole("ADMIN")
                .antMatchers("/modifypayment").hasRole("ADMIN")
                .antMatchers("/deletepayment").hasRole("ADMIN")
                .antMatchers("/notificationstoserve").hasRole("ADMIN")
                .antMatchers("/service").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()

        ;

    }


}