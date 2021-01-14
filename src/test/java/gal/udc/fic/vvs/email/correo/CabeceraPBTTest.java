package gal.udc.fic.vvs.email.correo;


import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import gal.udc.fic.vvs.email.archivo.Texto;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(JUnitQuickcheck.class)
public class CabeceraPBTTest {

	@Property
	public void cabeceraTest(String nombre, String contenido) {
		Texto texto = new Texto(nombre, contenido);
		Mensaje mensaje = new Mensaje(texto);
		Cabecera cabecera = new Cabecera(mensaje, nombre, contenido);
		assertNotNull(cabecera);
	}

	@Property
	public void obtenerTamañoTest(String nombre, String contenido) {
		Texto texto = new Texto(nombre, contenido);
		Mensaje mensaje = new Mensaje(texto);
		Cabecera cabecera = new Cabecera(mensaje, nombre, contenido);
		assertEquals(contenido.length() + nombre.length() + contenido.length(), cabecera.obtenerTamaño());
	}

	@Property
	public void obtenerPrevisualizacionTest(String nombre, String contenido) {
		Texto texto = new Texto(nombre, contenido);
		Mensaje mensaje = new Mensaje(texto);
		Cabecera cabecera = new Cabecera(mensaje, nombre, contenido);
		assertEquals(nombre + ": " + contenido + "\n" + mensaje.obtenerVisualizacion(), cabecera.obtenerVisualizacion());
	}
}
