package org.silpa.characterdetails;

import java.util.Map;

/**
 * Created by sujith on 12/6/14.
 */
public interface CharacterDetailsInterface {

    /**
     * Get character details of each character in an array.
     *
     * @param text string
     * @return CharacterDetailsObject array
     */
    public CharacterDetailsObject[] getCharacterDetailsAsArray(String text);

    /**
     * Get character details of each character as a map.
     *
     * @param text string
     * @return map
     */
    public Map<Character, CharacterDetailsObject> getCharacterDetailsAsMap(String text);

    /**
     * This function gives name of the module
     *
     * @return name of module
     */
    public String getModuleName();

    /**
     * This function gives a brief description of the module
     *
     * @return brief information regarding the module
     */
    public String getModuleInformation();
}
