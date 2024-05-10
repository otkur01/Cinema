package com.cydeo;

import com.cydeo.repository.MovieRepository;
import com.cydeo.repository.TicketRepository;
import com.cydeo.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class QueryDemo implements CommandLineRunner {
      private final UserRepository userRepository;

      private final TicketRepository ticketRepository;
      private final MovieRepository movieRepository;

    public QueryDemo(UserRepository userRepository, TicketRepository ticketRepository, MovieRepository movieRepository) {
        this.userRepository = userRepository;
        this.ticketRepository = ticketRepository;
        this.movieRepository = movieRepository;
    }

    @Override
    public void run(String... args) throws Exception {
     // System.out.println("the user age bigger than "+ userRepository.findUserAccountByAccountDetail_Age(47));
//
//     //   System.out.println("the user by email" + userRepository.retrieveUserByEmail("bernard@email.com"));
//
//
//        System.out.println("all users are" + userRepository.allUsers());
//
//        System.out.println("the user by name native query"+ userRepository.retrieveUserByUserName("bernard"));
//
//        //System.out.println("the all users odered by age range "+ userRepository.allUserByAgeRange());
//
//        System.out.println("the user by email "+ userRepository.retrieveUserByEmail2("lawrence.f@email.com"));
//
//        System.out.println("ticket repository___________________________________");
//
//        System.out.println("count teckit by user"+ ticketRepository.countTicketByUserAccountId(2L));
//
     // System.out.println("the ticket by email "+ ticketRepository.findByUserAccountEmailIs("faith.p@email.com"));
//
//       // System.out.println("the ticekt between "+ ticketRepository.findByDateTimeBetween(LocalDateTime.of(2020,12,07,00,00,00),LocalDateTime.of(2020,12,8,00,00,00)));
//        System.out.println(ticketRepository.countTicketByUserAccountId(5L));
//
//        //System.out.println(ticketRepository.allDistinctTicketByMovieName("The Gentleman"));

        //System.out.println("count by movie name "+ ticketRepository.countTicketByMovieNameCinema_Movie("The Gentleman"));

        System.out.println("movies between two price "+movieRepository.findByPriceBetween(BigDecimal.valueOf(30.0),BigDecimal.valueOf(50.0) ));

    }
}
