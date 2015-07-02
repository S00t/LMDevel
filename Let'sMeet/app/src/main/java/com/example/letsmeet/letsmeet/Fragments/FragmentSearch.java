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
public class FragmentSearch extends Fragment {

    // view's
    private EditText eSearch;
    private Button bSearch;

    public static Fragment newInstance (){
        FragmentSearch f = new FragmentSearch();
        return f;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_serach, container, false);

        setUpViews(layout);

        return layout;
    }

    private void setUpViews(View layout) {
        eSearch = (EditText) layout.findViewById(R.id.fragmentSearchFieldSearchParent);
        bSearch = (Button) layout.findViewById(R.id.fragmentSearchButtonSearch);
    }
}