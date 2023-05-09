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

@Getter
@Setter
@Entity
@Table(name = "education")
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "startedIn")
    private String startedIn;

    @Column(name = "finishedIn")
    private String finishedIn;

    @Column(name = "institute")
    private String institute;

    @Column(name = "icon")
    private String icon;
    
    @Column(name = "iconLink")
    private String iconLink;
    
    @Column(name = "educationOrder")
    private Integer educationOrder;

    @ManyToOne
    @JsonIgnore
    private Persona persona;

}
