import android.test.AndroidTestCase;
import android.test.suitebuilder.annotation.LargeTest;
import android.test.suitebuilder.annotation.MediumTest;
import android.test.suitebuilder.annotation.SmallTest;

import org.smc.silpamodules.characterdetails.CharacterDetails;
import org.smc.silpamodules.characterdetails.CharacterDetailsObject;

import java.util.Map;

/**
 * Created by sujith on 24/5/14.
 */
public class TestCharacterDetails extends AndroidTestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @SmallTest
    @MediumTest
    @LargeTest
    public void testGetModuleName() {
        CharacterDetails obj = new CharacterDetails();
        assertEquals(CharacterDetails.CHARACTER_DETAILS_MODULE_NAME, obj.getModuleName());
    }

    @SmallTest
    @MediumTest
    @LargeTest
    public void testGetModuleInformation() {
        CharacterDetails obj = new CharacterDetails();
        assertEquals(CharacterDetails.CHARACTER_DETAILS_MODULE_INFORMATION, obj.getModuleInformation());
    }

    @SmallTest
    @MediumTest
    @LargeTest
    public void testGetCharacterDetails() {
        CharacterDetails obj = new CharacterDetails();
        CharacterDetailsObject details = obj.getCharacterDetails('S');

        assertEquals(false, details.isDigit());
        assertEquals(true, details.isAlphabet());
        assertEquals(true, details.isAlphaNumeric());
        assertEquals(83, details.getHtmlEntity());
        assertEquals("LATIN CAPITAL LETTER S", details.getName());
        assertEquals("\\u0053", details.getCodePoint());
        assertEquals("S", details.getCanonicalDecomposition());
    }

    @SmallTest
    @MediumTest
    @LargeTest
    public void testGetCharacterDetailsAsMap() {
        CharacterDetails obj = new CharacterDetails();
        Map<Character, CharacterDetailsObject> map = obj.getCharacterDetailsAsMap("$V.");

        assertEquals(false, map.get('$').isDigit());
        assertEquals(false, map.get('$').isAlphabet());
        assertEquals(false, map.get('$').isAlphaNumeric());
        assertEquals(36, map.get('$').getHtmlEntity());
        assertEquals("DOLLAR SIGN", map.get('$').getName());
        assertEquals("\\u0024", map.get('$').getCodePoint());
        assertEquals("$", map.get('$').getCanonicalDecomposition());

        assertEquals(false, map.get('V').isDigit());
        assertEquals(true, map.get('V').isAlphabet());
        assertEquals(true, map.get('V').isAlphaNumeric());
        assertEquals(86, map.get('V').getHtmlEntity());
        assertEquals("LATIN CAPITAL LETTER V", map.get('V').getName());
        assertEquals("\\u0056", map.get('V').getCodePoint());
        assertEquals("V", map.get('V').getCanonicalDecomposition());

        assertEquals(false, map.get('.').isDigit());
        assertEquals(false, map.get('.').isAlphabet());
        assertEquals(false, map.get('.').isAlphaNumeric());
        assertEquals(46, map.get('.').getHtmlEntity());
        assertEquals("FULL STOP", map.get('.').getName());
        assertEquals("\\u002e", map.get('.').getCodePoint());
        assertEquals(".", map.get('.').getCanonicalDecomposition());
    }

    @SmallTest
    @MediumTest
    @LargeTest
    public void testGetCharacterDetailsAsArray() {
        CharacterDetails obj = new CharacterDetails();
        CharacterDetailsObject[] arr = obj.getCharacterDetailsAsArray("$V.");

        assertEquals(false, arr[0].isDigit());
        assertEquals(false, arr[0].isAlphabet());
        assertEquals(false, arr[0].isAlphaNumeric());
        assertEquals(36, arr[0].getHtmlEntity());
        assertEquals("DOLLAR SIGN", arr[0].getName());
        assertEquals("\\u0024", arr[0].getCodePoint());
        assertEquals("$", arr[0].getCanonicalDecomposition());

        assertEquals(false, arr[1].isDigit());
        assertEquals(true, arr[1].isAlphabet());
        assertEquals(true, arr[1].isAlphaNumeric());
        assertEquals(86, arr[1].getHtmlEntity());
        assertEquals("LATIN CAPITAL LETTER V", arr[1].getName());
        assertEquals("\\u0056", arr[1].getCodePoint());
        assertEquals("V", arr[1].getCanonicalDecomposition());

        assertEquals(false, arr[2].isDigit());
        assertEquals(false, arr[2].isAlphabet());
        assertEquals(false, arr[2].isAlphaNumeric());
        assertEquals(46, arr[2].getHtmlEntity());
        assertEquals("FULL STOP", arr[2].getName());
        assertEquals("\\u002e", arr[2].getCodePoint());
        assertEquals(".", arr[2].getCanonicalDecomposition());
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
