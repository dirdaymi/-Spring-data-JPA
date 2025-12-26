package mundia.louki.hospital.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // C'est une table en BDD
@Data @NoArgsConstructor @AllArgsConstructor @Builder // Lombok génère le code
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incrément
    private Long id;
    private String name;
    private double price;
    private int quantity;
}