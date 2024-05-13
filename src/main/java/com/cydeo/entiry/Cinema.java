package com.cydeo.entiry;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Cinema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
     private String sponsoredName;
    @ManyToOne
    //@JoinColumn(name = "location_id")
    private Location location;
//    @OneToMany(mappedBy = "cinema")
//    private List<MovieCinema> movieCinemaList;


    @Override
    public String toString() {
        return "Cinema{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sponsoredName='" + sponsoredName + '\'' +
                '}';
    }
}
