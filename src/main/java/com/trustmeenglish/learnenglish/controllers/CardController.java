package com.trustmeenglish.learnenglish.controllers;


import com.trustmeenglish.learnenglish.dto.CardDTO;
import com.trustmeenglish.learnenglish.dto.EnWordDTO;
import com.trustmeenglish.learnenglish.dto.ImageDTO;
import com.trustmeenglish.learnenglish.dto.RuWordDTO;
import com.trustmeenglish.learnenglish.entity.Card;
import com.trustmeenglish.learnenglish.entity.EnWord;
import com.trustmeenglish.learnenglish.entity.Image;
import com.trustmeenglish.learnenglish.entity.RuWord;
import com.trustmeenglish.learnenglish.repositories.CardRepository;
import com.trustmeenglish.learnenglish.services.ICardService;
import com.trustmeenglish.learnenglish.services.IEnWordService;
import com.trustmeenglish.learnenglish.services.IRuWordService;
import com.trustmeenglish.learnenglish.services.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class CardController {
    private final ICardService cardService;
    private final IEnWordService enWordService;
    private final IRuWordService ruWordService;
    private final ImageService imageService;


    @GetMapping("cards/{id}")
    public CardDTO getCarById(@PathVariable Long id) {
        Card card = cardService.getCard(id);
        EnWord enWord = enWordService.geEnWord(card.getEnWord().getId());
        RuWord ruWord = ruWordService.getRuWord(card.getRuWord().getId());
        Image image1 = imageService.getImage(card.getImage().getId());
        return cardDTO(card, enWord, ruWord, image1);
    }

    private CardDTO cardDTO(Card card, EnWord enWord,
                            RuWord ruWord, Image image) {
        return CardDTO.builder()
                .id(card.getId())
                .rating(card.getRating())
                .enWord(enWordDTO(enWord))
                .ruWord(ruWordDTO(ruWord))
                .image(imageDTO(image))
                .build();
    }

    private EnWordDTO enWordDTO(EnWord enWord) {
        return EnWordDTO.builder()
                .id(enWord.getId())
                .meaning(enWord.getMeaning())
                .build();
    }
    private RuWordDTO ruWordDTO(RuWord ruWord) {
        return RuWordDTO.builder()
                .id(ruWord.getId())
                .meaning(ruWord.getMeaning())
                .build();
    }

    private ImageDTO imageDTO(Image image) {
        return ImageDTO.builder()
                .id(image.getId())
                .name(image.getName())
                .originalFilename(image.getOriginalFilename())
                .contentType(image.getContentType())
                .size(image.getSize())
                .bytes(image.getBytes())
                .build();
    }

}
