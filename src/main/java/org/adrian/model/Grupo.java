package org.adrian.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "grupos")
public class Grupo {

    @Id
    private Long id;
    private String nome;
    private String xenero;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataFormacion;

    public Grupo(Long id, String nome, String xenero, LocalDate dataFormacion) {
        this.id = id;
        this.nome = nome;
        this.xenero = xenero;
        this.dataFormacion = dataFormacion;
    }

    public Grupo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getXenero() {
        return xenero;
    }

    public void setXenero(String xenero) {
        this.xenero = xenero;
    }

    public LocalDate getDataFormacion() {
        return dataFormacion;
    }

    public void setDataFormacion(LocalDate dataFormacion) {
        this.dataFormacion = dataFormacion;
    }
}
