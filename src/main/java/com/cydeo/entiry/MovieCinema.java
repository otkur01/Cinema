package com.cydeo.entiry;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class MovieCinema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateTime;
    @ManyToOne
   // @JoinColumn(name = "cinema_id")
    private Cinema cinema;
    @ManyToOne
   // @JoinColumn(name = "movie_id")
    private Movie movie;
//   @OneToMany(mappedBy = "movieCinema")
//   private List<Ticket> ticketList;


    @Override
    public String toString() {
        return "MovieCinema{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                '}';
    }
}
