package org.silpa.characterdetails;

import android.content.Context;
import android.util.AttributeSet;

import org.silpa.render.IndicEditText;

import java.util.Map;

/**
 * Created by sujith on 12/6/14.
 */
public class CharacterDetailsEditText extends IndicEditText implements CharacterDetailsInterface {

    private Context mContext;
    private CharacterDetails characterDetails;

    /**
     * Constructor
     *
     * @param context context of application
     */
    public CharacterDetailsEditText(Context context) {
        super(context);
        init();
    }

    /**
     * Constructor
     *
     * @param context context of application
     * @param attrs   attribute set
     */
    public CharacterDetailsEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    /**
     * Constructor
     *
     * @param context  context of application
     * @param attrs    attribute set
     * @param defStyle default style
     */
    public CharacterDetailsEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        this.mContext = getContext();
        this.characterDetails = new CharacterDetails(this.mContext);
    }

    /**
     * Get character details of each character in an array.
     *
     * @return CharacterDetailsObject array
     */
    @Override
    public CharacterDetailsObject[] getCharacterDetailsAsArray() {
        return this.characterDetails.getCharacterDetailsAsArray(getText().toString());
    }

    /**
     * Get character details of each character as a map.
     *
     * @return map
     */
    @Override
    public Map<Character, CharacterDetailsObject> getCharacterDetailsAsMap() {
        return this.characterDetails.getCharacterDetailsAsMap(getText().toString());
    }

    /**
     * This function gives name of the module
     *
     * @return name of module
     */
    @Override
    public String getModuleName() {
        return this.characterDetails.getModuleName();
    }

    /**
     * This function gives a brief description of the module
     *
     * @return brief information regarding the module
     */
    @Override
    public String getModuleInformation() {
        return this.characterDetails.getModuleInformation();
    }
}
