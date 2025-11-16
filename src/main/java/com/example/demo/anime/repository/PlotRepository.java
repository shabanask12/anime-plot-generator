package com.example.demo.anime.repository;

import com.example.demo.anime.entity.PlotEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PlotRepository extends JpaRepository<PlotEntity, UUID> {
}
