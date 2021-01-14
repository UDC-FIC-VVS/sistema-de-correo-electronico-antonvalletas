package gal.udc.fic.vvs.email.archivador;


import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Mensaje;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitQuickcheck.class)
public class ArchivadorSimplePBTTest {

	@Property
	public void archivadorSimplePBTTest(String archivadorName, int archivadorSpace) {
		ArchivadorSimple archivadorSimple = new ArchivadorSimple(archivadorName, archivadorSpace);
		assertNotNull(archivadorSimple);

	}

	@Property
	public void obtenerNombrePBTTest(String archivadorName, int archivadorSpace) {
		ArchivadorSimple archivadorSimple = new ArchivadorSimple(archivadorName, archivadorSpace);
		assertEquals(archivadorName, archivadorSimple.obtenerNombre());

	}

	@Property
	public void almacenarCorreoSpaceTest(String archivadorName, int archivadorSpace, String textName, String textContents) {
		Mensaje mensaje = new Mensaje(new Texto(textName, textContents));
		ArchivadorSimple archivadorSimple = new ArchivadorSimple(archivadorName, archivadorSpace);
		if (archivadorSimple.obtenerEspacioTotal() >= mensaje.obtenerTamaño()) {
			assertTrue(archivadorSimple.almacenarCorreo(mensaje));
		} else {
			assertFalse(archivadorSimple.almacenarCorreo(mensaje));
		}
	}

	@Property
	public void obtenerEspacioTotalTest(String nombreArchivador, int espacioArchivador) {
		ArchivadorSimple archivadorSimple = new ArchivadorSimple(nombreArchivador, espacioArchivador);
		assertEquals(espacioArchivador, archivadorSimple.obtenerEspacioTotal());
	}

	@Property
	public void obtenerEspacioDisponibleTest(String nombreArchivador, @InRange(minInt = 1) int espacioArchivador, String nombreTexto, String contenidoTexto) {
		ArchivadorSimple archivadorSimple = new ArchivadorSimple(nombreArchivador, espacioArchivador);
		Mensaje mensaje = new Mensaje(new Texto(nombreTexto, contenidoTexto));
		archivadorSimple.almacenarCorreo(mensaje);
		if (contenidoTexto.length() <= espacioArchivador) {
			assertEquals(espacioArchivador - mensaje.obtenerTamaño(), archivadorSimple.obtenerEspacioDisponible());
		} else {
			assertNotEquals(espacioArchivador - mensaje.obtenerTamaño(), archivadorSimple.obtenerEspacioDisponible());
		}
	}


}
