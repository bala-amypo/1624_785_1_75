// package com.example.demo.security;

// import org.springframework.security.core.userdetails.*;
// import org.springframework.stereotype.Service;

// @Service
// public class CustomUserDetailsService implements UserDetailsService {

//     @Override
//     public UserDetails loadUserByUsername(String username)
//             throws UsernameNotFoundException {

//         return User.builder()
//                 .username(username)
//                 .password("password")
//                 .roles("USER")
//                 .build();
//     }
// }





// // package com.example.demo.security;

// // import com.example.demo.model.User;
// // import com.example.demo.repository.UserRepository;
// // import org.springframework.security.core.GrantedAuthority;
// // import org.springframework.security.core.authority.SimpleGrantedAuthority;
// // import org.springframework.security.core.userdetails.UserDetails;
// // import org.springframework.security.core.userdetails.UserDetailsService;
// // import org.springframework.security.core.userdetails.UsernameNotFoundException;

// // import java.util.Collection;
// // import java.util.List;
// // import java.util.stream.Collectors;

// // /**
// //  * This class is kept minimal to avoid conflicts.
// //  * It is NOT used directly by Spring Security.
// //  */
// // public class CustomUserDetails {
// //     // intentionally empty
// // }

// // /**
// //  * NON-public service class (allowed in same file)
// //  */
// // class CustomUserDetailsService implements UserDetailsService {

// //     private final UserRepository userRepository;

// //     public CustomUserDetailsService(UserRepository userRepository) {
// //         this.userRepository = userRepository;
// //     }

// //     @Override
// //     public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

// //         User user = userRepository.findByEmail(email)
// //                 .orElseThrow(() ->
// //                         new UsernameNotFoundException("User not found: " + email));

// //         return new org.springframework.security.core.userdetails.User(
// //                 user.getEmail(),
// //                 user.getPassword(),
// //                 mapRolesToAuthorities(user.getRoles())
// //         );
// //     }

// //     private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<String> roles) {
// //     if (roles == null || roles.isEmpty()) {
// //         return List.of();
// //     }

// //     return roles.stream()
// //             .map(SimpleGrantedAuthority::new)
// //             .collect(Collectors.toList());
// // }
// // }

