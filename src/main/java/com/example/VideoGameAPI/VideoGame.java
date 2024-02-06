package com.example.VideoGameAPI;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
@Entity
public class VideoGame {
    @Size(min = 2)
    @Id
    private String title;
    @NotNull
    private String genre,platform;
            @Past
        private LocalDate releaseDate;
            public VideoGame(){

            }

    public VideoGame(String title, String genre, String platform, LocalDate releaseDate) {
        this.title = title;
        this.genre = genre;
        this.platform = platform;
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
}
