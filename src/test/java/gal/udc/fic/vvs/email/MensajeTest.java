package gal.udc.fic.vvs.email;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Correo;
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

	/*Tests obtenerTamanho method of Mensaje*/
	@Test
	public void mensajeObtenerTamanhoTest() {
		String messageContents = "prueba de contenido de mensaje";
		String messageContentsName = "nombre del contenido";
		Mensaje mensaje = new Mensaje(new Texto(messageContentsName, messageContents));
		assertEquals(messageContents.length(), mensaje.obtenerTamaño());
	}

	/*Test icono 1*/
	@Test
	public void mensajeObtenerIconoNoLeidoTest() {
		String messageContents = "prueba de contenido de mensaje";
		String messageContentsName = "nombre del contenido";
		Mensaje mensaje = new Mensaje(new Texto(messageContentsName, messageContents));
		assertEquals(Correo.ICONO_NUEVO_MENSAJE, mensaje.obtenerIcono());
	}

	/*Test icono 2*/
	@Test
	public void mensajeObtenerIconoLeidoTest() {
		String messageContents = "prueba de contenido de mensaje";
		String messageContentsName = "nombre del contenido";
		Mensaje mensaje = new Mensaje(new Texto(messageContentsName, messageContents));
		mensaje.establecerLeido(true);
		assertEquals(Correo.ICONO_MENSAJE, mensaje.obtenerIcono());
	}

	/*Test previsualizacion*/
	@Test
	public void mensajeObtenerPreVisualizacionTest() {
		String messageContents = "prueba de contenido de mensaje";
		String messageContentsName = "nombre del contenido";
		Mensaje mensaje = new Mensaje(new Texto(messageContentsName, messageContents));
		assertEquals(messageContents.substring(0, Math.min(messageContents.length(), 32)) + "...", mensaje.obtenerPreVisualizacion());
	}

	/*test visualizacion*/
	@Test
	public void mensajeObtenerVisualizacion() {
		String messageContents = "prueba de contenido de mensaje";
		String messageContentsName = "nombre del contenido";
		Mensaje mensaje = new Mensaje(new Texto(messageContentsName, messageContents));
		assertEquals(messageContents, mensaje.obtenerVisualizacion());
	}

	/*test buscar*/
	@Test
	public void mensajeBuscarTest() {
		String messageContents = "prueba de contenido de mensaje";
		String messageContentsName = "nombre del contenido";
		Mensaje mensaje = new Mensaje(new Texto(messageContentsName, messageContents));
		assertEquals(mensaje, mensaje.buscar("prueba").toArray()[0]);
	}
}
