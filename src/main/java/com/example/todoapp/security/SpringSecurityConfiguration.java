package com.example.todoapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * @author Weixin Liu
 */
@Configuration
public class SpringSecurityConfiguration {

    // LDAP or Database

    // In memory authentication
    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager() {

        Map<String, String> users = new HashMap<>();
        users.put("admin", "dummy");
        users.put("weixin","123456");
        List<UserDetails> list = new ArrayList<>();
        for(Map.Entry<String, String> entry : users.entrySet()) {
            String username = entry.getKey();
            String password = entry.getValue();
            list.add(createUser(username, password));

        }
        return new InMemoryUserDetailsManager(list);
    }

    private UserDetails createUser(String username, String password) {
        return User
                .builder()
                .passwordEncoder(input -> passwordEncoder().encode(input))
                .username(username)
                .password(password)
                .roles("USER", "ADMIN")
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }



    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(authentication -> authentication.anyRequest().authenticated()).formLogin(withDefaults());
        // Disable CSRF and FrameOptions for H2 console
        http.csrf(csrf -> csrf.disable());
        http.headers().frameOptions().disable(); // H2 console (if any
        return http.build();
    }

}
