package com.cai.chatroom.service;

import com.cai.chatroom.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    boolean existsUserByUsername(String username);

    boolean existsUserByUsernameAndPassword(String username,String password);

    boolean existsUserByUsernameAndPasswordAndLocked(String username,String password,int locked);

    User getByUsernameAndPassword(String username,String password);
}
