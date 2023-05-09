package com.miPortfolio.miPortfolio.Service;

import com.miPortfolio.miPortfolio.Model.Persona;
import com.miPortfolio.miPortfolio.Repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PersonaService implements IPersonaService {

    @Autowired
    public PersonaRepository personaRepo;

    @Override
    public void addUser(Persona per) {
        personaRepo.save(per);
    }

    @Override
    public void deleteUser(Integer id) {
        personaRepo.deleteById(id);
    }

    @Override
    public Persona find(Integer id) {
        return (personaRepo.findById(id).get());
    }

    @Override
    public Persona login(@RequestBody Persona user) {
        return (personaRepo.findByUsernameAndPassword(user.getUsername(), user.getPassword()));
    }

   
    
}
