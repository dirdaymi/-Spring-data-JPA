package mundia.louki.hospital.service;

import mundia.louki.hospital.entities.*;
import mundia.louki.hospital.repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {
    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private RendezVousRepository rendezVousRepository;
    private ConsultationRepository consultationRepository;

    // Constructeur pour injection de dépendances
    public HospitalServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }
    // ... implémenter les autres méthodes save ...
    @Override
    public Medecin saveMedecin(Medecin medecin) { return medecinRepository.save(medecin); }
    @Override
    public RendezVous saveRDV(RendezVous rendezVous) {
        // Logique métier possible ici (ex: générer ID unique string si besoin)
        return rendezVousRepository.save(rendezVous);
    }
    @Override
    public Consultation saveConsultation(Consultation consultation) { return consultationRepository.save(consultation); }
}