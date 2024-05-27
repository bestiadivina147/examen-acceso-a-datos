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
    
    public int getId_item() {
        return id_item;
    }

    public void setId_item(int id_item) {
        this.id_item = id_item;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public MagicalItem(int id_item, String nombre, int quality, String type) {
        this.id_item = id_item;
        this.nombre = nombre;
        this.quality = quality;
        this.type = type;
    }

    @Override
   public String toString() {
        return this.id_item + ", " + this.nombre + ", " + this.quality + ", " + this.type;
    }

}
