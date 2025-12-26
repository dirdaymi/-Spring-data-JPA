package mundia.louki.hospital.repositories;

import mundia.louki.hospital.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {
    Medecin findByNom(String nom);
}