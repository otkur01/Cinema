package com.cydeo.entiry;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Cinema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
     private String sponsoredName;
    @ManyToOne
    //@JoinColumn(name = "location_id")
    private Location location;
     @OneToMany(mappedBy = "cinema")
     private List<MovieCinema> movieCinemaList;



}
