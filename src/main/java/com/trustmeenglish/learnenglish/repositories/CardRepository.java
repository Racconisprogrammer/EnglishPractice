package com.trustmeenglish.learnenglish.repositories;

import com.trustmeenglish.learnenglish.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CardRepository extends JpaRepository<Card, Long> {
}
