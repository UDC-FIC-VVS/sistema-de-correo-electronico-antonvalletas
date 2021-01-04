package gal.udc.fic.vvs.email.archivador;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Mensaje;
import org.junit.Test;

import static org.junit.Assert.*;

public class DelegadoTest {

	Texto texto = new Texto("valor", "contenido");
	Texto textoDemasiadoGrande = new Texto("valor", "Este texto es demasiado grande");
	Mensaje mensaje = new Mensaje(texto);
	Mensaje mensajeDemasiadoGrande = new Mensaje(textoDemasiadoGrande);
	String nombreArchivador = "archivadorSimple";
	int espacioArchivador = 10;
	ArchivadorSimple archivadorSimple = new ArchivadorSimple(nombreArchivador, espacioArchivador);
	ArchivadorSimple archivadorSimple2 = new ArchivadorSimple(nombreArchivador, espacioArchivador + 100);


	@Test
	public void delegadoTest() {
		Delegado delegado = new Delegado(archivadorSimple);
		assertNotNull(delegado);
	}

	@Test
	public void almacenarCorreoTest() {
		Delegado delegado = new Delegado(archivadorSimple);
		assertTrue(delegado.almacenarCorreo(mensaje));
	}

	@Test
	public void obtenerNombreTest() {
		Delegado delegado = new Delegado(archivadorSimple);
		assertEquals(nombreArchivador, delegado.obtenerNombre());
	}

	@Test
	public void obtenerEspacioTotalTest() {
		Delegado delegado = new Delegado(archivadorSimple);
		assertEquals(espacioArchivador, delegado.obtenerEspacioTotal());
	}

	@Test
	public void almacenarCorreoDemasiadoGrandeTest() {
		Delegado delegado = new Delegado(archivadorSimple);
		delegado.establecerDelegado(archivadorSimple2);
		assertTrue(delegado.almacenarCorreo(mensajeDemasiadoGrande));
	}

	@Test
	public void obtenerDelegadoTest() {
		Delegado delegado = new Delegado(archivadorSimple);
		assertNull(delegado.obtenerDelegado());
	}

	@Test
	public void establecerDelegadoTest() {
		Delegado delegado = new Delegado(archivadorSimple);
		delegado.establecerDelegado(archivadorSimple);
		assertEquals(archivadorSimple, delegado.obtenerDelegado());
	}
}