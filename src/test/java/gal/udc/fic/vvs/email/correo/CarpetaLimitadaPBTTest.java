package gal.udc.fic.vvs.email.correo;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import gal.udc.fic.vvs.email.archivo.Texto;
import org.junit.runner.RunWith;

import java.util.Collection;
import java.util.Vector;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(JUnitQuickcheck.class)
public class CarpetaLimitadaPBTTest {

	@Property
	public void carpetaLimitadaTest(String nombre, String contenido, @InRange(minInt = 1) int size) {
		Carpeta carpeta = new Carpeta(nombre);
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, size);
		assertNotNull(carpetaLimitada);
	}

	@Property
	public void establecerLeidoTest(String nombre, String contenido, @InRange(minInt = 1) int size) {
		Texto texto = new Texto(nombre, contenido);
		Mensaje mensaje = new Mensaje(texto);
		Carpeta carpeta = new Carpeta(nombre);
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, size);
		try {
			carpetaLimitada.añadir(mensaje);
		} catch (OperacionInvalida e) {
			e.printStackTrace();
		}

		carpetaLimitada.establecerLeido(true);
		assertEquals(0, carpetaLimitada.obtenerNoLeidos());
	}

	@Property
	public void obtenerTamañoTest(String nombre, String contenido, @InRange(minInt = 1) int size) {
		Texto texto = new Texto(nombre, contenido);
		Mensaje mensaje = new Mensaje(texto);
		Carpeta carpeta = new Carpeta(nombre);
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, size);
		try {
			carpetaLimitada.añadir(mensaje);
		} catch (OperacionInvalida e) {
			e.printStackTrace();
		}
		assertEquals(mensaje.obtenerTamaño(), carpetaLimitada.obtenerTamaño());
	}

	@Property
	public void obtenerPrevisualizacioNTest(String nombre, String contenido, @InRange(minInt = 1) int size) {
		Texto texto = new Texto(nombre, contenido);
		Mensaje mensaje = new Mensaje(texto);
		Carpeta carpeta = new Carpeta(nombre);
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, size);
		try {
			carpetaLimitada.añadir(mensaje);
		} catch (OperacionInvalida e) {
			e.printStackTrace();
		}
		assertEquals(nombre + " (" + "1" + ")", carpetaLimitada.obtenerPreVisualizacion());
	}

	@Property
	public void obtenerVisualizacionTest(String nombre, String contenido, @InRange(minInt = 1) int size) {
		Texto texto = new Texto(nombre, contenido);
		Mensaje mensaje = new Mensaje(texto);
		Carpeta carpeta = new Carpeta(nombre);
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, size);
		try {
			carpetaLimitada.añadir(mensaje);
		} catch (OperacionInvalida e) {
			e.printStackTrace();
		}
		assertEquals(nombre + " (" + "1" + ")", carpetaLimitada.obtenerVisualizacion());
	}

	@Property
	public void explorarTest(String nombre, String contenido, @InRange(minInt = 1) int size) {
		Texto texto = new Texto(nombre, contenido);
		Mensaje mensaje = new Mensaje(texto);
		Carpeta carpeta = new Carpeta(nombre);
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, size);
		try {
			carpetaLimitada.añadir(mensaje);
		} catch (OperacionInvalida e) {
			e.printStackTrace();
		}
		Collection ans = null;
		try {
			ans = carpetaLimitada.explorar();
		} catch (OperacionInvalida operacionInvalida) {
			operacionInvalida.printStackTrace();
		}
		Vector expected = new Vector();
		expected.add(mensaje);
		assertEquals(expected, ans);
	}

	@Property
	public void buscarTest(String nombre, String contenido, @InRange(minInt = 1) int size) {
		Texto texto = new Texto(nombre, contenido);
		Mensaje mensaje = new Mensaje(texto);
		Carpeta carpeta = new Carpeta(nombre);
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, size);
		try {
			carpetaLimitada.añadir(mensaje);
		} catch (OperacionInvalida e) {
			e.printStackTrace();
		}
		Collection ans = carpetaLimitada.buscar(contenido);
		Vector expected = new Vector();
		expected.add(mensaje);
		assertEquals(expected, ans);
	}

	@Property
	public void añadirTest(String nombre, String contenido, @InRange(minInt = 1) int size) {
		Texto texto = new Texto(nombre, contenido);
		Mensaje mensaje = new Mensaje(texto);
		Carpeta carpeta = new Carpeta(nombre);
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, size);
		try {
			carpetaLimitada.añadir(mensaje);
		} catch (OperacionInvalida e) {
			e.printStackTrace();
		}
		Correo ans = null;
		try {
			ans = carpetaLimitada.obtenerHijo(0);
		} catch (OperacionInvalida operacionInvalida) {
			operacionInvalida.printStackTrace();
		}
		assertEquals(mensaje, ans);
	}
}
