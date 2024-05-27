package edu.badpals.dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_items")
public class MagicalItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    public int id_item;

    @Column(name = "item_name")
    public String nombre = "";

    @Column(name = "item_quality")
    public int quality;

    @Column(name = "item_type")
    public String type = "";
    
}
