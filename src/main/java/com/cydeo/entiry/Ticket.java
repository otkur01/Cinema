package com.cydeo.entiry;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Entity
@NoArgsConstructor
@Data
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateTime;

    private Integer seatNumber;
    private Integer rowNumber;
    @ManyToOne(fetch = FetchType.LAZY)
   // @JoinColumn(name = "movie_cinema_id")
    private MovieCinema movieCinema;
    @ManyToOne(fetch = FetchType.LAZY)
  // @JoinColumn(name = "user_account_id")
    private UserAccount userAccount;



}
