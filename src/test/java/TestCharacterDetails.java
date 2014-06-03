import android.test.AndroidTestCase;
import android.test.suitebuilder.annotation.LargeTest;
import android.test.suitebuilder.annotation.MediumTest;
import android.test.suitebuilder.annotation.SmallTest;

import org.silpa.characterdetails.CharacterDetails;
import org.silpa.characterdetails.CharacterDetailsObject;

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
        CharacterDetails obj = new CharacterDetails(getContext());
        assertEquals(CharacterDetails.MODULE_NAME, obj.getModuleName());
    }

    @SmallTest
    @MediumTest
    @LargeTest
    public void testGetModuleInformation() {
        CharacterDetails obj = new CharacterDetails(getContext());
        assertEquals(CharacterDetails.MODULE_INFORMATION, obj.getModuleInformation());
    }

    @SmallTest
    @MediumTest
    @LargeTest
    public void testGetCharacterDetails() {
        CharacterDetails obj = new CharacterDetails(getContext());
        CharacterDetailsObject details;

        details = obj.getCharacterDetails('S');
        assertEquals(false, details.isDigit());
        assertEquals(true, details.isAlphabet());
        assertEquals(true, details.isAlphaNumeric());
        assertEquals(83, details.getHtmlEntity());
        assertEquals("LATIN CAPITAL LETTER S", details.getName());
        assertEquals("\\u0053", details.getCodePoint());
        assertEquals("S", details.getCanonicalDecomposition());

        details = obj.getCharacterDetails('ക');
        assertEquals(false, details.isDigit());
        assertEquals(true, details.isAlphabet());
        assertEquals(true, details.isAlphaNumeric());
        assertEquals(3349, details.getHtmlEntity());
        assertEquals("MALAYALAM LETTER KA", details.getName());
        assertEquals("\\u0D15", details.getCodePoint());
        assertEquals("ക", details.getCanonicalDecomposition());

        details = obj.getCharacterDetails('क');
        assertEquals(false, details.isDigit());
        assertEquals(true, details.isAlphabet());
        assertEquals(true, details.isAlphaNumeric());
        assertEquals(2325, details.getHtmlEntity());
        assertEquals("DEVANAGARI LETTER KA", details.getName());
        assertEquals("\\u0915", details.getCodePoint());
        assertEquals("क", details.getCanonicalDecomposition());

        details = obj.getCharacterDetails('আ');
        assertEquals(false, details.isDigit());
        assertEquals(true, details.isAlphabet());
        assertEquals(true, details.isAlphaNumeric());
        assertEquals(2438, details.getHtmlEntity());
        assertEquals("BENGALI LETTER AA", details.getName());
        assertEquals("\\u0986", details.getCodePoint());
        assertEquals("আ", details.getCanonicalDecomposition());

        details = obj.getCharacterDetails('ਉ');
        assertEquals(false, details.isDigit());
        assertEquals(true, details.isAlphabet());
        assertEquals(true, details.isAlphaNumeric());
        assertEquals(2569, details.getHtmlEntity());
        assertEquals("GURMUKHI LETTER U", details.getName());
        assertEquals("\\u0A09", details.getCodePoint());
        assertEquals("ਉ", details.getCanonicalDecomposition());

        details = obj.getCharacterDetails('ઊ');
        assertEquals(false, details.isDigit());
        assertEquals(true, details.isAlphabet());
        assertEquals(true, details.isAlphaNumeric());
        assertEquals(2698, details.getHtmlEntity());
        assertEquals("GUJARATI LETTER UU", details.getName());
        assertEquals("\\u0A8A", details.getCodePoint());
        assertEquals("ઊ", details.getCanonicalDecomposition());

        details = obj.getCharacterDetails('ଉ');
        assertEquals(false, details.isDigit());
        assertEquals(true, details.isAlphabet());
        assertEquals(true, details.isAlphaNumeric());
        assertEquals(2825, details.getHtmlEntity());
        assertEquals("ORIYA LETTER U", details.getName());
        assertEquals("\\u0B09", details.getCodePoint());
        assertEquals("ଉ", details.getCanonicalDecomposition());

        details = obj.getCharacterDetails('இ');
        assertEquals(false, details.isDigit());
        assertEquals(true, details.isAlphabet());
        assertEquals(true, details.isAlphaNumeric());
        assertEquals(2951, details.getHtmlEntity());
        assertEquals("TAMIL LETTER I", details.getName());
        assertEquals("\\u0B87", details.getCodePoint());
        assertEquals("இ", details.getCanonicalDecomposition());

        details = obj.getCharacterDetails('ఋ');
        assertEquals(false, details.isDigit());
        assertEquals(true, details.isAlphabet());
        assertEquals(true, details.isAlphaNumeric());
        assertEquals(3083, details.getHtmlEntity());
        assertEquals("TELUGU LETTER VOCALIC R", details.getName());
        assertEquals("\\u0C0B", details.getCodePoint());
        assertEquals("ఋ", details.getCanonicalDecomposition());

        details = obj.getCharacterDetails('4');
        assertEquals(true, details.isDigit());
        assertEquals(false, details.isAlphabet());
        assertEquals(true, details.isAlphaNumeric());
        assertEquals(52, details.getHtmlEntity());
        assertEquals("DIGIT FOUR", details.getName());
        assertEquals("\\u0034", details.getCodePoint());
        assertEquals("4", details.getCanonicalDecomposition());

        details = obj.getCharacterDetails('0');
        assertEquals(true, details.isDigit());
        assertEquals(false, details.isAlphabet());
        assertEquals(true, details.isAlphaNumeric());
        assertEquals(48, details.getHtmlEntity());
        assertEquals("DIGIT ZERO", details.getName());
        assertEquals("\\u0030", details.getCodePoint());
        assertEquals("0", details.getCanonicalDecomposition());

        details = obj.getCharacterDetails('!');
        assertEquals(false, details.isDigit());
        assertEquals(false, details.isAlphabet());
        assertEquals(false, details.isAlphaNumeric());
        assertEquals(33, details.getHtmlEntity());
        assertEquals("EXCLAMATION MARK", details.getName());
        assertEquals("\\u0021", details.getCodePoint());
        assertEquals("!", details.getCanonicalDecomposition());

    }

    @SmallTest
    @MediumTest
    @LargeTest
    public void testGetCharacterDetailsAsMap() {

        CharacterDetails obj = new CharacterDetails(getContext());
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
        assertEquals("\\u002E", map.get('.').getCodePoint());
        assertEquals(".", map.get('.').getCanonicalDecomposition());
    }

    @SmallTest
    @MediumTest
    @LargeTest
    public void testGetCharacterDetailsAsArray() {
        CharacterDetails obj = new CharacterDetails(getContext());
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
        assertEquals("\\u002E", arr[2].getCodePoint());
        assertEquals(".", arr[2].getCanonicalDecomposition());
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
