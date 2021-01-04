package gal.udc.fic.vvs.email.correo;

import gal.udc.fic.vvs.email.archivo.Texto;
import org.junit.Test;

import java.util.Collection;
import java.util.Vector;

import static org.junit.Assert.*;

public class CarpetaLimitadaTest {

	Carpeta carpeta = new Carpeta("carpeta1");
	Texto texto = new Texto("valor", "contenido");
	Mensaje mensaje = new Mensaje(texto);

	@Test
	public void carpetaLimitadaConstructorTest() {
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, 5);
		assertNotNull(carpetaLimitada);
	}

	@Test
	public void establecerLeidoTest() {
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, 5);

		try {
			carpetaLimitada.añadir(mensaje);
		} catch (OperacionInvalida operacionInvalida) {
			operacionInvalida.printStackTrace();
		}

		carpetaLimitada.establecerLeido(true);
		assertEquals(0, carpetaLimitada.obtenerNoLeidos());
	}

	@Test
	public void obtenerNoLeidosTest() {
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, 5);

		try {
			carpetaLimitada.añadir(mensaje);
		} catch (OperacionInvalida operacionInvalida) {
			operacionInvalida.printStackTrace();
		}

		assertEquals(1, carpetaLimitada.obtenerNoLeidos());
	}

	@Test
	public void obtenerTamañoTest() {
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, 5);

		try {
			carpetaLimitada.añadir(mensaje);
		} catch (OperacionInvalida operacionInvalida) {
			operacionInvalida.printStackTrace();
		}
		assertEquals(mensaje.obtenerTamaño(), carpetaLimitada.obtenerTamaño());

	}

	@Test
	public void obtenerIconoTest() {
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, 5);

		assertEquals(Correo.ICONO_CARPETA, carpetaLimitada.obtenerIcono());
	}

	@Test
	public void obtenerPreVisualizacionTest() {
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, 5);

		try {
			carpetaLimitada.añadir(mensaje);
		} catch (OperacionInvalida operacionInvalida) {
			operacionInvalida.printStackTrace();
		}
		assertEquals("carpeta1" + " (" + "1" + ")", carpetaLimitada.obtenerPreVisualizacion());
	}

	@Test
	public void obtenerVisualizacionTest() {
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, 5);

		try {
			carpetaLimitada.añadir(mensaje);
		} catch (OperacionInvalida operacionInvalida) {
			operacionInvalida.printStackTrace();
		}
		assertEquals("carpeta1" + " (" + "1" + ")", carpetaLimitada.obtenerVisualizacion());
	}

	@Test
	public void obtenerRutaTest() {
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, 5);
		try {
			carpetaLimitada.añadir(mensaje);
		} catch (OperacionInvalida operacionInvalida) {
			operacionInvalida.printStackTrace();
		}
		assertEquals(carpetaLimitada.obtenerPreVisualizacion(), carpetaLimitada.obtenerRuta());

	}

	@Test
	public void explorarTest() {
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, 5);

		try {
			carpetaLimitada.añadir(mensaje);
		} catch (OperacionInvalida operacionInvalida) {
			operacionInvalida.printStackTrace();
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

	@Test
	public void buscarTest() {
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, 5);

		try {
			carpetaLimitada.añadir(mensaje);
		} catch (OperacionInvalida operacionInvalida) {
			operacionInvalida.printStackTrace();
		}
		Collection ans = carpetaLimitada.buscar("contenido");
		Vector expected = new Vector();
		expected.add(mensaje);
		assertEquals(expected, ans);
	}

	@Test
	public void buscarTest_2() {
		CarpetaLimitada carpetaLimitada = null;
		Mensaje mensaje2 = new Mensaje(texto);
		Mensaje mensaje3 = new Mensaje(texto);
		Mensaje mensaje4 = new Mensaje(texto);
		Mensaje mensaje5 = new Mensaje(texto);
		Mensaje mensaje6 = new Mensaje(texto);
		Mensaje mensaje7 = new Mensaje(texto);

		try {
			carpetaLimitada = new CarpetaLimitada(carpeta, 5);
			carpetaLimitada.añadir(mensaje);
			carpetaLimitada.añadir(mensaje2);
			carpetaLimitada.añadir(mensaje3);
			carpetaLimitada.añadir(mensaje4);
			carpetaLimitada.añadir(mensaje5);
			carpetaLimitada.añadir(mensaje6);
			carpetaLimitada.añadir(mensaje7);

		} catch (OperacionInvalida operacionInvalida) {
			operacionInvalida.printStackTrace();
		}
		Collection ans = carpetaLimitada.buscar("contenido");
		Vector expected = new Vector();
		expected.add(mensaje);
		expected.add(mensaje2);
		expected.add(mensaje3);
		expected.add(mensaje4);
		expected.add(mensaje5);
		expected.add(mensaje6);
		assertEquals(expected, ans);
	}


	@Test
	public void añadirTest() {
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, 5);

		try {
			carpetaLimitada.añadir(mensaje);
		} catch (OperacionInvalida operacionInvalida) {
			operacionInvalida.printStackTrace();
		}
		Correo ans = null;
		try {
			ans = carpetaLimitada.obtenerHijo(0);
		} catch (OperacionInvalida operacionInvalida) {
			operacionInvalida.printStackTrace();
		}
		assertEquals(mensaje, ans);
	}

	@Test
	public void eliminarTest() {
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, 5);

		try {
			carpetaLimitada.añadir(mensaje);
		} catch (OperacionInvalida operacionInvalida) {
			operacionInvalida.printStackTrace();
		}

		try {
			carpetaLimitada.eliminar(mensaje);
		} catch (OperacionInvalida operacionInvalida) {
			operacionInvalida.printStackTrace();
		}
		assertEquals(0, carpetaLimitada.obtenerTamaño());
	}

	@Test
	public void obtenerHijoTest() {
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, 5);

		try {
			carpetaLimitada.añadir(mensaje);
		} catch (OperacionInvalida operacionInvalida) {
			operacionInvalida.printStackTrace();
		}
		Correo ans = null;
		try {
			ans = carpetaLimitada.obtenerHijo(0);
		} catch (OperacionInvalida operacionInvalida) {
			operacionInvalida.printStackTrace();
		}
		assertEquals(mensaje, ans);
	}

	@Test
	public void obtenerPadreTest() {
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, 5);

		try {
			carpetaLimitada.añadir(mensaje);
		} catch (OperacionInvalida operacionInvalida) {
			operacionInvalida.printStackTrace();
		}
		assertNull(carpetaLimitada.obtenerPadre());
	}

	@Test
	public void establecerPadreTest() {
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, 5);

		try {
			carpetaLimitada.añadir(mensaje);
		} catch (OperacionInvalida operacionInvalida) {
			operacionInvalida.printStackTrace();
		}
		carpetaLimitada.establecerPadre(carpeta);
		assertEquals(carpeta, carpetaLimitada.obtenerPadre());

	}
}