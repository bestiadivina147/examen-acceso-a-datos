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
    public Enum person = MUGGLE, SQUIB, NOMAJ, MUDBLOOD;

    public Enum getSQUIB() {
        return SQUIB;
    }

    public void setSQUIB(Enum sQUIB) {
        SQUIB = sQUIB;
    }

    public Enum getNOMAJ() {
        return NOMAJ;
    }

    public void setNOMAJ(Enum nOMAJ) {
        NOMAJ = nOMAJ;
    }

    public Enum getMUDBLOOD() {
        return MUDBLOOD;
    }

    public void setMUDBLOOD(Enum mUDBLOOD) {
        MUDBLOOD = mUDBLOOD;
    }

    @Column(name = "item_type")
    public String type = "";

    public Wizards(String nombre, int dexterity, String person, String type) {
        this.nombre = nombre;
        this.dexterity = dexterity;
        this.person = person;
        this.type = type;
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

    
    public Enum getPerson() {
        return person;
    }

    public void setPerson(Enum person) {
        this.person = person;
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
