package com.trustmeenglish.learnenglish.controllers;

import com.trustmeenglish.learnenglish.dto.EnWordDTO;
import com.trustmeenglish.learnenglish.entity.EnWord;
import com.trustmeenglish.learnenglish.repositories.EnWordRepository;
import com.trustmeenglish.learnenglish.services.IEnWordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EnWordController {

    private final IEnWordService enWordService;

    @GetMapping("/en-word/{id}")
    public EnWordDTO sayHello(@PathVariable Long id) {
        EnWord enWord = enWordService.geEnWord(id);
        return enWordDTO(enWord);
    }

    private EnWordDTO enWordDTO(EnWord enWord) {
        return EnWordDTO.builder()
                .id(enWord.getId())
                .meaning(enWord.getMeaning())
                .build();
    }
}
