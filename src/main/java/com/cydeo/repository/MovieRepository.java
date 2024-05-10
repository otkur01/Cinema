package com.cydeo.repository;


import com.cydeo.entiry.Movie;
import com.cydeo.enums.State;
import com.cydeo.enums.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read a movie with a name

    Movie findByName(String movieName);


    //Write a derived query to list all movies between a range of prices
    List<Movie> findByPriceBetween(BigDecimal price, BigDecimal price1);


    //Write a derived query to list all movies where duration exists in the specific list of duration
    List<Movie> findByDurationWithin(List<Integer>times);

    //Write a derived query to list all movies with higher than a specific release date
 List<Movie> findByReleaseDateAfter(LocalDateTime time);

    //Write a derived query to list all movies with a specific state and type
      List<Movie> findByStateAndType(State state, Type type);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to list all movies between a range of prices

    @Query("select movie from Movie movie where movie.price between ?1 and ?2")
    List<Movie> retrieveMovieByPriceBTW(BigDecimal price, BigDecimal price1);


    //Write a JPQL query that returns all movie names

    @Query("select movie from Movie movie where movie.name= ?1")
    List<Movie> allMovieByName(String movieName);


    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns a movie by name
    @Query(value = "select * from movie where movie_name = ?1", nativeQuery = true)
    Movie retrieveMovieByName(String movieName);

    //Write a native query that return the list of movies in a specific range of prices

    @Query(value = "select * from movie where movie_price between ?1 and ?2", nativeQuery = true)
    List<Movie> retriveAllMovieBtwprice(BigDecimal price, BigDecimal price2);


    //Write a native query to return all movies where duration exists in the range of duration
    @Query(value = "select * from movie where movie_duration between ?1 and ?2", nativeQuery = true)
    List<Movie> retrieveAllMovieByDuration( Integer dur1, Integer dur2);


    //Write a native query to list the top 5 most expensive movies
    @Query(value = "select * from movie order by price desc limit 5", nativeQuery = true)
     List<Movie> retrieveTop5MoiveByprice();



}
