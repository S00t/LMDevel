package com.example.letsmeet.letsmeet.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.letsmeet.letsmeet.R;

/**
 * Created by Soot_Win on 2015-03-22.
 */
public class FragmentAccount extends Fragment {

    // view's
    private EditText eName;
    private EditText eSurname;
    private EditText eMail;
    private EditText ePhone;
    private EditText ePlace;
    private ImageView iAvatar;
    private Button bAvatarChange;
    private Button bAvatarDelete;
    private Button bSave;

    public static Fragment newInstance (){
        FragmentAccount f = new FragmentAccount();
        return f;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_account, container, false);

        setUpViews(layout);

        return layout;
    }

    private void setUpViews(View layout) {
        // todo ...
    }
}
