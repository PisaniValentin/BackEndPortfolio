package com.miPortfolio.miPortfolio.Repository;

import com.miPortfolio.miPortfolio.Model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonaRepository extends JpaRepository<Persona,Integer>{
    Persona findByUsername(String username);
    Persona findByUsernameAndPassword(String username,String password);
}
