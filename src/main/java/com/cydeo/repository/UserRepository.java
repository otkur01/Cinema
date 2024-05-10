package com.cydeo.repository;

import com.cydeo.entiry.UserAccount;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface UserRepository extends JpaRepository<UserAccount, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read a user with an email?

    UserAccount findByEmail(String email);


    //Write a derived query to read a user with a username?

    UserAccount findByUsername(String username);

    //Write a derived query to list all users that contain a specific name?
      List<UserAccount> findByUsernameContaining(String specific);

    //Write a derived query to list all users that contain a specific name in the ignore case mode?
    List<UserAccount> findByUsernameContainingIgnoreCase (String specific);

    //Write a derived query to list all users with an age greater than a specified age?
     // List<UserAccount> findUserAccountByAccountDetail_Age(int age);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns a user read by email?


    @Query("select user from UserAccount user where user.email=?1")
    UserAccount retrieveUserByEmail(String email);


    //Write a JPQL query that returns a user read by username?

    @Query("select user from UserAccount user where user.username=?1")
    UserAccount retrieveUserByUserName(String username);

    //Write a JPQL query that returns all users?
    @Query("select user from UserAccount user")
    List<UserAccount> allUsers();


    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns all users that contain a specific name?


    @Query(value = "select * from user_account where username=?1",nativeQuery = true)
    List<UserAccount> retrieveAllUsersByname(String name);


    //Write a native query that returns all users?


    @Query(value = "select * from user_account ",nativeQuery = true)
    List<UserAccount> retrieveAllUser();



    //Write a native query that returns all users in the range of ages?


//    @Query(value = "select * from user_account  join user_details on account_details.id= user_account.account_details.id  order by account_details.age",nativeQuery = true)
//    List<UserAccount> allUserByAgeRange();


    //Write a native query to read a user by email?

    @Query(value = "select * from user_account where email=?1",nativeQuery = true)
    UserAccount retrieveUserByEmail2(String email);


}
