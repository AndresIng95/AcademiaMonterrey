package com.luv2code.springboot.cruddemo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "teams")
public class Team {

    // define fields
    //
    // El id es String, no int: MongoDB genera un ObjectId (hexadecimal de 24
    // caracteres). No lleva @GeneratedValue — el driver lo asigna al insertar.
    @Id
    private String id;

    // Sin @Column: MongoDB no tiene esquema, así que el campo del documento se
    // llama igual que la propiedad Java. No hay nada que mapear.
    private String name;

    private String city;

    private String sport;


    // define constructors
    public Team() {

    }

    public Team(String name, String city, String sport) {
        this.name = name;
        this.city = city;
        this.sport = sport;
    }

    // define getter/setter

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    // define toString
    @Override
    public String toString() {
        return "Team{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", sport='" + sport + '\'' +
                '}';
    }
}
