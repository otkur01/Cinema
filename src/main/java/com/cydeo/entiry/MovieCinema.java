package com.cydeo.entiry;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class MovieCinema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateTime;
    @ManyToOne(fetch = FetchType.LAZY)
   // @JoinColumn(name = "cinema_id")
    private Cinema cinema;
    @ManyToOne(fetch = FetchType.LAZY)
   // @JoinColumn(name = "movie_id")
    private Movie movie;
//    @OneToMany(mappedBy = "movieCinema")
//    private List<Ticket> ticketList;
}
