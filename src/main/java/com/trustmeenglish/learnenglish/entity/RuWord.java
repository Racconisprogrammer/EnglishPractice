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
@Table(name = "ru_words")
public class RuWord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String meaning;
    @OneToMany(mappedBy = "ruWord", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Card> cards;
}
