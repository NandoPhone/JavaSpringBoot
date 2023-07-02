package com.cursojava.curso.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="usuarios")

public class usuario {

    @Id
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
    private String Pass;


}
