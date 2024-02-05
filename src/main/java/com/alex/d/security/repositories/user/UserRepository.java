package com.alex.d.security.repositories.user;


import com.alex.d.security.entity.user.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {
    Optional<UserModel> findByLogin (String login);

    @Query("SELECT u FROM UserModel u WHERE u.login = :login")
    UserModel getUserByLogin(@Param("login") String login);
}
