package com.trustmeenglish.learnenglish.services;

import com.trustmeenglish.learnenglish.entity.EnWord;
import com.trustmeenglish.learnenglish.entity.User;

import java.util.List;
import java.util.Optional;

public interface IEnWordService {

    EnWord geEnWord(Long id);

    List<EnWord> getEnWords();

}
