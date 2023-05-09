package com.miPortfolio.miPortfolio.Service;

import com.miPortfolio.miPortfolio.Model.Persona;
import com.miPortfolio.miPortfolio.Model.Project;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.RequestBody;


public interface IPersonaService {
    public void addUser(Persona per);
    public void deleteUser(Integer id);
    public Persona find(Integer id);
    public Persona login(@RequestBody Persona user);
}
