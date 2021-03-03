package com.iths.labb2.repositories;

import com.iths.labb2.entities.Snake;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SnakeRepository extends JpaRepository<Snake, Integer> {
    List<Snake> findAllByName(String name);

}

