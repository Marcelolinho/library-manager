package com.example.library_manager.domain;


import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Table(name="user")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private UUID id;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false)
    private String email;

    @Column(nullable=false)
    private String password;
}
