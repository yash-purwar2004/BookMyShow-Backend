package com.example.BookMyShow_Backend.entity;

import java.time.LocalDate;

import com.example.BookMyShow_Backend.Enums.Language;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "movies")
@Data               //(combination of @Getter @Setter @toString(present an object in String format) @RequiredArgsConstructor)
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movieId;

    @Column(unique = true)
    private String movieName;

    private Double duration;

    private LocalDate releaseDate;

    @Enumerated(value = EnumType.STRING)
    private Language language;

    private Double rating;
}
