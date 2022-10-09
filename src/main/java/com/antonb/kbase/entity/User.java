package com.antonb.kbase.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(schema = "kbase",name="user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
}
