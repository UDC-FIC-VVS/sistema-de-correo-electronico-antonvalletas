package gal.udc.fic.vvs.email.correo;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class OperacionInvalidaTest {

	@Test
	public void operacionInvalidaTest1() {
		OperacionInvalida operacionInvalida = new OperacionInvalida();
		assertNotNull(operacionInvalida);
	}

	@Test
	public void operacionInvalidaTest2() {
		OperacionInvalida operacionInvalida = new OperacionInvalida("Error en la operacion");
		assertNotNull(operacionInvalida);
	}

}