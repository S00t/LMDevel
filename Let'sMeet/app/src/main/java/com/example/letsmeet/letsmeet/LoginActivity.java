package com.example.letsmeet.letsmeet;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.letsmeet.letsmeet.Utils.OAuth2Client;
import com.example.letsmeet.letsmeet.Utils.Token;
import com.example.letsmeet.letsmeet.Utils.Validate;

/**
 * Created by Soot_Win on 2015-03-29.
 */

public class LoginActivity  extends Validate implements Animation.AnimationListener{

    private Boolean resault = false;
    private String message;
    private String LoginString;
    private String PasswordString;
    String c_id ;
    String ss;
    String site;

    ImageView logo;
    EditText login;
    EditText passwordLogin;
    Button loginButton;
    Button registerButton;

    Animation animFadein;
    Animation animSlidedown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
         c_id = (String) getResources().getText(R.string.c_id);
         ss = (String) getResources().getText(R.string.ss);
         site = (String) getResources().getText(R.string.site);


        logo = (ImageView) findViewById(R.id.logo);
        login = (EditText) findViewById(R.id.login);
        passwordLogin = (EditText) findViewById(R.id.passwordLogin);
        loginButton = (Button) findViewById(R.id.loginButton);
        registerButton = (Button) findViewById(R.id.registerButton);


        animFadein = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_in);
        animSlidedown = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_down);
        animFadein.setAnimationListener(this);
        animSlidedown.setAnimationListener(this);


        logo.setVisibility(View.VISIBLE);
        logo.startAnimation(animSlidedown);

        login.setVisibility(View.VISIBLE);
        login.startAnimation(animSlidedown);
        loginButton.setVisibility(View.VISIBLE);
        loginButton.startAnimation(animSlidedown);
        passwordLogin.setVisibility(View.VISIBLE);
        passwordLogin.startAnimation(animSlidedown);
        registerButton.setVisibility(View.VISIBLE);
        registerButton.startAnimation(animSlidedown);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resault = ValidateLogin(login.getText());
               if(resault){

                   new getTokenTask().execute("");


                   //  Toast.makeText(getApplicationContext(), getResources().getText(R.string.login_fail),  Toast.LENGTH_LONG).show();

//                   Toast.makeText(getApplicationContext(), "SUCCES + " + login.getText().length(),
//                           Toast.LENGTH_LONG).show();
//
//                   Intent i = new Intent(LoginActivity.this, MainActivity.class);
//                   startActivity(i);
//++
//                   // close this activity
//                   finish();

               }else{



                   Toast.makeText(getApplicationContext(), message = getResources().getString(R.string.login_fail),
                           Toast.LENGTH_LONG).show();
               }

            }
        });
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activityChangeIntent = new Intent(LoginActivity.this, RegisterActivity.class);

                // currentContext.startActivity(activityChangeIntent);

                LoginActivity.this.startActivity(activityChangeIntent);
            }
        });


    }


    private class getTokenTask extends AsyncTask<String, Void, String>{


        @Override
        protected String doInBackground(String... params) {
            String t="nope";
            try {
                OAuth2Client client = new OAuth2Client(login.getText().toString(), passwordLogin.getText().toString(), c_id, ss, site);
                Log.d("OAUTH", client.toString());
                Token token = client.getAccessToken();

                token.getResource(client, token, "/api/event-types/");
                t=token.toString();
            } catch (Exception e) {
                Log.e("log_tag", "Error in http connection " + e.toString());
            }
            return t;
        }
    }


    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

        if (animation == animFadein) {
            Toast.makeText(getApplicationContext(), "Animation Stopped",
                    Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

    }



