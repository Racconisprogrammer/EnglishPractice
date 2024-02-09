package com.trustmeenglish.learnenglish.services;


import com.trustmeenglish.learnenglish.entity.EnWord;
import com.trustmeenglish.learnenglish.entity.User;
import com.trustmeenglish.learnenglish.repositories.EnWordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class EnWordService implements IEnWordService {

    private final EnWordRepository enWordRepository;

    @Override
    public EnWord geEnWord(Long id) {
        return enWordRepository.findById(id)
                .orElseThrow(()->new UsernameNotFoundException("User not found"));
    }

    @Override
    public List<EnWord> getEnWords() {
        return enWordRepository.findAll();
    }
}
