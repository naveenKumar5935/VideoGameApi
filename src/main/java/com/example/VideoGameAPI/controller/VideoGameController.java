package com.example.VideoGameAPI.controller;

import com.example.VideoGameAPI.Service.VideoGameService;
import com.example.VideoGameAPI.VideoGame;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.nio.file.FileAlreadyExistsException;
import java.util.*;

@RestController
public class VideoGameController {

    @Autowired
    VideoGameService videoGameService;

    @PostMapping("/add")
    public void create(@Valid @RequestBody VideoGame videoGame, BindingResult bindingResult) throws FileAlreadyExistsException {
        if (bindingResult.hasErrors()) {
            throw new IllegalArgumentException("Please check the parameters provided.");
        }
        videoGameService.create(videoGame);

    }

    @GetMapping("/getall")
    public ResponseEntity<List<VideoGame>> get() {
        List<VideoGame> allVideoGames = videoGameService.getAllVideoGames();
        if (allVideoGames.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(allVideoGames, HttpStatus.OK);
    }

    @GetMapping("/get/{genre}")
    public List<VideoGame> getGameByGenre(@PathVariable String genre) throws Exception {
        return videoGameService.getGameByGenre(genre);
    }

    @GetMapping("/get")
    public List<VideoGame> getGameByPlatform(@RequestParam String platform) {
        return videoGameService.getGameByPlatform(platform);
    }

    @PutMapping("/update")
    public VideoGame updateGame(@RequestBody VideoGame videoGame) {
        return videoGameService.updateGame(videoGame);
    }

    @DeleteMapping("/delete/{title}")
    public void deleteVideoGame(@PathVariable String title) {
        videoGameService.deleteVideoGame(title);
    }


}
