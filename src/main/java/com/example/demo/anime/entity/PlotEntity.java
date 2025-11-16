package com.example.demo.anime.entity;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "plots")
public class PlotEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @Lob
    @Column(columnDefinition = "CLOB")
    private String inputJson;

    @Lob
    @Column(columnDefinition = "CLOB")
    private String outputJson;

    private Long seed;

    private Instant createdAt = Instant.now();

    public PlotEntity() {}
    // getters/setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getInputJson() { return inputJson; }
    public void setInputJson(String inputJson) { this.inputJson = inputJson; }
    public String getOutputJson() { return outputJson; }
    public void setOutputJson(String outputJson) { this.outputJson = outputJson; }
    public Long getSeed() { return seed; }
    public void setSeed(Long seed) { this.seed = seed; }
    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
}
