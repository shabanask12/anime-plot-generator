package com.example.demo.anime.controller;

import com.example.demo.anime.dto.GenerateRequest;
import com.example.demo.anime.dto.PlotDto;
import com.example.demo.anime.service.PlotService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api")
public class PlotController {

    private final PlotService plotService;

    public PlotController(PlotService plotService) {
        this.plotService = plotService;
    }

    @PostMapping("/generate")
    public ResponseEntity<PlotDto> generate(@RequestBody GenerateRequest req) {
        PlotDto dto = plotService.generateAndSave(req);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/plots/{id}")
    public ResponseEntity<PlotDto> getPlot(@PathVariable UUID id) {
        PlotDto dto = plotService.findById(id);
        if (dto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(dto);
    }
}
