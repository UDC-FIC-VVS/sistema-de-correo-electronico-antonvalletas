package gal.udc.fic.vvs.email.archivo;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(JUnitQuickcheck.class)
public class TextoPBTTest {

	@Property
	public void textoTest(String textName, String textContents) {
		Texto texto = new Texto(textName, textContents);
		assertNotNull(texto);
	}

	@Property
	public void obtenerNombreTest(String textName, String textContents) {
		Texto texto = new Texto(textName, textContents);
		assertEquals(textName, texto.obtenerNombre());
	}

	@Property
	public void obtenerContenidoTest(String textName, String textContents) {
		Texto texto = new Texto(textName, textContents);
		assertEquals(textContents, texto.obtenerContenido());
	}

	@Property
	public void obtenerPrevisualizacionTest(String textName, String textContents) {
		Texto texto = new Texto(textName, textContents);
		assertEquals(textName + "(" + texto.obtenerTamaño() + " bytes, " + texto.obtenerMimeType() + ")", texto.obtenerPreVisualizacion());
	}

}
