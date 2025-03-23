package org.adrian.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.adrian.model.Album;
import org.adrian.repository.AlbumRepository;
import org.adrian.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AlbumRestController {

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private AlbumService albumService;

    @Operation(summary = "Método que saúda")
    @PostMapping("/saudo")
    public String saudo() {
        return "Boas! parece que isto, contra todo pronostico, funciona";
    }

    @Operation(summary = "Crear un novo album")
    @PostMapping("/crearAlbum")
    public Album crearAlbum(@RequestBody Album album) {
        return albumService.crearAlbum(album);
    }

    @Operation(summary = "Eliminar album por ID")
    @DeleteMapping("/borrarAlbum/{id}")
    public ResponseEntity<Void> borrarAlbum(@PathVariable String id) {
        if (albumRepository.existsById(id)) {
            albumRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /*
    private String id;
    private String grupo_id;
    private String titulo;
    private LocalDate data_lanzamento;
    private float puntuacion;
     */
    @Operation(summary = "Actualizar un album por ID")
    @PutMapping("/actualizarAlbum/{id}")
    public ResponseEntity<Album> actualizarAlbum(@PathVariable String id, @RequestBody Album albumDetails) {
        Optional<Album> albumOptional = albumService.listarAlbumPorId(id);
        if (albumOptional.isPresent()) {
            Album album = albumOptional.get();
            album.setGrupo_id(albumDetails.getGrupo_id());
            album.setTitulo(albumDetails.getTitulo());
            album.setData_lanzamento(albumDetails.getData_lanzamento());
            album.setPuntuacion(albumDetails.getPuntuacion());
            Album albumActualizado = albumService.actualizarAlbum(album);
            return ResponseEntity.ok(albumActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }




    @Operation(summary = "Obter todos os albums")
    @GetMapping("/listarAlbum")
    public List<Album> obterGrupos() {
        return albumService.listarAlbum();
    }

    @Operation(summary = "Obter album por ID")
    @GetMapping("/listarAlbum/{id}")
    public ResponseEntity<Album> listarAlbum(@PathVariable String id) {
        Optional<Album> album = albumService.listarAlbumPorId(id);
        return album.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }





}
