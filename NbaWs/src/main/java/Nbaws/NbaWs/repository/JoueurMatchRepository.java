package Nbaws.NbaWs.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import Nbaws.NbaWs.model.JoueurMatchEquipe;

import java.util.List;

@Repository
public interface JoueurMatchRepository extends MongoRepository<JoueurMatchEquipe, String> {
    @Query("{'id' : ?0}")
    JoueurMatchEquipe findByIdmatch(int id);
}
