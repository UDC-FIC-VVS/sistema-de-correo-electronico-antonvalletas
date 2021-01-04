package gal.udc.fic.vvs.email.archivador;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Mensaje;
import org.junit.Test;

import static org.junit.Assert.*;

public class LogTest {

	Texto texto = new Texto("valor", "contenido");
	Mensaje mensaje = new Mensaje(texto);
	String nombreArchivador = "archivadorSimple";
	int espacioArchivador = 10;
	ArchivadorSimple archivadorSimple = new ArchivadorSimple(nombreArchivador, espacioArchivador);
	ArchivadorSimple archivadorSimple2 = new ArchivadorSimple(nombreArchivador, espacioArchivador + 100);


	@Test
	public void logTest() {
		Log log = new Log(archivadorSimple);
		assertNotNull(log);
	}

	@Test
	public void obtenerDelegadoTest() {
		Delegado delegado = new Delegado(archivadorSimple2);
		Log log = new Log(delegado);
		Delegado delegado2 = new Delegado(archivadorSimple2);
		log.establecerDelegado(delegado2);
		assertEquals(delegado2, log.obtenerDelegado());
	}

	@Test
	public void almacenarCorreo() {
		Log log = new Log(archivadorSimple);
		assertTrue(log.almacenarCorreo(mensaje));
	}
}