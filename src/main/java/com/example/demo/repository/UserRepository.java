// package com.example.demo.repository;
// import org.springframework.data.jpa.repository.JpaRepository;
// import com.example.demo.model.User;
// public interface UserRepository extends JpaRepository<User, Long> {
//       User findByEmail(String email);
// }

package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
