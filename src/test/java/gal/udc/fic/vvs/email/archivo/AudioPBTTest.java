package gal.udc.fic.vvs.email.archivo;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertNotNull;

@RunWith(JUnitQuickcheck.class)
public class AudioPBTTest {

	@Property
	public void audioConstructorTest(String audioName, String audioContents) {
		Audio audio = new Audio(audioName, audioContents);
		assertNotNull(audio);
	}
}
