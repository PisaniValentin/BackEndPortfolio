
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

@Setter
@Getter
@Table(name = "title")
@Entity
public class Title {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "titleName")
    private String titleName;
    
    @Column(name="titleOrder")
    private Integer titleOrder;
    
    @ManyToOne
    @JsonIgnore
    private Persona persona;
    
}
