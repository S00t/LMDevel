package com.example.letsmeet.letsmeet.Utils;

import android.app.Activity;
import android.text.Editable;

/**
 * Created by Soot_Win on 2015-03-29.
 */
public class Validate extends Activity {


    public Boolean ValidateLogin(Editable login){

        Boolean resault = null;

        if (login.length()<=0){
            resault = false ;
        }else {

            resault = true;
        }
        return resault;
    }


}
