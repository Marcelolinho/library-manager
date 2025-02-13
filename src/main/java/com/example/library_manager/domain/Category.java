package com.example.library_manager.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Table(name="category")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private UUID id;

    @Column(nullable=false)
    private String category_name;
}
