package com.example.letsmeet.letsmeet.Fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.letsmeet.letsmeet.R;
import com.example.letsmeet.letsmeet.Utils.OAuth2Client;
import com.example.letsmeet.letsmeet.Utils.Token;
import com.example.letsmeet.letsmeet.Utils.UtilValidate;


/**
 * Created by fares on 6/22/15.
 */
public class FragmentLogin extends Fragment implements Animation.AnimationListener, View.OnClickListener {

    private Boolean resault = false;
    private String message;
    private String LoginString;
    private String PasswordString;
    private String c_id;
    private String ss;
    private String site;

    private ImageView logo;
    private EditText login;
    private EditText passwordLogin;
    private Button loginButton;
    private Button registerButton;

    private Animation animFadeIn;
    private Animation animSlideDown;

    public static Fragment newInstance (){
        FragmentLogin f = new FragmentLogin();
        return f;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_login, container, false);

        c_id = (String) getResources().getText(R.string.c_id);
        ss = (String) getResources().getText(R.string.ss);
        site = (String) getResources().getText(R.string.site);

        linkViews(layout);

        setUpAnimations();
        setUpVisibility();
        startAnimations();

        setUpListeners();

        return layout;
    }

    private void setUpListeners() {
        loginButton.setOnClickListener(this);
    }

    private void linkViews(View layout) {
        logo = (ImageView) layout.findViewById(R.id.fragmentLoginLogo);
        login = (EditText) layout.findViewById(R.id.fragmentLoginMail);
        passwordLogin = (EditText) layout.findViewById(R.id.fragmentLoginPassword);
        loginButton = (Button) layout.findViewById(R.id.fragmentLoginButtonLogin);
        registerButton = (Button) layout.findViewById(R.id.fragmentLoginButtonRegister);
    }

    private void setUpVisibility() {
        logo.setVisibility(View.VISIBLE);
        login.setVisibility(View.VISIBLE);
        loginButton.setVisibility(View.VISIBLE);
        passwordLogin.setVisibility(View.VISIBLE);
        registerButton.setVisibility(View.VISIBLE);
    }

    private void startAnimations() {
        logo.startAnimation(animSlideDown);
        login.startAnimation(animSlideDown);
        loginButton.startAnimation(animSlideDown);
        passwordLogin.startAnimation(animSlideDown);
        registerButton.startAnimation(animSlideDown);
    }

    private void setUpAnimations() {
        animFadeIn = AnimationUtils.loadAnimation(getActivity(), R.anim.fab_in);
        animSlideDown = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_down);
        animFadeIn.setAnimationListener(this);
        animSlideDown.setAnimationListener(this);
    }

    // --------------------------- ANIMATION ---------------------------
    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        if (animation == animFadeIn) {
            Toast.makeText(getActivity(), "Animation Stopped", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

    // --------------------------- OnClickListener ---------------------------
    @Override
    public void onClick(View v) {

    }

    private class getTokenTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            String t = "nope";
            try {
                OAuth2Client client = new OAuth2Client(login.getText().toString(), passwordLogin.getText().toString(), c_id, ss, site);
                Log.d("OAUTH", client.toString());
                Token token = client.getAccessToken();

                token.getResource(client, token, "/api/event-types/");
                t = token.toString();
            } catch (Exception e) {
                Log.e("log_tag", "Error in http connection " + e.toString());
            }
            return t;
        }
    }
}
