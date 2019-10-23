package com.wildcodeschool.submarine.springHibernateSubmarine.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "submarine" )
public class Submarine {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long   id;

    private String name;
    private String type;

    public Submarine() {

    }

    public Submarine( String name, String type ) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Sous-marins nucléaire français lanceur d'engins (SNLE) "
                + "[id=" + id + ", nom=" + name +
                ", classe=" + type + "]";
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType( String type ) {
        this.type = type;
    }

}
