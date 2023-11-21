package Nbaws.NbaWs.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Nbaws.NbaWs.model.JoueurMatchEquipe;
import Nbaws.NbaWs.repository.JoueurMatchRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

@Service
public class JoueurMatchService {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private JoueurMatchRepository repository;

    public JoueurMatchEquipe findByJoueurMatchEquipe(String idmatch){
        int id=Integer.valueOf(idmatch);
        JoueurMatchEquipe j=repository.findById(id);
        System.out.println(j);
        return j;
    }
    /* 
    public List<Token> findAll(){
        return tokenrepository.findAll();
    }

    public boolean verifieConnection(HttpServletRequest request)
    {
            boolean tok=false;
            Cookie[] cookies = request.getCookies();

            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if ("myToken".equals(cookie.getName())) {
                        String token=cookie.getValue();
                        if(!this.findByToken(token,true).isEmpty()){
                            tok=true;
                        }
                    }
                }
            }
            return tok;
    }


    public void updateToken(String value) {
        Query query = new Query(Criteria.where("token").is(value));
        Update update = new Update().set("etat", false);
        mongoTemplate.updateFirst(query, update, Token.class);
    }*/
}
