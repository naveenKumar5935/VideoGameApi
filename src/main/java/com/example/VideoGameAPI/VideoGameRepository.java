package com.example.VideoGameAPI;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoGameRepository extends JpaRepository<VideoGame,String> {

    List<VideoGame>findByGenre(String genre);
    List<VideoGame> findByPlatform(String platform);
}
