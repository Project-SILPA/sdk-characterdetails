package org.silpa.characterdetails;

import java.util.Map;

/**
 * Created by sujith on 12/6/14.
 */
public interface CharacterDetailsInterface {

    /**
     * Get character details of each character in an array.
     *
     * @return CharacterDetailsObject array
     */
    public CharacterDetailsObject[] getCharacterDetailsAsArray();

    /**
     * Get character details of each character as a map.
     *
     * @return map
     */
    public Map<Character, CharacterDetailsObject> getCharacterDetailsAsMap();

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
