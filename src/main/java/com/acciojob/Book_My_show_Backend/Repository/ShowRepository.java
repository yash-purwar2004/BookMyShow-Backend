package com.acciojob.Book_My_show_Backend.Repository;

import com.acciojob.Book_My_show_Backend.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<Show,Integer> {
}
