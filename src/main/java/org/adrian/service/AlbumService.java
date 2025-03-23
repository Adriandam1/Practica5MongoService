package org.adrian.service;

import org.adrian.model.Album;
import org.adrian.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    public AlbumService (AlbumRepository albumRepository){
        this.albumRepository = albumRepository;
    }

    /*
    * Método que crea o actualiza un album
     */
    public Album crearAlbum(Album album) {
        return albumRepository.save(album);
    }

    /*
    * Método que borra un album por id
     */
    public Album borrarAlbumPorId(String id) {
        Album album = albumRepository.findById(id).orElse(null);
        if (album != null) {
            albumRepository.deleteById(id);
        }
        return album;
    }

    /*
    * Método que actualiza un album por id
     */
    public Album actualizarAlbum(Album album) {
        return albumRepository.save(album);
    }

    /*
    * Método que devolve unha lista de todos os albums
     */
    public List<Album> listarAlbum() {
        return albumRepository.findAll();
    }

    /*
    * Método que devolve un album por id
     */
    public Optional<Album> listarAlbumPorId(String id) {
        return albumRepository.findById(id);
    }


}
