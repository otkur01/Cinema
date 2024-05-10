package com.cydeo.entiry;

import com.cydeo.enums.State;
import com.cydeo.enums.Type;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
     private BigDecimal price;
    @Enumerated(EnumType.STRING)
     private Type type;
    @Enumerated(EnumType.STRING)
     private State state;
     private LocalDateTime releaseDate;

     private Long Duration;
      private String summary;@OneToMany(mappedBy = "movie")
     private List<MovieCinema> movieCinemaList;
      @ManyToMany
      @JoinTable(name = "MovieGenreRel",
        joinColumns=@JoinColumn(name = "movie_id"),
      inverseJoinColumns=@JoinColumn(name="genre_id"))
      private List<Genre> genreList;

}
