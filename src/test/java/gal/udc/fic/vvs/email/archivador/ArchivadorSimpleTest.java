package gal.udc.fic.vvs.email.archivador;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Mensaje;
import org.junit.Test;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import static org.junit.Assert.*;

public class ArchivadorSimpleTest {

	Texto texto = new Texto("valor", "contenido");
	Texto textoDemasiadoGrande = new Texto("valor", "Este texto es demasiado largo");
	Mensaje mensaje = new Mensaje(texto);
	Mensaje mensajeDemasiadoGrande = new Mensaje(textoDemasiadoGrande);
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
	public void almacenarCorreoTest_noSpace() {
		ArchivadorSimple archivadorSimple = new ArchivadorSimple(nombreArchivador, espacioArchivador);
		assertFalse(archivadorSimple.almacenarCorreo(mensajeDemasiadoGrande));
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
	public void obtenerDelegadoTest() {
		ArchivadorSimple archivadorSimple = new ArchivadorSimple(nombreArchivador, espacioArchivador);
		assertNull(archivadorSimple.obtenerDelegado());
	}

	@Test(expected = NotImplementedException.class)
	public void establecerDelegadoTest() {
		ArchivadorSimple archivadorSimple = new ArchivadorSimple(nombreArchivador, espacioArchivador);
		ArchivadorSimple otroArchivadorSimple = new ArchivadorSimple(nombreArchivador, espacioArchivador);
		archivadorSimple.establecerDelegado(otroArchivadorSimple);
	}
}