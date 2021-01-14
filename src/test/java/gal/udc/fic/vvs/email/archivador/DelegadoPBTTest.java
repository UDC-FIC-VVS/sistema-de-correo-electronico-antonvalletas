package gal.udc.fic.vvs.email.archivador;


import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(JUnitQuickcheck.class)
public class DelegadoPBTTest {

	@Property
	public void delegadoTest(String nombreArchivador, @InRange(minInt = 1) int espacioArchivador) {
		ArchivadorSimple archivadorSimple = new ArchivadorSimple(nombreArchivador, espacioArchivador);
		Delegado delegado = new Delegado(archivadorSimple);
		assertNotNull(delegado);
	}

	@Property
	public void obtenerEspacioDisponibleTest(String nombreArchivador, @InRange(minInt = 1) int espacioArchivador) {
		Delegado delegado = new Delegado(new ArchivadorSimple(nombreArchivador, espacioArchivador));
		assertEquals(espacioArchivador, delegado.obtenerEspacioDisponible());

	}

	@Property
	public void obtenerNombreTest(String nombreArchivador, @InRange(minInt = 1) int espacioArchivador) {
		Delegado delegado = new Delegado(new ArchivadorSimple(nombreArchivador, espacioArchivador
		));
		assertEquals(nombreArchivador, delegado.obtenerNombre());
	}

	@Property
	public void obtenerEspacioTotalTest(String nombreArchivador, @InRange(minInt = 1) int espacioArchivador) {
		Delegado delegado = new Delegado(new ArchivadorSimple(nombreArchivador, espacioArchivador
		));
		assertEquals(espacioArchivador, delegado.obtenerEspacioTotal());
	}

	@Property
	public void establecerDelegadoTest(String nombreArchivador, @InRange(minInt = 1) int espacioArchivador) {
		ArchivadorSimple archivadorSimple = new ArchivadorSimple(nombreArchivador, espacioArchivador);
		Delegado delegado = new Delegado(archivadorSimple);
		delegado.establecerDelegado(archivadorSimple);
		assertEquals(archivadorSimple, delegado.obtenerDelegado());
	}
}
