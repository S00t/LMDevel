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
 * Created by Soot_Win on 2015-03-21.
 */
public class FragmentEventAdd extends Fragment {

    // view's
    private EditText eName;
    private EditText eCategory;
    private EditText eDate;
    private EditText ePlace;
    private EditText eAddress;
    private EditText eParticipantsNumber;
    private Button bAdd;

    public static Fragment newInstance (){
        FragmentEventAdd f = new FragmentEventAdd();
        return f;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_event_add, container, false);

        setUpViews(layout);

        return layout;
    }

    private void setUpViews(View layout) {
//        eName       = (EditText) layout.findViewById(R.id.fragmentEventAddName);
    }


}
