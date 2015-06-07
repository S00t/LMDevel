package com.example.letsmeet.letsmeet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.letsmeet.letsmeet.Utils.Validate;

/**
 * Created by Soot_Win on 2015-03-29.
 */

public class LoginActivity  extends Validate {

    private Boolean resault = false;
    private String message;
    private String LoginString;
    private String PasswordString;

    EditText login;
    EditText passwordLogin;
    Button loginButton;
    Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        login = (EditText) findViewById(R.id.login);
        passwordLogin = (EditText) findViewById(R.id.passwordLogin);
        loginButton = (Button) findViewById(R.id.loginButton);
        registerButton = (Button) findViewById(R.id.registerButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resault = ValidateLogin(login.getText());
               if(resault){

                   Toast.makeText(getApplicationContext(), getResources().getText(R.string.login_fail),  Toast.LENGTH_LONG).show();

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
}
