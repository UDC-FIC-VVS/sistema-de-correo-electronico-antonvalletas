package gal.udc.fic.vvs.email.correo;

import gal.udc.fic.vvs.email.archivo.Texto;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ReenvioTest {

	Texto texto = new Texto("valor", "contenido");
	Mensaje mensaje = new Mensaje(texto);

	@Test
	public void reenvioConstructTest() {
		Reenvio reenvio = new Reenvio(mensaje, mensaje);

		assertNotNull(reenvio);
	}

	@Test
	public void obtenerTamañoTest() {
		Reenvio reenvio = new Reenvio(mensaje, mensaje);

		assertEquals(mensaje.obtenerTamaño() + mensaje.obtenerTamaño(), reenvio.obtenerTamaño());
	}

	@Test
	public void obtenerVisualizacionTest() {
		Reenvio reenvio = new Reenvio(mensaje, mensaje);
		assertEquals(mensaje.obtenerVisualizacion() + "\n\n---- Correo reenviado ----\n\n" + mensaje.obtenerVisualizacion() + "\n---- Fin correo reenviado ----", reenvio.obtenerVisualizacion());

	}
}