//package com.res.repository;
//
//import java.util.Optional;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import com.res.entity.User;
//
//public interface UserRepository extends JpaRepository<User, Long> {
//    Optional<User> findByUsername(String username);  // for login
//    Optional<User> findByEmail(String email);
//}
package com.res.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.res.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);

}
