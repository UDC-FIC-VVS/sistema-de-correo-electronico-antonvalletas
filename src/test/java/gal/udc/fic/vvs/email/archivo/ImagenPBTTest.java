package gal.udc.fic.vvs.email.archivo;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(JUnitQuickcheck.class)
public class ImagenPBTTest {

	@Property
	public void imagenTest(String imageName, String imageContents) {
		Imagen imagen = new Imagen(imageName, imageContents);
		assertEquals(imageName, imagen.obtenerNombre());
		assertEquals(imageContents, imagen.obtenerContenido());
		assertNotNull(imagen);
	}
}
