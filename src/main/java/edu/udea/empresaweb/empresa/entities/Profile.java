package edu.udea.empresaweb.empresa.entities;

import javax.persistence.*;

import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "Profile")
public class Profile {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    
    @Column(name = "image")
    private String image;
    
    @Column(name = "phone", nullable = false)
    private String phone;
    
    @Column(name = "createdAt")
    private LocalDate createdAt;
    
    @Column(name = "updatedAt")
    private LocalDate updateAt;
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Employee employee;

    
   
}
