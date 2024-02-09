package com.trustmeenglish.learnenglish.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "images")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String originalFilename;
    private String contentType;
    private Long size;
    @Column(columnDefinition = "LONGBLOB")
    private byte[] bytes;
}
