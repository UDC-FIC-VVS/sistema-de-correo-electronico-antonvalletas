package gal.udc.fic.vvs.email.correo;

import gal.udc.fic.vvs.email.archivo.Texto;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CabeceraTest {

	/*tests the constructor for cabecera*/
	@Test
	public void cabeceraTest() {
		Texto texto = new Texto("contenido", "contenido");
		Mensaje mensaje = new Mensaje(texto);
		Cabecera cabecera = new Cabecera(mensaje, "nombre", "valor");
		assertNotNull(cabecera);
	}

	/*tests the obtenerTamanho method from the Cabecera class*/
	@Test
	public void obtenerTamañoTest() {
		Cabecera cabecera = new Cabecera(new Mensaje(new Texto("contenido", "contenido")), "nombre", "valor");
		//Super.obtenerTamanho no tiene valor?
		assertEquals("contenido".length() + "nombre".length() + "valor".length(), cabecera.obtenerTamaño());
	}

	/*tests the obtener tamanho method from the cabecera class*/
	@Test
	public void obtenerVisualizacionTest() {
		Texto texto = new Texto("contenido", "contenido");
		Mensaje mensaje = new Mensaje(texto);
		Cabecera cabecera = new Cabecera(mensaje, "nombre", "valor");
		assertEquals("nombre" + ": " + "valor" + "\n" + mensaje.obtenerVisualizacion(), cabecera.obtenerVisualizacion());
	}
}