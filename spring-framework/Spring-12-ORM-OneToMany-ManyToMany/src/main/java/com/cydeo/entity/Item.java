package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String code;

    //join portion manytomany--< we need helper table
    @ManyToMany(mappedBy = "items")
    private List<Cart> carts;


    public Item(String name, String code) {
        this.name = name;
        this.code = code;
    }
}
