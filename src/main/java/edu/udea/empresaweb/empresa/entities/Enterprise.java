package edu.udea.empresaweb.empresa.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "Enterprise")
public class Enterprise {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "document")
    private String document;
    
    @Column(name = "phone")
    private String phone;
    
    @Column(name = "address")
    private String address;
    
    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<Employee> users;
    
    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List <Transaction> transactions;
    
    @Column(name = "createdAt")
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdAt;
    
    @Column(name = "updatedAt")
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate updatedAt;

}
