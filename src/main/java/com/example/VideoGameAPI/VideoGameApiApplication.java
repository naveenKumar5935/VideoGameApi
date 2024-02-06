package com.example.VideoGameAPI;

import com.example.VideoGameAPI.Service.VideoGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class VideoGameApiApplication implements CommandLineRunner {
	@Autowired
	VideoGameService videoGameService;

	public static void main(String[] args) {
		SpringApplication.run(VideoGameApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		VideoGame videoGame = new VideoGame("GTA V","Open World","PS5", LocalDate.now().minusDays(50));
		videoGameService.create(videoGame);
	}
}
