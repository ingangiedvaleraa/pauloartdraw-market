package com.panda.pauloartdraw.market;

import com.panda.pauloartdraw.market.domain.dto.ClientDto;
import com.panda.pauloartdraw.market.persistence.ClientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.Assert;

@SpringBootTest
class PauloartdrawMarketApplicationTests {

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Test
	public void createUserTest() {
		ClientDto us = new ClientDto();
		us.setId("123456");
		us.setFirstname("adminTest");
		us.setPassword(encoder.encode("admin"));
		us.setEmail("admin@admin.co");
		us.setRolId(1);
		ClientDto retorno = clientRepository.save(us);

		Assert.isTrue(retorno.getPassword().equalsIgnoreCase(us.getPassword()));
	}

}
