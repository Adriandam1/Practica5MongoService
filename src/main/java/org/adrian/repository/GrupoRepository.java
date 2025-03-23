package org.adrian.repository;


import org.adrian.model.Grupo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoRepository extends MongoRepository<Grupo, String> {

}
