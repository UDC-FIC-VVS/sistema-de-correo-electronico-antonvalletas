package gal.udc.fic.vvs.email.archivador;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Mensaje;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitQuickcheck.class)
public class LogPBTTest {

	@Property
	public void logTest(String name, @InRange(maxInt = 1) int contents) {
		ArchivadorSimple archivadorSimple = new ArchivadorSimple(name, contents);
		Log log = new Log(archivadorSimple);
		assertNotNull(log);

	}

	@Property
	public void almacenarCorreoTest(String name, @InRange(maxInt = 1) int space, String contents) {
		Log log = new Log(new ArchivadorSimple(name, space));
		Mensaje mensaje = new Mensaje(new Texto(name, contents));
		if (contents.length() > space) {
			assertFalse(log.almacenarCorreo(mensaje));
		} else {
			assertTrue(log.almacenarCorreo(mensaje));
		}
	}
}
