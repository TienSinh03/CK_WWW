/**
 * @ (#) SecurityConfig.java      12/18/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.backend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 12/18/2024
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        UserDetails user = User.withUsername("user") // create a user
                .password(encoder.encode("123")) // encode the password
                .roles("USER") // assign role
                .build();
        UserDetails admin = User.withUsername("admin") // create a user
                .password(encoder.encode("123")) // encode the password
                .roles("ADMIN") // assign role
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                auth -> auth
                        .requestMatchers("/css/**","js/**").permitAll()
                        .requestMatchers("/login").permitAll()
                        .requestMatchers("/index","/").permitAll()
                        .requestMatchers(HttpMethod.GET,"/api/**").permitAll()
                        .requestMatchers("/customers/**","/accounts/between_balance","/showReport1").hasRole("USER")
                        .requestMatchers("/report2/customers/by_year_dob").hasRole("ADMIN")
                        .requestMatchers("/login").permitAll()
        ).logout(logout -> logout
                .logoutUrl("/logout") // URL xử lý logout
                .logoutSuccessUrl("/index?logout") // URL chuyển hướng sau logout
                .invalidateHttpSession(true) // Hủy session hiện tại
                .clearAuthentication(true) // Xóa thông tin xác thực
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "POST")) // Chỉ hỗ trợ HTTP POST
                .permitAll() // Cho phép tất cả truy cập endpoint logout
        );


        http.httpBasic(Customizer.withDefaults());
        http.csrf(AbstractHttpConfigurer::disable);


        return http.build();
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
