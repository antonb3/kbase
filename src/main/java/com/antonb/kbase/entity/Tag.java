package com.antonb.kbase.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(schema = "kbase",name="tag")
@Data
public class Tag {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tag;
}
