package gal.udc.fic.vvs.email.archivador;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Mensaje;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArchivadorSimpleTest {

	Texto texto = new Texto("valor", "contenido");
	Mensaje mensaje = new Mensaje(texto);
	String nombreArchivador = "archivadorSimple";
	int espacioArchivador = 10;

	@Test
	public void archivadorSimpleTest() {
		ArchivadorSimple archivadorSimple = new ArchivadorSimple(nombreArchivador, espacioArchivador);
		assertNotNull(archivadorSimple);
	}

	@Test
	public void obtenerNombreTest() {
		ArchivadorSimple archivadorSimple = new ArchivadorSimple(nombreArchivador, espacioArchivador);
		assertEquals(nombreArchivador, archivadorSimple.obtenerNombre());
	}

	@Test
	public void almacenarCorreoTest() {
		ArchivadorSimple archivadorSimple = new ArchivadorSimple(nombreArchivador, espacioArchivador);
		assertTrue(archivadorSimple.almacenarCorreo(mensaje));
	}

	@Test
	public void obtenerEspacioTotalTest() {
		ArchivadorSimple archivadorSimple = new ArchivadorSimple(nombreArchivador, espacioArchivador);
		assertEquals(espacioArchivador, archivadorSimple.obtenerEspacioTotal());
	}

	@Test
	public void obtenerEspacioDisponibleTest() {
		ArchivadorSimple archivadorSimple = new ArchivadorSimple(nombreArchivador, espacioArchivador);
		archivadorSimple.almacenarCorreo(mensaje);
		assertEquals(espacioArchivador - mensaje.obtenerTamaño(), archivadorSimple.obtenerEspacioDisponible());
	}

	@Test
	public void obtenerDelegado() {
		ArchivadorSimple archivadorSimple = new ArchivadorSimple(nombreArchivador, espacioArchivador);
		assertNull(archivadorSimple.obtenerDelegado());
	}

	@Test
	public void establecerDelegado() {
		//Method not implemented in class
	}
}