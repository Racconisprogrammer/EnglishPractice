package com.trustmeenglish.learnenglish.repositories;


import com.trustmeenglish.learnenglish.entity.EnWord;
import com.trustmeenglish.learnenglish.entity.RuWord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RuWordRepository extends JpaRepository<RuWord, Long> {


}
