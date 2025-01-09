package com.example.library_manager.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Table(name="review")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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
