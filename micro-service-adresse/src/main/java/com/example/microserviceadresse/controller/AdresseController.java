package com.example.microserviceadresse.controller;

import com.example.microserviceadresse.dao.AdresseRepository;
import com.example.microserviceadresse.model.Adresse;
import com.example.microserviceadresse.restclient.PersonneRestClient;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class AdresseController {
    private AdresseRepository adresseRepository;
    private PersonneRestClient personneRestClient;

    @GetMapping("/adresses")
    public List<Adresse> getAdresses(){
        var adresses= adresseRepository.findAll();
        for(Adresse a : adresses){
            a.setPersonne(personneRestClient.getPersonne(a.getIdPersonne()));
        }
        return adresses;
    }
    @GetMapping("/adresses/{id}")
    public Adresse getAdresses(@PathVariable long id){
        Adresse adresse= adresseRepository.findById(id).orElse(null);
       adresse.setPersonne(personneRestClient.getPersonne(adresse.getIdPersonne()));
        return adresse;
    }
    @PostMapping("/adresses")
    public Adresse addAdresse(@RequestBody Adresse adresse){
        return adresseRepository.save(adresse);
    }
}
