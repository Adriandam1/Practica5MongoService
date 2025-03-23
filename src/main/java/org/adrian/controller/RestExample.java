package org.adrian.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.adrian.repository.AlbumRepository;
import org.adrian.repository.GrupoRepository;
import org.adrian.service.AlbumService;
import org.adrian.service.GrupoService;
import org.adrian.model.Album;
import org.adrian.model.Grupo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(RestExample.MAPPING)
public class RestExample {

    public static final String MAPPING = "/base";

    @Autowired
    private AlbumRepository albumRepository;
    @Autowired
    private AlbumService albumService;

    @Autowired
    private GrupoRepository grupoRepository;
    @Autowired
    private GrupoService grupoService;


    @Operation(summary = "Método que saúda")
    @PostMapping("/saudo")
    public String saudo() {
        return "Boas estamos falando dende mongo";
    }

}
