package com.librarian;

import com.librarian.model.User;
import com.librarian.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.UUID;

@SpringBootApplication
@EntityScan("com.librarian.model")
public class LibrarianApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibrarianApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		return (args) -> {
			User user =
					userRepository.save(
							new User("zuza", passwordEncoder.encode("a")));
//			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//			Date date = new Date();
//			LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//			Reservation reservation =
//					Reservation.builder()
//							.reservationDate(localDate)
//							.startTime(LocalTime.of(12, 00))
//							.endTime(LocalTime.of(13, 00))
//							.user(user)
//							.amenityType(AmenityType.POOL)
//							.build();

//			reservationRepository.save(reservation);
		};
	}

}
