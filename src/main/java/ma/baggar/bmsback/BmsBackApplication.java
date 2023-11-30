package ma.baggar.bmsback;

import ma.baggar.bmsback.Entity.*;
import ma.baggar.bmsback.Repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.Optional;

@SpringBootApplication
public class BmsBackApplication {
	@Autowired
ClientRepository clientRepository;
	@Autowired
	ModePaymentRepository modePaymentRepository;
	@Autowired
	AgenceRepository agenceRepository;
	@Autowired
	ArticleRepository articleRepository;
	@Autowired
	TvaRepository tvaRepository;
	public static void main(String[] args) {
		SpringApplication.run(BmsBackApplication.class, args);
	}
@Bean
	public ModelMapper modelMapper(){
		return  new ModelMapper();
}

}
