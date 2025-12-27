// package com.example.demo.config;

// import com.example.demo.repository.UserRepository;
// import lombok.RequiredArgsConstructor;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.authentication.AuthenticationProvider;
// import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.security.crypto.password.PasswordEncoder;

// @Configuration
// @RequiredArgsConstructor
// public class ApplicationConfig {

//     private final UserRepository repository;
//     private final PasswordEncoder passwordEncoder;

//     @Bean
//     public UserDetailsService userDetailsService() {
//         // This looks up the user in your DB by email
//         return username -> repository.findByEmail(username)
//                 .orElseThrow(() -> new UsernameNotFoundException("User not found"));
//     }

//     @Bean
//     public AuthenticationProvider authenticationProvider() {
//         DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//         authProvider.setUserDetailsService(userDetailsService());
//         authProvider.setPasswordEncoder(passwordEncoder);
//         return authProvider;
//     }
// }
package com.example.demo.config;

// import com.example.demo.security.JwtAuthenticationFilter;
// import com.example.demo.security.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    // // private final JwtAuthenticationFilter jwtAuthenticationFilter;
    // private final CustomUserDetailsService customUserDetailsService;

    // public SecurityConfig(
    //                       CustomUserDetailsService customUserDetailsService) {
    //     this.customUserDetailsService = customUserDetailsService;
    // }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Needed if you authenticate using AuthenticationManager (e.g. in login controller)
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // Disable CSRF for stateless JWT
            .csrf(csrf -> csrf.disable())

            // Use stateless session (JWT)
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

            // Authorization rules
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                        "/api/auth/**",      // login/register endpoints
                        "/v3/api-docs/**",   // Swagger/OpenAPI if you use it
                        "/swagger-ui/**",
                        "/swagger-ui.html"
                ).permitAll()
                .anyRequest().authenticated()
            );

            // Custom user details service
            // .userDetailsService(customUserDetailsService)

            // Add JWT filter before UsernamePasswordAuthenticationFilter
            // .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}