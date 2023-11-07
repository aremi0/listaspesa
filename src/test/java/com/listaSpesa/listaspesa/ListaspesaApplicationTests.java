package com.listaSpesa.listaspesa;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.SpringVersion;

@SpringBootTest
class ListaspesaApplicationTests {

	@Test
	void contextLoads() {
		System.out.println(SpringVersion.getVersion());
	}

}
