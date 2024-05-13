package com.cydeo.entiry;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Entity
@NoArgsConstructor
@Getter
@Setter
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateTime;

    private Integer seatNumber;
    private Integer rowNumber;
    @ManyToOne
   // @JoinColumn(name = "movie_cinema_id")
    private MovieCinema movieCinema;
    @ManyToOne
  // @JoinColumn(name = "user_account_id")
    private UserAccount userAccount;

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", seatNumber=" + seatNumber +
                ", rowNumber=" + rowNumber +
                '}';
    }
}
