package com.practica.aws.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Table(name= "productos")
@Data 
@NoArgsConstructor 
@AllArgsConstructor 
public class Product {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private String nombre;

    private String descripcion;

    @Column (nullable = false)
    private Double precio;

    @Column (nullable = false)
    private Integer stock;

    private Boolean activo = true;

}
