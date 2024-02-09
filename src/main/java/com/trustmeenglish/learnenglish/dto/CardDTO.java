package com.trustmeenglish.learnenglish.dto;

import com.trustmeenglish.learnenglish.entity.Image;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardDTO {
    private Long id;
    private Long rating;
    private EnWordDTO enWord;
    private RuWordDTO ruWord;
    private ImageDTO image;

}
