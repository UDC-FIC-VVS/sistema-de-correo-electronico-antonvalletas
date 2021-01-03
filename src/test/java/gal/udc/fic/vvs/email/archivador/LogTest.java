package gal.udc.fic.vvs.email.archivador;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Mensaje;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class LogTest {

	Texto texto = new Texto("valor", "contenido");
	Mensaje mensaje = new Mensaje(texto);
	String nombreArchivador = "archivadorSimple";
	int espacioArchivador = 10;
	ArchivadorSimple archivadorSimple = new ArchivadorSimple(nombreArchivador, espacioArchivador);


	@Test
	public void logTest() {
		Log log = new Log(archivadorSimple);
		assertNotNull(log);
	}

	@Test
	public void almacenarCorreo() {
		Log log = new Log(archivadorSimple);
		assertTrue(log.almacenarCorreo(mensaje));
	}
}