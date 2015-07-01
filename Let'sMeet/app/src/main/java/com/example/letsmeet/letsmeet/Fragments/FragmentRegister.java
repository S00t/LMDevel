package com.example.letsmeet.letsmeet.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.letsmeet.letsmeet.R;

/**
 * Created by fares on 6/22/15.
 */
public class FragmentRegister extends Fragment {

    // view's
    private EditText eName;
    private EditText eSurname;
    private EditText eMail;
    private EditText ePassword;
    private Button bRegister;
    private Button bRegisterGoogle;

    public static Fragment newInstance (){
        FragmentRegister f = new FragmentRegister();
        return f;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_register, container, false);

        setUpViews(layout);

        return layout;
    }

    private void setUpViews(View layout) {
        eName       = (EditText) layout.findViewById(R.id.fragmentRegisterName);
        eSurname    = (EditText) layout.findViewById(R.id.fragmentRegisterSurname);
        eMail       = (EditText) layout.findViewById(R.id.fragmentRegisterMail);
        ePassword   = (EditText) layout.findViewById(R.id.fragmentRegisterPassword);
        bRegister   = (Button)   layout.findViewById(R.id.fragmentRegisterButtonRegister);
        bRegisterGoogle = (Button) layout.findViewById(R.id.fragmentRegisterButtonRegisterGoogle);
    }


}
