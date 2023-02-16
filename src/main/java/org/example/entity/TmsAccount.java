package org.example.entity;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class TmsAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

}
