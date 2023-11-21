package Nbaws.NbaWs.controller;

import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("apiJoueur")
@RestController
public class JoueurController {
    /* 
    @Autowired
    UserService userService;
    
    @Autowired
    TokenService tokenService;

    @GetMapping("/getName/{username}")
    public Reponse<User> getByUsername(@PathVariable String username,HttpServletRequest request){
        Reponse<User> valiny=new Reponse<User>();
        try{
            if(tokenService.verifieConnection(request))
            {
                List<User> user=userService.findByUserName(username);
                valiny.setData(user.get(0));
            }else{
                throw new Exception("Vous ne pouvez pas acceder a cette ressource car vous n'etes pas connecte");
            }
        }
        catch(Exception e)
        {
            valiny.setErreur(e.getMessage());
        }
        return valiny;
    }*/
}   