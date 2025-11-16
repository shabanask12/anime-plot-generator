package com.example.demo.anime.util;

import com.example.demo.anime.dto.CharacterDto;
import com.example.demo.anime.dto.EpisodeDto;
import com.example.demo.anime.dto.GenerateRequest;
import com.example.demo.anime.dto.PlotDto;

import java.util.*;

public class TemplateEngine {

    private static final String[] ADJ = {"Crimson","Silent","Hidden","Moonlit","Fading","Shimmering"};
    private static final String[] NOUN = {"Sonata","Promise","Echo","Blade","Melody","Moon"};
    private static final String[] TRAITS = {"brave","stubborn","kind","mysterious","hot-headed","quiet"};
    private static final String[] EP_BEATS = {
            "A normal day that hides a problem",
            "An inciting incident changes everything",
            "Training / learning montage",
            "A betrayal or heartbreaking reveal",
            "Major clash with antagonist",
            "Cliffhanger leading to the finale"
    };

    public static PlotDto generate(GenerateRequest req) {
        long seed = req.getSeed() != null ? req.getSeed() : System.currentTimeMillis();
        Random rng = new Random(seed);

        String adjective = ADJ[rng.nextInt(ADJ.length)];
        String noun = NOUN[rng.nextInt(NOUN.length)];
        String title = adjective + " " + noun;

        String protagonist = (req.getProtagonistName() == null || req.getProtagonistName().isBlank())
                ? "The Protagonist" : req.getProtagonistName();

        // Build a simple logline
        String logline = String.format("%s, a %s, must face a hidden threat tied to %s.",
                protagonist,
                pickTrait(rng),
                pickKeyword(req, rng));

        // Simple synopsis
        String synopsis = String.format("%s grew up surrounded by %s. When a strange event tied to %s occurs, %s must learn to %s. Over the course of the story, %s discovers %s.",
                protagonist,
                pickKeyword(req, rng),
                pickKeyword(req, rng),
                protagonist,
                "master an unexpected skill",
                protagonist,
                pickTrait(rng));

        // Characters: protagonist, ally, antagonist
        List<CharacterDto> chars = new ArrayList<>();
        chars.add(new CharacterDto(protagonist, "protagonist", randomTraits(rng)));
        chars.add(new CharacterDto("Kaito", "ally", randomTraits(rng)));
        chars.add(new CharacterDto("Maestro", "antagonist", randomTraits(rng)));

        // Episodes (6)
        int episodesCount = 6;
        List<EpisodeDto> eps = new ArrayList<>();
        for (int i = 0; i < episodesCount; i++) {
            String epTitle = "Episode " + (i + 1) + " — " + simpleTitle(rng);
            String summary = EP_BEATS[i % EP_BEATS.length] + " (short beat, uses " + pickKeyword(req, rng) + ").";
            eps.add(new EpisodeDto(i + 1, epTitle, summary));
        }

        return new PlotDto(null, title, logline, synopsis, chars, eps, seed);
    }

    private static String pickTrait(Random rng) {
        return TRAITS[rng.nextInt(TRAITS.length)];
    }

    private static List<String> randomTraits(Random rng) {
        List<String> out = new ArrayList<>();
        out.add(TRAITS[rng.nextInt(TRAITS.length)]);
        out.add(TRAITS[rng.nextInt(TRAITS.length)]);
        out.add(TRAITS[rng.nextInt(TRAITS.length)]);
        return out;
    }

    private static String pickKeyword(GenerateRequest req, Random rng) {
        if (req.getKeywords() != null && !req.getKeywords().isEmpty()) {
            return req.getKeywords().get(rng.nextInt(req.getKeywords().size()));
        }
        String[] fallback = {"rain","music","city","festival","memory","dream"};
        return fallback[rng.nextInt(fallback.length)];
    }

    private static String simpleTitle(Random rng) {
        String[] t = {"First Note","A New Path","Betrayal","The Hidden Score","Echoes","Crossroads"};
        return t[rng.nextInt(t.length)];
    }
}
