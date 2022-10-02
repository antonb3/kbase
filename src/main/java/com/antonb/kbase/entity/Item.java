package com.antonb.kbase.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(schema = "kbase",name="item")
@Data
public class Item {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String text;
}
