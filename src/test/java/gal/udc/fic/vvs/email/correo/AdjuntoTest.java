package gal.udc.fic.vvs.email.correo;

import gal.udc.fic.vvs.email.archivo.Texto;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AdjuntoTest {
	/*Tests constructor for adjunto*/
	@Test
	public void AdjuntoTest() {
		Texto texto = new Texto("valor", "contenido");
		Mensaje mensaje = new Mensaje(texto);
		Adjunto adjunto = new Adjunto(mensaje, texto);
		assertNotNull(adjunto);
	}

	@Test
	public void obtenerTamañoTest() {
		Texto texto = new Texto("valor", "contenido");
		Mensaje mensaje = new Mensaje(texto);
		Adjunto adjunto = new Adjunto(mensaje, texto);
		assertEquals(mensaje.obtenerTamaño() + texto.obtenerTamaño(), adjunto.obtenerTamaño());
	}

	@Test
	public void obtenerVisualizacionTest() {
		Texto texto = new Texto("valor", "contenido");
		Mensaje mensaje = new Mensaje(texto);
		Adjunto adjunto = new Adjunto(mensaje, texto);
		assertEquals(mensaje.obtenerVisualizacion() + "\n\nAdxunto: " + texto.obtenerPreVisualizacion(), adjunto.obtenerVisualizacion());
	}
}