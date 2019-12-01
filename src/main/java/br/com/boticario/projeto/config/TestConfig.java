package br.com.boticario.projeto.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.boticario.projeto.entities.Compra;
import br.com.boticario.projeto.entities.Revendedor;
import br.com.boticario.projeto.entities.enums.CompraStatus;
import br.com.boticario.projeto.repositories.CompraRepository;
import br.com.boticario.projeto.repositories.RevendedorRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private RevendedorRepository revendedorRepository;
	
	@Autowired
	private CompraRepository compraRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		
		Revendedor u1 = new Revendedor(null, "Joquina", "12334444555", "joaquina@joaquina.com", "1234");
		Revendedor u2 = new Revendedor(null, "Joquina", "12334444555", "joaquina@joaquina.com", "1234");
		
		revendedorRepository.saveAll(Arrays.asList(u1,u2));
		
		Compra o1 = new Compra(null, "P0009", 123.90, Instant.parse("2019-06-20T19:53:07Z"), CompraStatus.PAID, u1);
		Compra o2 = new Compra(null, "P0008", 190.00,  Instant.parse("2019-07-21T03:42:10Z"), CompraStatus.WAITING_PAYMENT, u2);
		Compra o3 = new Compra(null, "M0001", 30.0, Instant.parse("2019-07-22T15:21:22Z"), CompraStatus.WAITING_PAYMENT, u1);
	
		compraRepository.saveAll(Arrays.asList(o1,o2,o3));
	}

}
