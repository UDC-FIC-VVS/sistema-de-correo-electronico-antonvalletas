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

		carpeta.establecerLeido(true);
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
		assertEquals("carpeta1" + " (" + "1" + ")", carpetaLimitada.obtenerPreVisualizacion());
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
		Collection ans = null;
		ans = carpetaLimitada.buscar("contenido");
		Vector expected = new Vector();
		expected.add(mensaje);
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