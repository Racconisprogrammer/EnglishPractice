package com.trustmeenglish.learnenglish.services;


import com.trustmeenglish.learnenglish.entity.Card;
import com.trustmeenglish.learnenglish.repositories.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CardService implements ICardService {

    private final CardRepository cardRepository;

    @Override
    public Card getCard(Long id) {
        return cardRepository.findById(id)
                .orElseThrow(()->new UsernameNotFoundException("User not found"));
    }

    @Override
    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }
}
