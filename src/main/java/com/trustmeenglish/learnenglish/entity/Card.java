package com.trustmeenglish.learnenglish.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"meaning"})
@Table(name = "cards")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long rating;
    @ManyToOne
    private EnWord enWord;
    @ManyToOne
    private RuWord ruWord;
    @OneToOne
    @JoinColumn(name = "image_id")
    private Image image;
}
