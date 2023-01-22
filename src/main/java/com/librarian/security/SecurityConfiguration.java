package com.librarian.security;


import com.librarian.config.StaticFilesFilter;
import com.librarian.service.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final UserDetailsServiceImpl userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        final DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

//    @Bean
//    public SecurityFilterChain configure(final HttpSecurity http) throws Exception {
//        http.cors()
//                .disable()
//                .csrf()
//                .disable()
//                .authorizeHttpRequests()
//                .requestMatchers("/", "/api/user/register", "/register", "/static/**.js", "/static/**.css", "/*.png", "/*.ico", "/*.json", "*.tsx", "*.ts", "/table").permitAll() // allow CORS option calls for Swagger UI
////                .anyRequest()
////                .authenticated()
//                .and()
//                .formLogin()
//                .defaultSuccessUrl("/", true)
//                .and()
//                .logout()
//                .logoutUrl("/perform_logout")
//                .logoutSuccessUrl("/")
//                .invalidateHttpSession(true)
//                .deleteCookies("JSESSIONID")
//                .permitAll();
//
//        return http.build();
//    }

    @Bean
    public SecurityFilterChain configure(final HttpSecurity http) throws Exception {
        http.cors()
                .disable()
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/", "/register", "/api/user/register", "/static/**/*.js", "/static/**/*.css", "/*.png", "/*.ico", "/*.json")
                .permitAll()
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .defaultSuccessUrl("/", true)
                .and()
                .logout()
                .logoutUrl("/perform_logout")
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .permitAll();

        return http.build();
    }

}
