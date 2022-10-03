package com.antonb.kbase.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(schema = "kbase",name="item_tag")
@Data
public class ItemTag {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Item item;
    @JoinColumn(name = "tag_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Tag tag;
}
