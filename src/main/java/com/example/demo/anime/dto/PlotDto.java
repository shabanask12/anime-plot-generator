package com.example.demo.anime.dto;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public class PlotDto {

    private UUID id;
    private String title;
    private String logline;
    private String synopsis;
    private List<CharacterDto> characters;
    private List<EpisodeDto> episodes;
    private Long seed;
    private Instant createdAt;

    public PlotDto() {}

    public PlotDto(UUID id, String title, String logline, String synopsis,
                   List<CharacterDto> characters, List<EpisodeDto> episodes, Long seed) {
        this.id = id;
        this.title = title;
        this.logline = logline;
        this.synopsis = synopsis;
        this.characters = characters;
        this.episodes = episodes;
        this.seed = seed;
        this.createdAt = Instant.now();
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getLogline() { return logline; }
    public void setLogline(String logline) { this.logline = logline; }

    public String getSynopsis() { return synopsis; }
    public void setSynopsis(String synopsis) { this.synopsis = synopsis; }

    public List<CharacterDto> getCharacters() { return characters; }
    public void setCharacters(List<CharacterDto> characters) { this.characters = characters; }

    public List<EpisodeDto> getEpisodes() { return episodes; }
    public void setEpisodes(List<EpisodeDto> episodes) { this.episodes = episodes; }

    public Long getSeed() { return seed; }
    public void setSeed(Long seed) { this.seed = seed; }

    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
}
