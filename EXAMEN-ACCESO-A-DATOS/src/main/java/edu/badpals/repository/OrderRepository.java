package edu.badpals.repository;
import java.util.List;
import java.util.stream.Collectors;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import edu.badpals.dominio.Order;
public class OrderRepository implements PanacheRepository<Order> {
    public List<Order> findByUserName(String wizard_nombre) {
        List<Order> orders = this.listAll()
										.stream()
										.filter(o -> o.getWizard().getNombre().equalsIgnoreCase(wizard_nombre))
										.collect(Collectors.toList());
		return orders.isEmpty()? List.of(): orders;
    }
}

