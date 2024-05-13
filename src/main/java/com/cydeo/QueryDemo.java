package com.cydeo;

import com.cydeo.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class QueryDemo implements CommandLineRunner {

    private final AccountRepository accountRepository;
      private final UserRepository userRepository;

      private final TicketRepository ticketRepository;
      private final MovieRepository movieRepository;
      private final MovieCinemaRepository movieCinemaRepository;
      private final GenreRepository genreRepository;
      private final CinemaRepository cinemaRepository;


    public QueryDemo(AccountRepository accountRepository, UserRepository userRepository, TicketRepository ticketRepository, MovieRepository movieRepository, MovieCinemaRepository movieCinemaRepository, GenreRepository genreRepository, CinemaRepository cinemaRepository) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
        this.ticketRepository = ticketRepository;
        this.movieRepository = movieRepository;
        this.movieCinemaRepository = movieCinemaRepository;
        this.genreRepository = genreRepository;
        this.cinemaRepository = cinemaRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println(" the first query" + accountRepository.findByCountryOrState("United States", "Buffalo"));
        System.out.println("find by age"+ accountRepository.findByAgeGreaterThanEqual(40));
        System.out.println("the admin all " + accountRepository.retriveAllAdmin());
        System.out.println("the account ordered by ages" + accountRepository.retrieveAllOrderedByAge());




    }
}
