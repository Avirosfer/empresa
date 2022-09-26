package edu.udea.empresaweb.empresa.entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table

public class User {
    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;

    @Column(name = "email")
    private String email;

    @Column(name = "image")
    private String image;

    @Column(name = "nickname")
    private String nickname;

    public User() {
    }

    public User(String email, String image, String nickname) {
    }

}
