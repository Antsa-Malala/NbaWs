package Nbaws.NbaWs.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import Nbaws.NbaWs.model.Equipe;
import Nbaws.NbaWs.model.Joueur;

import java.util.List;

@Repository
public interface EquipeRepository extends MongoRepository<Equipe, String> {
    /*@Query("{ 'token' : ?0, 'etat' : ?1 }")
    List<Token> findByToken(String token,boolean etat);*/
}
