package org.adrian.service;

import org.adrian.model.Grupo;
import org.adrian.repository.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GrupoService {
    @Autowired
    private GrupoRepository grupoRepository;

    public GrupoService(GrupoRepository grupoRepository) {
        this.grupoRepository = grupoRepository;
    }

    /*
     * Método que crea o actualiza un grupo
     */
    public Grupo crearGrupo(Grupo grupo) {
        return grupoRepository.save(grupo);
    }

    /*
     * Método que borra un grupo por id
     */
    public Grupo borrarGrupoPorId(String id) {
        Grupo grupo = grupoRepository.findById(id).orElse(null);
        if (grupo != null) {
            grupoRepository.deleteById(id);
        }
        return grupo;
    }

    /*
     * Método que actualiza un grupo por id
     */
    public Grupo actualizarGrupo(Grupo grupo) {
        return grupoRepository.save(grupo);
    }



    /*
     * Método que devolve unha lista de todos os grupos
     */
    public List<Grupo> listarGrupo() {
        return grupoRepository.findAll();
    }

    /*
     * Método que devolve un grupo por id
     */
    public Optional<Grupo> listarGrupoPorId(String id) {
        return grupoRepository.findById(id);
    }
}
