package com.cydeo.entiry;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String password;

    private String username;
   @OneToMany(mappedBy = "userAccount")
    private List<Ticket> ticketList;
   @OneToOne
   @JoinColumn(name = "account_details_id")
   private AccountDetail accountDetail;

}
