package com.example.VideoGameAPI.Service;

import com.example.VideoGameAPI.VideoGame;
import com.example.VideoGameAPI.VideoGameRepository;
import com.example.VideoGameAPI.controller.VideoGameNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.nio.file.FileAlreadyExistsException;
import java.util.List;
import java.util.Optional;

@Service
public class VideoGameService {

    @Autowired
    VideoGameRepository videoGameRepository;

    public void create(VideoGame videoGame) throws FileAlreadyExistsException {
        if (videoGameRepository.findById(videoGame.getTitle()).isEmpty()) {
            videoGameRepository.save(videoGame);
        } else {
            throw new FileAlreadyExistsException("Video GAme (" + videoGame.getTitle() + ") already exists");
        }

    }


    public List<VideoGame> getAllVideoGames() {
        return videoGameRepository.findAll();
    }

    public List<VideoGame> getGameByGenre(String genre) throws Exception {
        List<VideoGame> game = videoGameRepository.findByGenre(genre);
        if (game.isEmpty()) {
            throw new Exception("Video game does not exist");
        }
        return game;
    }

    public List<VideoGame> getGameByPlatform(String platform) {
        List<VideoGame> game = videoGameRepository.findByPlatform(platform);
        if (game.isEmpty()) {
            throw new VideoGameNotFoundException("Video game does not exist");
        }
        return game;
    }


    public VideoGame updateGame(VideoGame videoGame) {
        if (videoGameRepository.findById(videoGame.getTitle()).isPresent()) {
            videoGameRepository.save(videoGame);
            return videoGameRepository.findById(videoGame.getTitle()).get();

        } else {
            throw new VideoGameNotFoundException("Video game does not exist");
        }
    }

    public void deleteVideoGame(String title) {
        Optional<VideoGame> game = videoGameRepository.findById(title);
        if (game.isEmpty()) {
            throw new VideoGameNotFoundException("Video Game does not exist");
        } else {
            videoGameRepository.delete(game.get());
        }
    }
}
