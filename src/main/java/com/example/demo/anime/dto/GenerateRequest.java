package com.example.demo.anime.dto;

import java.util.List;

public class GenerateRequest {
    private String protagonistName;
    private String genre;
    private String tone;
    private List<String> keywords;
    private String length; // short | medium | long
    private Long seed;

    // getters & setters
    public String getProtagonistName() { return protagonistName; }
    public void setProtagonistName(String protagonistName) { this.protagonistName = protagonistName; }
    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }
    public String getTone() { return tone; }
    public void setTone(String tone) { this.tone = tone; }
    public List<String> getKeywords() { return keywords; }
    public void setKeywords(List<String> keywords) { this.keywords = keywords; }
    public String getLength() { return length; }
    public void setLength(String length) { this.length = length; }
    public Long getSeed() { return seed; }
    public void setSeed(Long seed) { this.seed = seed; }
}
