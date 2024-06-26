package edu.badpals;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import edu.badpals.dominio.MagicalItem;
import edu.badpals.dominio.Wizards;
import edu.badpals.dominio.Order;
import edu.badpals.dominio.Person;
import edu.badpals.repository.MagicalItemRepository;
import edu.badpals.repository.OrderRepository;
import edu.badpals.repository.WizardsRepository;

@ApplicationScoped
public class ServiceOlli {
    @Inject
    public WizardsRepository wizardsRepo;

    @Inject
    public MagicalItemRepository itemRepo;

    @Inject
    public OrderRepository orderRepo;

    public ServiceOlli() {}
    
    public Wizards cargaWizard(Person string) {
        Optional<Wizards> wizards = wizardsRepo.findByIdOptional(string);
        return wizards.isPresent()? wizards.get(): new Wizards(string, 0, string, string);
    }

    public MagicalItem cargaMagicalItem(String nombre) {
        Optional<MagicalItem> item = itemRepo.findByIdOptional(nombre);
        return item.isPresent()? item.get(): new MagicalItem(0, nombre, 0, nombre);
    }

    public List<Order> cargaOrder(String wizards_nombre) {
        return orderRepo.findByUserName(wizards_nombre);
    }


    public void eliminaWizards(String wizards_nombre) {
        wizardsRepo.deleteById(wizards_nombre);
    }

    public List<Order> orders() {
        return orderRepo.listAll();
    }

    // contenido min eval: if-else
    @Transactional
    public Order comanda(String wizards_nombre, String item_nombre) {
        Order order = null;
        Optional<Wizards> wizards = wizardsRepo.findByIdOptional(wizards_nombre);
        Optional<MagicalItem> item = itemRepo.findByIdOptional(item_nombre);
        if (wizards.isPresent() && item.isPresent() 
            && wizards.get().getDexterity() >= item.get().getQuality()) {
            order = new Order(wizards.get(), item.get());
            orderRepo.persist(order);
        }
        return order;
    }

    // contenido min eval: loop, if-else, colecciones
    @Transactional
    public List<Order> comandaMultiple(String wizards, List<String> productos) {

        Optional<Wizards> wiz = wizardsRepo.findByIdOptional(wizards);
        if (wiz.isEmpty()) {
            return Collections.emptyList();
        }
        
        List<Order> orders = new ArrayList<Order>();

        Order order = null;
        for (String producto: productos) {
            order = this.comanda(wiz.get().getNombre(), producto);
            if (order != null) {
                orders.add(order);
            }
        }
        return orders;      
    }
}
