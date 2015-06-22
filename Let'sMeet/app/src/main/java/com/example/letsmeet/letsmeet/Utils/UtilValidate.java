package com.example.letsmeet.letsmeet.Utils;


import android.text.Editable;

/**
 * Created by Soot_Win on 2015-03-29.
 */
public abstract class UtilValidate {

    public static Boolean ValidateLogin(Editable login) {

        Boolean result;

        if (login.length() <= 0) {
            result = false;
        } else {

            result = true;
        }
        return result;
    }
}
