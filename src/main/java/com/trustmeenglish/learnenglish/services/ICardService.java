package com.trustmeenglish.learnenglish.services;

import com.trustmeenglish.learnenglish.entity.Card;
import com.trustmeenglish.learnenglish.entity.User;

import java.util.List;

public interface ICardService {

    Card getCard(Long id);

    List<Card> getAllCards();

}
