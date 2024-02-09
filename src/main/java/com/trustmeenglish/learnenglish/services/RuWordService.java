package com.trustmeenglish.learnenglish.services;


import com.trustmeenglish.learnenglish.entity.RuWord;
import com.trustmeenglish.learnenglish.repositories.RuWordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class RuWordService implements IRuWordService {

    private final RuWordRepository ruWordRepository;

    @Override
    public RuWord getRuWord(Long id) {
        return ruWordRepository.findById(id)
                .orElseThrow(()->new UsernameNotFoundException("User not found"));
    }

    @Override
    public List<RuWord> getRuWords() {
        return ruWordRepository.findAll();
    }
}
