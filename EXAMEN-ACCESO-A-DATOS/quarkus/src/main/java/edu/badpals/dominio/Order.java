
package edu.badpals.dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ord_id")
    private int id;

    @OneToOne
    @JoinColumn(name = "ord_wizard")
    private Wizards wizard;

    @OneToOne
    @JoinColumn(name = "ord_item")
    private MagicalItem item;

    public Order() {
    }

    public Order(Wizards wizard, MagicalItem item) {
        this.wizard = wizard;
        this.item = item;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Wizards getWizard() {
        return wizard;
    }

    public void setWizard(Wizards wizard) {
        this.wizard = wizard;
    }

    public MagicalItem getItem() {
        return item;
    }

    public void setItem(MagicalItem item) {
        this.item = item;
    }

    @Override
	public String toString() {
		return this.getWizard().getNombre() + " " + this.getItem().getNombre();
	}
}
