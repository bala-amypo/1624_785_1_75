// package com.example.demo.security;

// import org.springframework.web.filter.OncePerRequestFilter;
// import javax.servlet.FilterChain;
// import javax.servlet.ServletException;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
// import java.io.IOException;

// public class JwtAuthenticationFilter extends OncePerRequestFilter {
    
//     @Override
//     protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) 
//             throws ServletException, IOException {
//         filterChain.doFilter(request, response);
//     }
// }




// // JwtAuthenticationFilter.java
// package com.example.demo.security;

// import java.io.IOException;
// import jakarta.servlet.FilterChain;
// import jakarta.servlet.ServletException;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;

// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.web.filter.OncePerRequestFilter;

// public class JwtAuthenticationFilter extends OncePerRequestFilter {
//     @Override
//     protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//             throws ServletException, IOException {
//         // your JWT validation code
//         filterChain.doFilter(request, response);
//     }
// }
