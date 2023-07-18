package com.cursojava.curso.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="usuarios")

public class usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id")
    private Long id;

    @Getter @Setter @Column(name = "nombre")
    private String nombre;

    @Getter @Setter @Column(name = "apellido")
    private String Apellido;

    @Getter @Setter @Column(name = "email")
    private String Email;

    @Getter @Setter @Column(name = "telefono")
    private String Telefono;

    @Getter @Setter @Column(name = "password")
    private String password;


}
