package com.cydeo.entiry;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String latitude;
    private String country;
    private String city;
    private String state;
    private String postalCode;
    private String address;
    @OneToMany(mappedBy = "location")
    private List<Cinema> cinemaList;
}
