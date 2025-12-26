package mundia.louki.hospital;

import mundia.louki.hospital.entities.*;
import mundia.louki.hospital.repositories.*;
import mundia.louki.hospital.service.IHospitalService;
import mundia.louki.hospital.service.IUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalApplication.class, args);
	}

	// Phase 1 : Test Produit
	@Bean
	CommandLineRunner start(ProductRepository productRepository) {
		return args -> {
			productRepository.save(new Product(null, "Computer", 7600, 34));
			productRepository.save(new Product(null, "Printer", 1600, 134));
			productRepository.save(new Product(null, "Smartphone", 1600, 34));
			productRepository.findAll().forEach(p -> {
				System.out.println(p.getName());
			});
		};
	}

	// Phase 2 : Test Hopital
	@Bean
	CommandLineRunner startHospital(IHospitalService hospitalService,
									PatientRepository patientRepository,
									RendezVousRepository rendezVousRepository,
									MedecinRepository medecinRepository) {
		return args -> {
			Stream.of("Mohamed", "Hassan", "Najat").forEach(name -> {
				Patient patient = new Patient();
				patient.setNom(name);
				patient.setDateNaissance(new Date());
				patient.setMalade(false);
				hospitalService.savePatient(patient);
			});

			Stream.of("Aymane", "Hanane", "Yassine").forEach(name -> {
				Medecin medecin = new Medecin();
				medecin.setNom(name);
				medecin.setEmail(name + "@gmail.com");
				medecin.setSpecialite(Math.random() > 0.5 ? "Cardio" : "Dentiste");
				hospitalService.saveMedecin(medecin);
			});

			Patient patient = patientRepository.findByNom("Mohamed");
			Medecin medecin = medecinRepository.findByNom("Aymane");

			RendezVous rendezVous = new RendezVous();
			rendezVous.setDate(new Date());
			rendezVous.setStatus(StatusRDV.PENDING);
			rendezVous.setPatient(patient);
			rendezVous.setMedecin(medecin);
			hospitalService.saveRDV(rendezVous); // Correction: utiliser le service

			RendezVous rdv1 = rendezVousRepository.findAll().get(0);
			Consultation consultation = new Consultation();
			consultation.setDateConsultation(new Date());
			consultation.setRendezVous(rdv1);
			consultation.setRapport("Rapport de la consultation...");
			hospitalService.saveConsultation(consultation);
		};
	}

	// Phase 3 : Test Users
	@Bean
	CommandLineRunner startUsers(IUserService userService) {
		return args -> {
			User u = new User();
			u.setUsername("user1");
			u.setPassword("123456");
			userService.addNewUser(u);

			User u2 = new User();
			u2.setUsername("admin");
			u2.setPassword("123456");
			userService.addNewUser(u2);

			Stream.of("STUDENT", "USER", "ADMIN").forEach(r -> {
				Role role1 = new Role();
				role1.setRoleName(r);
				userService.addNewRole(role1);
			});

			userService.addRoleToUser("user1", "STUDENT");
			userService.addRoleToUser("user1", "USER");
			userService.addRoleToUser("admin", "USER");
			userService.addRoleToUser("admin", "ADMIN");

			try {
				User user = userService.findUserByUserName("user1");
				System.out.println("Roles de user1:");
				user.getRoles().forEach(r -> System.out.println(r.getRoleName()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		};
	}
}
