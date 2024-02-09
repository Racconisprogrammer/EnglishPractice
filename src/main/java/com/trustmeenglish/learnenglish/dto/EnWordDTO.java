package com.trustmeenglish.learnenglish.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.trustmeenglish.learnenglish.entity.Card;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnWordDTO {
    private Long id;
    private String meaning;


}
