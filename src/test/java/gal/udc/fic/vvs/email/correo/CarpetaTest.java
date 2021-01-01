package gal.udc.fic.vvs.email.correo;

import gal.udc.fic.vvs.email.archivo.Texto;
import org.junit.Test;

import java.util.Collection;
import java.util.Vector;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CarpetaTest {

	Texto texto = new Texto("valor", "contenido");
	Mensaje mensaje = new Mensaje(texto);

	@Test
	public void carpetaConstructorTest() {
		Carpeta carpeta = new Carpeta("carpeta1");
		assertNotNull(carpeta);
	}

	@Test
	public void establecerLeidoTest() {
		Carpeta carpeta = new Carpeta("carpeta1");

		try {
			carpeta.añadir(mensaje);
		} catch (OperacionInvalida operacionInvalida) {
			operacionInvalida.printStackTrace();
		}

		carpeta.establecerLeido(true);
		assertEquals(0, carpeta.obtenerNoLeidos());

	}

	@Test
	public void obtenerNoLeidosTest() {
		Carpeta carpeta = new Carpeta("carpeta1");

		try {
			carpeta.añadir(mensaje);
		} catch (OperacionInvalida operacionInvalida) {
			operacionInvalida.printStackTrace();
		}

		assertEquals(1, carpeta.obtenerNoLeidos());
	}

	@Test
	public void obtenerTamañoTest() {
		Carpeta carpeta = new Carpeta("carpeta1");

		try {
			carpeta.añadir(mensaje);
		} catch (OperacionInvalida operacionInvalida) {
			operacionInvalida.printStackTrace();
		}

		assertEquals(mensaje.obtenerTamaño(), carpeta.obtenerTamaño());
	}

	@Test
	public void obtenerIconoTest() {
		Carpeta carpeta = new Carpeta("carpeta1");

		assertEquals(Correo.ICONO_CARPETA, carpeta.obtenerIcono());
	}

	@Test
	public void obtenerPreVisualizacionTest() {
		Carpeta carpeta = new Carpeta("carpeta1");

		try {
			carpeta.añadir(mensaje);
		} catch (OperacionInvalida operacionInvalida) {
			operacionInvalida.printStackTrace();
		}
		assertEquals("carpeta1" + " (" + "1" + ")", carpeta.obtenerPreVisualizacion());
	}

	@Test
	public void obtenerVisualizacionTest() {
		Carpeta carpeta = new Carpeta("carpeta1");

		try {
			carpeta.añadir(mensaje);
		} catch (OperacionInvalida operacionInvalida) {
			operacionInvalida.printStackTrace();
		}
		assertEquals("carpeta1" + " (" + "1" + ")", carpeta.obtenerPreVisualizacion());

	}

	@Test
	public void explorarTest() {
		Carpeta carpeta = new Carpeta("carpeta1");

		try {
			carpeta.añadir(mensaje);
		} catch (OperacionInvalida operacionInvalida) {
			operacionInvalida.printStackTrace();
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

	@Test
	public void buscarTest() {
		Carpeta carpeta = new Carpeta("carpeta1");

		try {
			carpeta.añadir(mensaje);
		} catch (OperacionInvalida operacionInvalida) {
			operacionInvalida.printStackTrace();
		}
		Collection ans = null;
		ans = carpeta.buscar("contenido");
		Vector expected = new Vector();
		expected.add(mensaje);
		assertEquals(expected, ans);
	}

	@Test
	public void añadirTest() {
		Carpeta carpeta = new Carpeta("carpeta1");

		try {
			carpeta.añadir(mensaje);
		} catch (OperacionInvalida operacionInvalida) {
			operacionInvalida.printStackTrace();
		}
		Correo ans = null;
		try {
			ans = carpeta.obtenerHijo(0);
		} catch (OperacionInvalida operacionInvalida) {
			operacionInvalida.printStackTrace();
		}
		assertEquals(mensaje, ans);
	}

	@Test
	public void eliminarTest() {
		Carpeta carpeta = new Carpeta("carpeta1");

		try {
			carpeta.añadir(mensaje);
		} catch (OperacionInvalida operacionInvalida) {
			operacionInvalida.printStackTrace();
		}

		try {
			carpeta.eliminar(mensaje);
		} catch (OperacionInvalida operacionInvalida) {
			operacionInvalida.printStackTrace();
		}
		assertEquals(0, carpeta.obtenerTamaño());
	}

	@Test
	public void obtenerHijoTest() {
		Carpeta carpeta = new Carpeta("carpeta1");

		try {
			carpeta.añadir(mensaje);
		} catch (OperacionInvalida operacionInvalida) {
			operacionInvalida.printStackTrace();
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