package gal.udc.fic.vvs.email.archivo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ImagenTest {
	String imageName = "imagen1";
	String imageContents = "aef13faef13aef";

	@Test
	public void imagenTest() {
		Imagen imagen = new Imagen(imageName, imageContents);
		assertNotNull(imagen);
	}

	@Test
	public void obtenerMimeTypeTest() {
		Imagen imagen = new Imagen(imageName, imageContents);
		assertEquals("image/png", imagen.obtenerMimeType());
	}
}