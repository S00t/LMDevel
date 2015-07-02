package com.example.letsmeet.letsmeet.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.letsmeet.letsmeet.R;

public class FragmentChangePassword extends Fragment {

    public static FragmentChangePassword newInstance() {
        FragmentChangePassword fragment = new FragmentChangePassword();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_change_password, container, false);

        setUpViews(layout);

        return layout;
    }

    private void setUpViews(View layout) {
        // todo ...
    }

}
