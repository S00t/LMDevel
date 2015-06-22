package com.example.letsmeet.letsmeet.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.letsmeet.letsmeet.R;

/**
 * Created by fares on 6/22/15.
 */
public class FragmentRegister extends Fragment {

    public static Fragment newInstance (){
        FragmentRegister f = new FragmentRegister();
        return f;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_register, container, false);

        return layout;
    }
}
