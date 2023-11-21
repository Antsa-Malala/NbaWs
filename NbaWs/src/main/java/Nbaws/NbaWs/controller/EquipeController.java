package Nbaws.NbaWs.controller;

import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Nbaws.NbaWs.model.Equipe;
import Nbaws.NbaWs.model.Reponse;

@RequestMapping("apiEquipe")
@RestController
public class EquipeController {
    /*  
    @Autowired
    UserService userService;
    
    @Autowired
    TokenService tokenService;
*/
    @GetMapping("/equipes")
    public Reponse<Equipe[]> getByUsername(){
        Reponse<Equipe[]> valiny=new Reponse<Equipe[]>();
        try{
            Equipe[] liste=Equipe.getListEquipe(null);
            valiny.setData(liste);
        }
        catch(Exception e)
        {
            valiny.setErreur(e.getMessage());
        }
        return valiny;
    }
}   