package com.miPortfolio.miPortfolio.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Table(name="project")
@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    
    @Column(name="url")
    private String url;
    
    @Column(name="projectOrder")
    private Integer projectOrder;
    
    @Column(name="name")
    private String name;
    
    @Column(name="description")
    private String description;
    
    @ManyToOne
    @JsonIgnore
    private Persona persona;
    
}
