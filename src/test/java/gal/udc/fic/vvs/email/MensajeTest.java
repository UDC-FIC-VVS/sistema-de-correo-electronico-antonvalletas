package gal.udc.fic.vvs.email;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Mensaje;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Unit test for simple App.
 */
public class MensajeTest {
	/* Tests the construction of a Mensaje with some content*/
	@Test
	public void mensajeCreationTest() {
		String messageContents = "prueba de contenido de mensaje";
		String messageContentsName = "nombre del contenido";
		Mensaje mensaje = new Mensaje(new Texto(messageContentsName, messageContents));
		assertNotNull(mensaje.obtenerVisualizacion());
	}

	/*Tests getting the read status of a message*/
	@Test
	public void mensajeNoLeidoTest() {
		String messageContents = "prueba de contenido de mensaje";
		String messageContentsName = "nombre del contenido";
		Mensaje mensaje = new Mensaje(new Texto(messageContentsName, messageContents));
		assertEquals(1, mensaje.obtenerNoLeidos());
	}

	/*Tests getting the read status of a message*/
	@Test
	public void mensajeLeidoTest() {
		String messageContents = "prueba de contenido de mensaje";
		String messageContentsName = "nombre del contenido";
		Mensaje mensaje = new Mensaje(new Texto(messageContentsName, messageContents));
		mensaje.establecerLeido(true);
		assertEquals(0, mensaje.obtenerNoLeidos());

	}
}
