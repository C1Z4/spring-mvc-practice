package com.ohgiraffers.springmvcpractice.common;

public class MusicDTO {

    private String title;
    private String producer;
    private String singer;
    private String genre;

    public MusicDTO() {}

    public MusicDTO(String title, String producer, String singer, String genre) {
        this.title = title;
        this.producer = producer;
        this.singer = singer;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "MusicDTO{" +
                "title='" + title + '\'' +
                ", producer='" + producer + '\'' +
                ", singer='" + singer + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
