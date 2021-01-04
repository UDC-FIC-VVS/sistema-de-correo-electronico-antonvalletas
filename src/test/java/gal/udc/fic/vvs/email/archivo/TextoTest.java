package gal.udc.fic.vvs.email.archivo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TextoTest {
	String textName = "texto1";
	String textContents = "test text";


	@Test
	public void textoTest() {
		Texto texto = new Texto(textName, textContents);
		assertNotNull(texto);
	}

	@Test
	public void obtenerNombreTest() {
		Texto texto = new Texto(textName, textContents);
		assertEquals(textName, texto.obtenerNombre());
	}

	@Test
	public void obtenerMimeTypeTest() {
		Texto texto = new Texto(textName, textContents);
		assertEquals("text/plain", texto.obtenerMimeType());
	}
}