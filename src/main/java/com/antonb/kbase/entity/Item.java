package com.antonb.kbase.entity;

import lombok.Data;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

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
    private Timestamp lastupdate;
/*
    @ManyToMany
    @JoinTable(
            name = "item_tag",
            schema = "kbase",
            joinColumns = {@JoinColumn(name = "item_id")},
            inverseJoinColumns = {@JoinColumn(name = "tag_id")}
            )
    private List<Tag> tags;*/
}
