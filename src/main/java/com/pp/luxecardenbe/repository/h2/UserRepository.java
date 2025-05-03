package com.pp.luxecardenbe.repository.h2;

import com.pp.luxecardenbe.model.h2.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByEmail(String emailID);
}
