package com.acciojob.Book_My_show_Backend.Repository;

import com.acciojob.Book_My_show_Backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

}
