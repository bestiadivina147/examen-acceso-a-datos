package edu.badpals.dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import edu.badpals.dominio.Person;

@Entity
@Table(name = "t_wizards")
public class Wizards {
    private  Enum MUGGLE;

    @Id
    @Column(name = "wizard_name")
    public String nombre = "";

    @Column(name = "wizard_dexterity")
    public int dexterity;

    @Column(name = "wizard_person")
    public Person person = Person.valueOf(nombre);

    

    @Column(name = "item_type")
    public String type = "";

    public Wizards(String nombre, int dexterity, Person nombre2, String type) {
        this.nombre = nombre;
        this.dexterity = dexterity;
        this.person = nombre2;
        this.type = type;
    }

    

    public Wizards(Person nombre2, int dexterity2, Person nombre3, Person nombre4) {
        //TODO Auto-generated constructor stub
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Wizards [nombre=" + this.nombre + ", dexterity=" + this.dexterity + ", person=" + this.person + ", type=" + this.type + "]";
    }

    
}
