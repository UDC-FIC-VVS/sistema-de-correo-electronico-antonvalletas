package gal.udc.fic.vvs.email.correo;

import gal.udc.fic.vvs.email.archivo.Texto;
import org.junit.Test;

import java.util.Collection;
import java.util.Vector;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AdjuntoTest {

	Texto texto = new Texto("valor", "contenido");
	Mensaje mensaje = new Mensaje(texto);

	/*Tests constructor for adjunto*/
	@Test
	public void adjuntoTest() {
		Adjunto adjunto = new Adjunto(mensaje, texto);
		assertNotNull(adjunto);
	}

	@Test
	public void leidoTest() {
		Adjunto adjunto = new Adjunto(mensaje, texto);
		adjunto.establecerLeido(true);
		assertEquals(0, adjunto.obtenerNoLeidos());
	}

	@Test
	public void iconoTest() {
		Adjunto adjunto = new Adjunto(mensaje, texto);
		assertEquals(mensaje.obtenerIcono(), adjunto.obtenerIcono());
	}

	@Test
	public void previsualizacionTest() {
		Adjunto adjunto = new Adjunto(mensaje, texto);
		assertEquals(mensaje.obtenerPreVisualizacion(), adjunto.obtenerPreVisualizacion());
	}

	@Test
	public void rutaTest() {
		Adjunto adjunto = new Adjunto(mensaje, texto);
		assertEquals(mensaje.obtenerRuta(), adjunto.obtenerRuta());
	}

	@Test(expected = OperacionInvalida.class)
	public void explorarTest() throws OperacionInvalida {
		Adjunto adjunto = new Adjunto(mensaje, texto);
		adjunto.explorar();
	}

	@Test
	public void buscarTest() {
		Adjunto adjunto = new Adjunto(mensaje, texto);
		Collection ans = new Vector();
		ans.add(adjunto);
		assertEquals(ans, adjunto.buscar("contenido"));
	}

	@Test(expected = OperacionInvalida.class)
	public void añadirTest() throws OperacionInvalida {
		Adjunto adjunto = new Adjunto(mensaje, texto);
		adjunto.añadir(mensaje);
	}

	@Test(expected = OperacionInvalida.class)
	public void eliminarTest() throws OperacionInvalida {
		Adjunto adjunto = new Adjunto(mensaje, texto);
		adjunto.eliminar(mensaje);
	}

	@Test(expected = OperacionInvalida.class)
	public void obtenerHijoTest() throws OperacionInvalida {
		Adjunto adjunto = new Adjunto(mensaje, texto);
		adjunto.obtenerHijo(0);
	}

	@Test
	public void padreTest() {
		Adjunto adjunto = new Adjunto(mensaje, texto);
		Mensaje mensaje2 = new Mensaje(texto);
		adjunto.establecerPadre(mensaje2);
		assertEquals(mensaje2, adjunto.obtenerPadre());
	}

	@Test
	public void obtenerTamañoTest() {
		Adjunto adjunto = new Adjunto(mensaje, texto);
		assertEquals(mensaje.obtenerTamaño() + texto.obtenerTamaño(), adjunto.obtenerTamaño());
	}

	@Test
	public void obtenerVisualizacionTest() {
		Adjunto adjunto = new Adjunto(mensaje, texto);
		assertEquals(mensaje.obtenerVisualizacion() + "\n\nAdxunto: " + texto.obtenerPreVisualizacion(), adjunto.obtenerVisualizacion());
	}
}