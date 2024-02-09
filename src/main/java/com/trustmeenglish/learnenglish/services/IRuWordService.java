package com.trustmeenglish.learnenglish.services;

import com.trustmeenglish.learnenglish.entity.RuWord;

import java.util.List;

public interface IRuWordService {

    RuWord getRuWord(Long id);

    List<RuWord> getRuWords();

}
