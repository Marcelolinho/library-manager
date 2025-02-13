package com.example.library_manager.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Table(name="review")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Review {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private UUID id;

    @Column(nullable=false)
    private StringBuffer description;

    @Column(nullable=false)
    private String stars;

    @ManyToOne
    @JoinColumn(name="id_book")
    private Book id_book;
}
