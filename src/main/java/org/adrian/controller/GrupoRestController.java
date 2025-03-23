package org.adrian.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.adrian.model.Album;
import org.adrian.model.Grupo;
import org.adrian.repository.GrupoRepository;
import org.adrian.service.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GrupoRestController {

    @Autowired
    private GrupoRepository grupoRepository;

    @Autowired
    private GrupoService grupoService;

    @Operation(summary = "Crear un novo grupo")
    @PostMapping("/crearGrupo")
    public Grupo crearGrupo(@RequestBody Grupo grupo) {
        return grupoService.crearGrupo(grupo);
    }

    @Operation(summary = "Eliminar grupo por ID")
    @DeleteMapping("/borrarGrupo/{id}")
    public ResponseEntity<Void> borrarGrupo(@PathVariable String id) {
        if (grupoRepository.existsById(id)) {
            grupoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /*
    private String id;
    private String nome;
    private String xenero;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataFormacion;
     */
    @Operation(summary = "Actualizar un grupo por ID")
    @PutMapping("/actualizarGrupo/{id}")
    public ResponseEntity<Grupo> actualizarGrupo(@PathVariable String id, @RequestBody Grupo grupoDetails) {
        Optional<Grupo> grupoOptional = grupoService.listarGrupoPorId(id);
        if (grupoOptional.isPresent()) {
            Grupo grupo = grupoOptional.get();
            grupo.setNome(grupoDetails.getNome());
            grupo.setXenero(grupoDetails.getXenero());
            grupo.setDataFormacion(grupoDetails.getDataFormacion());
            Grupo grupoActualizado = grupoService.actualizarGrupo(grupo);
            return ResponseEntity.ok(grupoActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @Operation(summary = "Obter todos os grupos")
    @GetMapping("/listarGrupo")
    public List<Grupo> obterPersoas() {
        return grupoService.listarGrupo();
    }

    @Operation(summary = "Obter grupo por ID")
    @GetMapping("/listarGrupo/{id}")
    public ResponseEntity<Grupo> listarGrupo(@PathVariable String id) {
        Optional<Grupo> grupo = grupoService.listarGrupoPorId(id);
        return grupo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }




}
