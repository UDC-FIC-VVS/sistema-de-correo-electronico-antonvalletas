package gal.udc.fic.vvs.email.correo;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import gal.udc.fic.vvs.email.archivo.Texto;
import org.junit.runner.RunWith;

import java.util.Collection;
import java.util.Vector;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(JUnitQuickcheck.class)
public class AdjuntoPBTTest {

	@Property
	public void adjuntoTest(String nombre, String contenido) {
		Texto texto = new Texto(nombre, contenido);
		Mensaje mensaje = new Mensaje(texto);
		Adjunto adjunto = new Adjunto(mensaje, texto);
		assertNotNull(adjunto);
	}

	@Property
	public void previsualizacionTest(String nombre, String contenido) {
		Texto texto = new Texto(nombre, contenido);
		Mensaje mensaje = new Mensaje(texto);
		Adjunto adjunto = new Adjunto(mensaje, texto);
		assertEquals(mensaje.obtenerPreVisualizacion(), adjunto.obtenerPreVisualizacion());
	}

	@Property
	public void rutaTest(String nombre, String contenido) {
		Texto texto = new Texto(nombre, contenido);
		Mensaje mensaje = new Mensaje(texto);
		Adjunto adjunto = new Adjunto(mensaje, texto);
		assertEquals(mensaje.obtenerRuta(), adjunto.obtenerRuta());
	}

	@Property
	public void buscarTest(String nombre, String contenido) {
		Texto texto = new Texto(nombre, contenido);
		Mensaje mensaje = new Mensaje(texto);
		Adjunto adjunto = new Adjunto(mensaje, texto);
		Collection ans = new Vector();
		ans.add(adjunto);
		assertEquals(ans, adjunto.buscar(contenido));
	}

	@Property
	public void obtenerTamañoTest(String nombre, String contenido) {
		Texto texto = new Texto(nombre, contenido);
		Mensaje mensaje = new Mensaje(texto);
		Adjunto adjunto = new Adjunto(mensaje, texto);
		assertEquals(mensaje.obtenerTamaño() + texto.obtenerTamaño(), adjunto.obtenerTamaño());
	}

	@Property
	public void obtenerPrevisualizacionTest(String nombre, String contenido) {
		Texto texto = new Texto(nombre, contenido);
		Mensaje mensaje = new Mensaje(texto);
		Adjunto adjunto = new Adjunto(mensaje, texto);
		assertEquals(mensaje.obtenerVisualizacion() + "\n\nAdxunto: " + texto.obtenerPreVisualizacion(), adjunto.obtenerVisualizacion());
	}
}
