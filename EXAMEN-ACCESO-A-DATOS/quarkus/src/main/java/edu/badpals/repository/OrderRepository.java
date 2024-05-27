
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import edu.badpals.dominio.Order;
public class OrderRepository implements PanacheRepository<Order> {
    public List<Order> findByUserName(String usuaria_nombre) {
        List<Order> ordenes = this.listAll()
										.stream()
										.filter(o -> o.getUser().getNombre().equalsIgnoreCase(usuaria_nombre))
										.collect(Collectors.toList());
		return ordenes.isEmpty()? List.of(): ordenes;
    }
}

