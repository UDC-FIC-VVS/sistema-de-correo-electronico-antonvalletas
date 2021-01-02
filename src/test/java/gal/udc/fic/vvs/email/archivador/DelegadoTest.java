package gal.udc.fic.vvs.email.archivador;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Mensaje;
import org.junit.Test;

import static org.junit.Assert.*;

public class DelegadoTest {

	Texto texto = new Texto("valor", "contenido");
	Mensaje mensaje = new Mensaje(texto);
	String nombreArchivador = "archivadorSimple";
	int espacioArchivador = 10;
	ArchivadorSimple archivadorSimple = new ArchivadorSimple(nombreArchivador, espacioArchivador);


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