package com.example.library_manager.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Table(name="book")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private UUID id;

    @Column(nullable=false)
    private String title;

    @Column(nullable=false)
    private String status;

    @ManyToOne
    @JoinColumn(name="author")
    private Author id_author;

    @ManyToMany
    @JoinTable(
            name="book_category",
            joinColumns=@JoinColumn(name="id_book"),
            inverseJoinColumns=@JoinColumn(name="id_category")
    )
    private Set<Category> categories = new HashSet<>();
}
