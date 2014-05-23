package org.smc.silpamodules.characterdetails;

import java.text.Normalizer;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sujith on 24/5/14.
 */
public class CharacterDetails {

    public static final String CHARACTER_DETAILS_MODULE_NAME = "Character Details";
    public static final String CHARACTER_DETAILS_MODULE_INFORMATION = "Shows the Unicode Character " +
            "Details of a given character";

    /**
     * Get character details of each character in string
     *
     * @param text string
     * @return map
     */
    private Map<Character, CharacterDetailsObject> getDetails(String text) {
        Map<Character, CharacterDetailsObject> map = new HashMap<Character, CharacterDetailsObject>();

        for (char ch : text.toCharArray()) {

            boolean isDigit = Character.isDigit(ch);
            boolean isAlphabet = Character.isLetter(ch);
            boolean isAlphaNumeric = Character.isLetterOrDigit(ch);

            int htmlEntity = ch;

            String name = Character.getName(ch);
            String codePoint = Integer.toHexString(ch);
            while (codePoint.length() != 4) codePoint = "0" + codePoint;
            codePoint = "\\u" + codePoint;
            String canonicalDecomposition = Normalizer.normalize(ch + "", Normalizer.Form.NFD);

            CharacterDetailsObject obj = new CharacterDetailsObject(isDigit, isAlphabet, isAlphaNumeric,
                    htmlEntity,
                    name, codePoint, canonicalDecomposition);
            map.put(ch, obj);
        }
        return map;
    }

    /**
     * Get character details of a single character
     *
     * @param ch character
     * @return CharacterDetailsObject
     */
    public CharacterDetailsObject getCharacterDetails(char ch) {
        return getDetails(ch + "").get(ch);
    }

    /**
     * Get character details of each character as a map.
     *
     * @param text string
     * @return map
     */
    public Map<Character, CharacterDetailsObject> getCharacterDetailsAsMap(String text) {
        return getDetails(text);
    }

    /**
     * Get character details of each character in an array.
     *
     * @param text string
     * @return CharacterDetailsObject array
     */
    public CharacterDetailsObject[] getCharacterDetailsAsArray(String text) {
        Map<Character, CharacterDetailsObject> map = getDetails(text);

        CharacterDetailsObject[] arr = new CharacterDetailsObject[text.length()];
        for (int i = 0; i < text.length(); i++) {
            arr[i] = map.get(text.charAt(i));
        }
        return arr;
    }

    /**
     * This function gives name of the module
     *
     * @return name of module
     */
    public String getModuleName() {
        return CharacterDetails.CHARACTER_DETAILS_MODULE_NAME;
    }

    /**
     * This function gives a brief description of the module
     *
     * @return brief information regarding the module
     */
    public String getModuleInformation() {
        return CharacterDetails.CHARACTER_DETAILS_MODULE_INFORMATION;
    }
}
