package com.trustmeenglish.learnenglish.repositories;

import com.trustmeenglish.learnenglish.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
