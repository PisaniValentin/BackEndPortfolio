package com.miPortfolio.miPortfolio.Model;

import com.miPortfolio.miPortfolio.Repository.PersonaRepository;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
@Table(name = "portfolioUser")
@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "password")
    private String password;
    
    @Column(name = "projectQuantity")
    private Integer projectQuantity;
    
    @Column(name = "titleQuantity")
    private Integer titleQuantity;
    
    @Column(name = "educationQuantity")
    private Integer educationQuantity;
    
    @Column(name = "experience")
    private String experience;
    
    @Column(name = "title")
    @OneToMany(mappedBy = "persona")
    private List<Title> titles;
    
    @Column(name = "project")
    @OneToMany(mappedBy = "persona")
    private List<Project> projects;

    @Column(name = "education")
    @OneToMany(mappedBy = "persona")
    private List<Education> education;
    
    @Column(name = "skill")
    @OneToMany(mappedBy = "persona")
    private List<Skill> skills;

}
