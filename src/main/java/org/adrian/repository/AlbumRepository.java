package org.adrian.repository;

import org.adrian.model.Album;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends MongoRepository<Album, String> {

    //busqueda de album por id
    Album findByid(String id);

}
