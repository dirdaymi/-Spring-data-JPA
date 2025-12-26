package mundia.louki.hospital.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class RendezVous {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;

    @Enumerated(EnumType.STRING) // Stocke le texte "PENDING" au lieu de 0,1,2
    private StatusRDV status;

    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Patient patient;

    @ManyToOne
    private Medecin medecin;

    @OneToOne(mappedBy = "rendezVous")
    private Consultation consultation;
}