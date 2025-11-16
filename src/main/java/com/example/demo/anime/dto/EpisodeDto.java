package com.example.demo.anime.dto;

public class EpisodeDto {

    private int ep;
    private String title;
    private String summary;

    public EpisodeDto() {}

    public EpisodeDto(int ep, String title, String summary) {
        this.ep = ep;
        this.title = title;
        this.summary = summary;
    }

    public int getEp() { return ep; }
    public void setEp(int ep) { this.ep = ep; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getSummary() { return summary; }
    public void setSummary(String summary) { this.summary = summary; }
}
