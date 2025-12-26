package mundia.louki.hospital.web;

import mundia.louki.hospital.entities.Product;
import mundia.louki.hospital.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ProductRestController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public List<Product> products() {
        return productRepository.findAll();
    }

    @GetMapping("/products/{id}")
    public Product findProduct(@PathVariable Long id){
        return productRepository.findById(id).orElse(null);
    }
}