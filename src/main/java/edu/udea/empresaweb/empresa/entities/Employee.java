package edu.udea.empresaweb.empresa.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
//import java.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "Employee")
public class Employee {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    //@NotNull(message = "Debe ingresar un email")
    @Column(name = "email", length = 50, unique = true, nullable = false)
    private String email;
    
    @OneToOne(optional = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "employee")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "Idprofile")
    private Profile profile;
    
    //@NotNull(message = "El rol del empleado puede ser Admin u operario")
    @Column(name = "role")
    private Enum_RoleName role;
    
    @Column(name = "createdAt")
    private LocalDate createdAt;
    
    @Column(name = "updatedAt")
    private LocalDate updateAt;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "id_enterprise")
    private Enterprise enterprise;

    /*@OneToMany(mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<Transaction> transactions;

     */

   

    
}
