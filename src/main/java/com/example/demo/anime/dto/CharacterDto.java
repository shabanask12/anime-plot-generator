package com.example.demo.anime.dto;

import java.util.List;
public class CharacterDto {
    private String name;
    private String role;
    private List<String> traits;
    public CharacterDto() {}
    public CharacterDto(String name, String role, List<String> traits) {
        this.name = name; this.role = role; this.traits = traits;
    }
    // getters/setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public List<String> getTraits() { return traits; }
    public void setTraits(List<String> traits) { this.traits = traits; }
}
