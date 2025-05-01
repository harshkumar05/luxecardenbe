package com.pp.luxecardenbe.repository.h2;

import com.pp.luxecardenbe.model.h2.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
