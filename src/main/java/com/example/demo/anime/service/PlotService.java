package com.example.demo.anime.service;

import com.example.demo.anime.dto.GenerateRequest;
import com.example.demo.anime.dto.PlotDto;
import com.example.demo.anime.entity.PlotEntity;
import com.example.demo.anime.repository.PlotRepository;
import com.example.demo.anime.util.TemplateEngine;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PlotService {

    private final PlotRepository plotRepository;
    private final ObjectMapper objectMapper;

    public PlotService(PlotRepository plotRepository, ObjectMapper objectMapper) {
        this.plotRepository = plotRepository;
        this.objectMapper = objectMapper;
    }

    public PlotDto generateAndSave(GenerateRequest req) {
        PlotDto dto = TemplateEngine.generate(req);
        try {
            PlotEntity entity = new PlotEntity();
            entity.setInputJson(objectMapper.writeValueAsString(req));
            entity.setOutputJson(objectMapper.writeValueAsString(dto));
            entity.setSeed(dto.getSeed());
            plotRepository.save(entity);

            dto.setId(entity.getId());
            return dto;

        } catch (Exception ex) {
            throw new RuntimeException("Failed to save plot", ex);
        }
    }

    public PlotDto findById(UUID id) {
        return plotRepository.findById(id).map(e -> {
            try {
                return objectMapper.readValue(e.getOutputJson(), PlotDto.class);
            } catch (Exception ex) {
                throw new RuntimeException("Failed to read saved plot", ex);
            }
        }).orElse(null);
    }
}
