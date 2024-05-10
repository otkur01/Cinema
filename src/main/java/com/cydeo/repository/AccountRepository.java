package com.cydeo.repository;

import com.cydeo.entiry.AccountDetail;
import com.cydeo.entiry.UserAccount;

import com.cydeo.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<AccountDetail, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to list all accounts with a specific country or state
    List<AccountDetail> findByCountryOrState(String str);


    //Write a derived query to list all accounts with age lower than or equal to a specific value
    List<AccountDetail> findByAgeGreaterThanEqual(int age);

    //Write a derived query to list all accounts with a specific role
    List<AccountDetail> findByRoleIs(Role role);


    //Write a derived query to list all accounts between a range of ages
    List<AccountDetail> findByAgeBetween(int age1, int age2);


    //Write a derived query to list all accounts where the beginning of the address contains the keyword

    List<AccountDetail> findByAddressStartingWith(String address);


    //Write a derived query to sort the list of accounts with age
    List<AccountDetail> findByAgeOrderByAge();


    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all accounts

    @Query("select account from AccountDetail account")
    List<AccountDetail> retrieveAll();


    //Write a JPQL query to list all admin accounts
    @Query(" select account from AccountDetail account where account.role=?1")
    List<AccountDetail> retriveAllAdmin();


    //Write a JPQL query to sort all accounts with age

    @Query("select account from AccountDetail account order by account.age")
    List<AccountDetail> retrieveAllOrderedByAge();


    // ------------------- Native QUERIES ------------------- //

    //Write a native query to read all accounts with an age lower than a specific value
    @Query(value = "select * from account_details where age<?1", nativeQuery = true)
    List<AccountDetail> retrieveAllLowerAge(int age);


    //Write a native query to read all accounts that a specific value can be containable in the name, address, country, state city

    @Query(value = "select * from account_details where name=?1 or address = ?1 or country=?1 or state=?1 or city=?1", nativeQuery = true)
    List<AccountDetail>retrieveAllBySpecificValue(String spv);


    //Write a native query to read all accounts with an age higher than a specific value
    @Query(value = "select * from account_details where age>?1", nativeQuery = true)
    List<AccountDetail> retrieveAllGreaterAge(int age);

}
