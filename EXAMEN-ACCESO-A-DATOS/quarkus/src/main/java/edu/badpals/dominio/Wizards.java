package edu.badpals.dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_wizards")
public class Wizards {
    @Id
    @Column(name = "wizard_name")
    public String nombre = "";

    @Column(name = "wizard_dexterity")
    public int dexterity;

    @Column(name = "wizard_person")
    public String person = "";

    @Column(name = "item_type")
    public String type = "";

    public Wizards(String nombre, int dexterity, String person, String type) {
        this.nombre = nombre;
        this.dexterity = dexterity;
        this.person = person;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Wizards [nombre=" + this.nombre + ", dexterity=" + this.dexterity + ", person=" + this.person + ", type=" + this.type + "]";
    }
    
}
