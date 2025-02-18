package com.acciojob.Book_My_show_Backend.Repository;

import com.acciojob.Book_My_show_Backend.model.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterRepository extends JpaRepository<Theater,Integer> {

}
