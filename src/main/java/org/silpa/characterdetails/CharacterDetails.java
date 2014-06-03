package org.silpa.characterdetails;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Normalizer;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sujith on 24/5/14.
 */
public class CharacterDetails {

    /**
     * Map to store UnicodeData
     */
    private static Map<String, String[]> mUnicodeDataMap;

    /**
     * Name of file - UnicodeData.txt
     */
    private static final String mUnicodeDataFileName = "UnicodeData.txt";

    /**
     * Number of fields in UnicodeData.txt
     */
    private static final int mUnicodeDataFields = 15;

    /**
     * Context of application
     */
    private Context mContext;

    public static final String MODULE_NAME = "Character Details";
    public static final String MODULE_INFORMATION = "Shows the Unicode Character " +
            "Details of a given character";

    private static final String LOG_TAG = CharacterDetails.MODULE_NAME;
    

    /**
     * Constructor
     *
     * @param context context
     */
    public CharacterDetails(Context context) {
        this.mContext = context;
        init();
    }

    /**
     * This function is used to load rules on object creation
     */
    private void init() {
        mUnicodeDataMap = new HashMap<String, String[]>();
        loadRules();
    }

    /**
     * This function is used to load UnicodeData into map
     */
    private void loadRules() {

        String line;
        BufferedReader br;

        try {
            br = new BufferedReader(new InputStreamReader(this.mContext.getResources().
                    getAssets().open(mUnicodeDataFileName)));

            while (true) {
                try {
                    line = br.readLine().trim();

                    String[] res = new String[mUnicodeDataFields];
                    String[] fields = line.split(";");
                    for (int i = 0; i < fields.length; i++) {
                        if (fields[i] == null || fields[i].equals("")) {
                            res[i] = null;
                            continue;
                        }
                        res[i] = fields[i];
                    }
                    mUnicodeDataMap.put(res[0], res);

                } catch (Exception e) {
                    Log.e(LOG_TAG, "Error : " + e.getMessage() + " " +
                            " Loading rules terminated");
                    break;
                }
            }
            br.close();
        } catch (IOException ioe) {
            Log.e(LOG_TAG, "Error : " + ioe.getMessage());
        }
    }

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

            String codePoint = Integer.toHexString(ch).toUpperCase();
            while (codePoint.length() != 4) codePoint = "0" + codePoint;

            String name = mUnicodeDataMap.get(codePoint)[1];

            String canonicalDecomposition = Normalizer.normalize(ch + "", Normalizer.Form.NFD);

            CharacterDetailsObject obj = new CharacterDetailsObject(isDigit, isAlphabet, isAlphaNumeric,
                    (int) ch,
                    name, "\\u" + codePoint, canonicalDecomposition);
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
        return CharacterDetails.MODULE_NAME;
    }

    /**
     * This function gives a brief description of the module
     *
     * @return brief information regarding the module
     */
    public String getModuleInformation() {
        return CharacterDetails.MODULE_INFORMATION;
    }
}
