package Nbaws.NbaWs.controller;

import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Nbaws.NbaWs.model.JoueurMatchEquipe;
import Nbaws.NbaWs.model.Reponse;
import Nbaws.NbaWs.service.JoueurMatchService;

@RequestMapping("apiMatch")
@RestController
public class MatchController {
    
    @Autowired
    JoueurMatchService joueurMatchService;

    @GetMapping("/equipe/{idmatch}")
    public Reponse<JoueurMatchEquipe> getByUsername(@PathVariable String idmatch){
        Reponse<JoueurMatchEquipe> valiny=new Reponse<JoueurMatchEquipe>();
        try{
                JoueurMatchEquipe joueurmatch=joueurMatchService.findByJoueurMatchEquipe(idmatch);
                valiny.setData(joueurmatch);
        }
        catch(Exception e)
        {
            valiny.setErreur(e.getMessage());
        }
        return valiny;
    }
}   