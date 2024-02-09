package com.trustmeenglish.learnenglish.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"meaning"})
@Table(name = "en_words")
public class EnWord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String meaning;
    @OneToMany(mappedBy = "enWord", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Card> cards;

}
