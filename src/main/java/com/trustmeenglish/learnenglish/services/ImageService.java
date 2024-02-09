package com.trustmeenglish.learnenglish.services;


import com.trustmeenglish.learnenglish.entity.Card;
import com.trustmeenglish.learnenglish.entity.Image;
import com.trustmeenglish.learnenglish.repositories.CardRepository;
import com.trustmeenglish.learnenglish.repositories.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ImageService {

    private final ImageRepository imageRepository;

    public Image getImage(Long id) {
        return imageRepository.findById(id)
                .orElseThrow(()->new UsernameNotFoundException("User not found"));
    }


    public Image saveImage(Image image) {
        return imageRepository.save(image);
    }
}
