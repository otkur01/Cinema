package com.cydeo.repository;


import com.cydeo.entiry.MovieCinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface MovieCinemaRepository extends JpaRepository<MovieCinema, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read movie cinema with id
        Optional<MovieCinema> findById(Long id);

    //Write a derived query to count all movie cinemas with a specific cinema id
        List<MovieCinema> findByCinema_Id(Long id);

    //Write a derived query to count all movie cinemas with a specific movie id
    List<MovieCinema> findByMovie_Id(Long id);

    //Write a derived query to list all movie cinemas with higher than a specific date
      List<MovieCinema> findByDateTimeAfter(LocalDateTime time);

    //Write a derived query to find the top 3 expensive movies
       List<MovieCinema> findTop5ByMovie_Price();


    //Write a derived query to list all movie cinemas that contain a specific movie name
        List<MovieCinema> findByMovie_Name(String movieName);

    //Write a derived query to list all movie cinemas in a specific location name
     List<MovieCinema> findByCinema_Location_Name(String LocationName);


    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to list all movie cinemas with higher than a specific date
    @Query("select cinames from MovieCinema cinames where cinames.dateTime>?1")
      List<MovieCinema> retrieveAllMovieCinemaByDate(LocalDateTime time);


    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count all movie cinemas by cinema id
    @Query(value = "select *from movie_cinema where movie_cinema_id = ?1", nativeQuery = true)
      MovieCinema retrieveById(Long id);


    //Write a native query that returns all movie cinemas by location name
    @Query(value = "select * from movie_cinema m left join cinema c on m.cinema_id = c.id left join public.location l on c.location_id = l.id where l.name=?1", nativeQuery = true)
     List<MovieCinema> retrieveAllByLocationName(String locationName);





}
