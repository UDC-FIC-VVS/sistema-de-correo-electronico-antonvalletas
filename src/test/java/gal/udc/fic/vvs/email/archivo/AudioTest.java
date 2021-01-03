package gal.udc.fic.vvs.email.archivo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AudioTest {
	String audioName = "audio1";
	String audioContent = "aef31fef1f2f4fa";

	@Test
	public void audioTest() {
		Audio audio = new Audio(audioName, audioContent);
		assertNotNull(audio);
	}

	@Test
	public void obtenerMimeTypeTest() {
		Audio audio = new Audio(audioName, audioContent);
		assertEquals("audio/ogg", audio.obtenerMimeType());

	}
}