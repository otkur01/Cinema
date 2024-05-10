package com.cydeo.entiry;

import com.cydeo.enums.Role;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Table(name = "account_details")
public class AccountDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;
    private String country;

    private String city;

    private String state;
    private int age;

    private String postalCode;
    @Enumerated(EnumType.STRING)
    private Role role;
   @OneToOne(mappedBy = "accountDetail")
   private UserAccount userAccount;


}
