package mundia.louki.hospital.repositories;

import mundia.louki.hospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByNom(String name); // Méthode de recherche par nom
}