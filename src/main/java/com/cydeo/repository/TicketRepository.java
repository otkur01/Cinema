package com.cydeo.repository;


import com.cydeo.entiry.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to count how many tickets a user bought
     int countTicketByUserAccountId(Long id);



    //Write a derived query to list all tickets by specific email

   List<Ticket> findByUserAccountEmailIs(String email);


    //Write a derived query to count how many tickets are sold for a specific movie

   // int countByMovieNameCinema_Movie(String name);


    //Write a derived query to list all tickets between a range of dates

    List<Ticket> findByDateTimeBetween(LocalDateTime time, LocalDateTime time2);


    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all tickets are bought from a specific user

    @Query("select t from Ticket t where t.userAccount=?1")
     List<Ticket> allTicketsForUser(Long UserId);


    //Write a JPQL query that returns all tickets between a range of dates
    @Query("select t FROM Ticket t where t.dateTime BETWEEN ?1 AND ?2")
     List<Ticket> allTicketsBtwnDate(LocalDateTime time1, LocalDateTime time2);

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count the number of tickets a user bought

    @Query(value = "select count * from ticket where user_account_id=?1",nativeQuery = true)
    int countTicketsByUserId(Long userId);

    //Write a native query to count the number of tickets a user bought in a specific range of dates

    @Query(value = "select count * from ticket where user_account_id=?1 and date_time between ?2 and ?3", nativeQuery = true)
    int countTicketByUserIdDates(Long userId, LocalDateTime time1, LocalDateTime time2);

    //Write a native query to distinct all tickets by movie name


    @Query(value = "select * from ticket t join movie_cinema m on t.movie_cimema_id =m.id join movie v on m.id = v.id where movie.name = ?1", nativeQuery = true)
    List<Ticket> allDistinctTicketByMovieName(String movieName);

    //Write a native query to find all tickets by user email


    //Write a native query that returns all tickets
    @Query(value = "select * from ticket",nativeQuery = true)
    List<Ticket> allTickets();

    //Write a native query to list all tickets where a specific value should be containable in the username or account name or movie name


}
