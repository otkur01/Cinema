package com.cydeo.repository;


import com.cydeo.entiry.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that return all genres
          @Query("select genre from Genre genre")
         List<Genre> retrieveAllGenre();


    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns genres by containing name
    @Query(value = "select *from genre where name like ilike concat('%',?1,'%') ", nativeQuery = true)
    List<Genre> retrieveGenreContaining(String name);


}
