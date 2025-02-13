package com.example.library_manager.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Table(name="publisher")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Publisher {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private UUID id;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false)
    private String fantasy_name;
}
