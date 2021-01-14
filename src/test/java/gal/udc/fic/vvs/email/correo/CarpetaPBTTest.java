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
public class CarpetaPBTTest {

	@Property
	public void carpetaTest(String nombre) {
		Carpeta carpeta = new Carpeta(nombre);
		assertNotNull(carpeta);
	}

	@Property
	public void establecerLeidoTest(String nombre, String contenido) {
		Texto texto = new Texto(nombre, contenido);
		Mensaje mensaje = new Mensaje(texto);
		Carpeta carpeta = new Carpeta(nombre);
		try {
			carpeta.añadir(mensaje);
		} catch (OperacionInvalida e) {
			e.printStackTrace();
		}
		carpeta.establecerLeido(true);
		assertEquals(0, carpeta.obtenerNoLeidos());
	}

	@Property
	public void obtenerTamañoTest(String nombre, String contenido) {
		Texto texto = new Texto(nombre, contenido);
		Mensaje mensaje = new Mensaje(texto);
		Carpeta carpeta = new Carpeta(nombre);
		try {
			carpeta.añadir(mensaje);
		} catch (OperacionInvalida e) {
			e.printStackTrace();
		}
		assertEquals(mensaje.obtenerTamaño(), carpeta.obtenerTamaño());
	}

	@Property
	public void obtenerPrevisualizacioNTest(String nombre, String contenido) {
		Texto texto = new Texto(nombre, contenido);
		Mensaje mensaje = new Mensaje(texto);
		Carpeta carpeta = new Carpeta(nombre);
		try {
			carpeta.añadir(mensaje);
		} catch (OperacionInvalida e) {
			e.printStackTrace();
		}
		assertEquals(nombre + " (" + "1" + ")", carpeta.obtenerPreVisualizacion());
	}

	@Property
	public void obtenerVisualizacionTest(String nombre, String contenido) {
		Texto texto = new Texto(nombre, contenido);
		Mensaje mensaje = new Mensaje(texto);
		Carpeta carpeta = new Carpeta(nombre);
		try {
			carpeta.añadir(mensaje);
		} catch (OperacionInvalida e) {
			e.printStackTrace();
		}
		assertEquals(nombre + " (" + "1" + ")", carpeta.obtenerVisualizacion());
	}

	@Property
	public void explorarTest(String nombre, String contenido) {
		Texto texto = new Texto(nombre, contenido);
		Mensaje mensaje = new Mensaje(texto);
		Carpeta carpeta = new Carpeta(nombre);
		try {
			carpeta.añadir(mensaje);
		} catch (OperacionInvalida e) {
			e.printStackTrace();
		}
		Collection ans = null;
		try {
			ans = carpeta.explorar();
		} catch (OperacionInvalida operacionInvalida) {
			operacionInvalida.printStackTrace();
		}
		Vector expected = new Vector();
		expected.add(mensaje);
		assertEquals(expected, ans);
	}

	@Property
	public void buscarTest(String nombre, String contenido) {
		Texto texto = new Texto(nombre, contenido);
		Mensaje mensaje = new Mensaje(texto);
		Carpeta carpeta = new Carpeta(nombre);
		try {
			carpeta.añadir(mensaje);
		} catch (OperacionInvalida e) {
			e.printStackTrace();
		}
		Collection ans = carpeta.buscar(contenido);
		Vector expected = new Vector();
		expected.add(mensaje);
		assertEquals(expected, ans);
	}


	@Property
	public void añadirTest(String nombre, String contenido) {
		Texto texto = new Texto(nombre, contenido);
		Mensaje mensaje = new Mensaje(texto);
		Carpeta carpeta = new Carpeta(nombre);
		try {
			carpeta.añadir(mensaje);
		} catch (OperacionInvalida e) {
			e.printStackTrace();
		}
		Correo ans = null;
		try {
			ans = carpeta.obtenerHijo(0);
		} catch (OperacionInvalida operacionInvalida) {
			operacionInvalida.printStackTrace();
		}
		assertEquals(mensaje, ans);
	}
}
