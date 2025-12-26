package mundia.louki.hospital.repositories;

import mundia.louki.hospital.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // Spring génère le SQL automatiquement grâce au nom de la méthode
    List<Product> findByNameContains(String mc);

    // Requête personnalisée (HQL)
    @Query("select p from Product p where p.price > :price")
    List<Product> searchByPrice(@Param("price") double price);
}
