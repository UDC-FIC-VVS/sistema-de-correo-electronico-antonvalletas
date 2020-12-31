package gal.udc.fic.vvs.email.correo;

import gal.udc.fic.vvs.email.archivo.Texto;
import org.junit.Test;

import java.util.Collection;
import java.util.Vector;

import static org.junit.Assert.*;

public class CarpetaLimitadaTest {

	@Test
	public void carpetaLimitadaConstructorTest() {
		Carpeta carpeta = new Carpeta("carpeta1");
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, 5);
		assertNotNull(carpetaLimitada);
	}

	@Test
	public void establecerLeidoTest() {
		Carpeta carpeta = new Carpeta("carpeta1");
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, 5);
		Texto texto = new Texto("valor", "contenido");
		Mensaje mensaje = new Mensaje(texto);

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
		Carpeta carpeta = new Carpeta("carpeta1");
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, 5);
		Texto texto = new Texto("valor", "contenido");
		Mensaje mensaje = new Mensaje(texto);

		try {
			carpetaLimitada.añadir(mensaje);
		} catch (OperacionInvalida operacionInvalida) {
			operacionInvalida.printStackTrace();
		}

		assertEquals(1, carpetaLimitada.obtenerNoLeidos());
	}

	@Test
	public void obtenerTamañoTest() {
		Carpeta carpeta = new Carpeta("carpeta1");
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, 5);
		Texto texto = new Texto("valor", "contenido");
		Mensaje mensaje = new Mensaje(texto);

		try {
			carpetaLimitada.añadir(mensaje);
		} catch (OperacionInvalida operacionInvalida) {
			operacionInvalida.printStackTrace();
		}
		assertEquals(mensaje.obtenerTamaño(), carpetaLimitada.obtenerTamaño());

	}

	@Test
	public void obtenerIconoTest() {
		Carpeta carpeta = new Carpeta("carpeta1");
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, 5);

		assertEquals(Correo.ICONO_CARPETA, carpetaLimitada.obtenerIcono());
	}

	@Test
	public void obtenerPreVisualizacionTest() {
		Carpeta carpeta = new Carpeta("carpeta1");
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, 5);
		Texto texto = new Texto("valor", "contenido");
		Mensaje mensaje = new Mensaje(texto);

		try {
			carpetaLimitada.añadir(mensaje);
		} catch (OperacionInvalida operacionInvalida) {
			operacionInvalida.printStackTrace();
		}
		assertEquals("carpeta1" + " (" + "1" + ")", carpetaLimitada.obtenerPreVisualizacion());
	}

	@Test
	public void obtenerVisualizacionTest() {
		Carpeta carpeta = new Carpeta("carpeta1");
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, 5);
		Texto texto = new Texto("valor", "contenido");
		Mensaje mensaje = new Mensaje(texto);

		try {
			carpetaLimitada.añadir(mensaje);
		} catch (OperacionInvalida operacionInvalida) {
			operacionInvalida.printStackTrace();
		}
		assertEquals("carpeta1" + " (" + "1" + ")", carpetaLimitada.obtenerPreVisualizacion());
	}

	@Test
	public void obtenerRutaTest() {
		Carpeta carpeta = new Carpeta("carpeta1");
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, 5);
		Texto texto = new Texto("valor", "contenido");
		Mensaje mensaje = new Mensaje(texto);
		try {
			carpetaLimitada.añadir(mensaje);
		} catch (OperacionInvalida operacionInvalida) {
			operacionInvalida.printStackTrace();
		}
		assertEquals(carpetaLimitada.obtenerPreVisualizacion(), carpetaLimitada.obtenerRuta());

	}

	@Test
	public void explorarTest() {
		Carpeta carpeta = new Carpeta("carpeta1");
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, 5);
		Texto texto = new Texto("valor", "contenido");
		Mensaje mensaje = new Mensaje(texto);

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
		Carpeta carpeta = new Carpeta("carpeta1");
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, 5);
		Texto texto = new Texto("valor", "contenido");
		Mensaje mensaje = new Mensaje(texto);

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
		Carpeta carpeta = new Carpeta("carpeta1");
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, 5);
		Texto texto = new Texto("valor", "contenido");
		Mensaje mensaje = new Mensaje(texto);

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
		Carpeta carpeta = new Carpeta("carpeta1");
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, 5);
		Texto texto = new Texto("valor", "contenido");
		Mensaje mensaje = new Mensaje(texto);

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
		Carpeta carpeta = new Carpeta("carpeta1");
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, 5);
		Texto texto = new Texto("valor", "contenido");
		Mensaje mensaje = new Mensaje(texto);

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
		Carpeta carpeta = new Carpeta("carpeta1");
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, 5);
		Texto texto = new Texto("valor", "contenido");
		Mensaje mensaje = new Mensaje(texto);

		try {
			carpetaLimitada.añadir(mensaje);
		} catch (OperacionInvalida operacionInvalida) {
			operacionInvalida.printStackTrace();
		}
		assertNull(carpetaLimitada.obtenerPadre());
	}

	@Test
	public void establecerPadreTest() {
		Carpeta carpeta = new Carpeta("carpeta1");
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, 5);
		Texto texto = new Texto("valor", "contenido");
		Mensaje mensaje = new Mensaje(texto);

		try {
			carpetaLimitada.añadir(mensaje);
		} catch (OperacionInvalida operacionInvalida) {
			operacionInvalida.printStackTrace();
		}
		carpetaLimitada.establecerPadre(carpeta);
		assertEquals(carpeta, carpetaLimitada.obtenerPadre());

	}
}