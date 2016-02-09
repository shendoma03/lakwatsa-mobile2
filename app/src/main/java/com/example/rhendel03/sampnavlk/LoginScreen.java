package com.example.rhendel03.sampnavlk;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rhendel03.nav1.MainScreen;
import com.example.rhendel03.nav1.R;
import com.example.rhendel03.webservices.LoginAsyncInterface;
import com.example.rhendel03.webservices.LoginAsyncTask;


public class LoginScreen extends Activity implements LoginAsyncInterface{

    public static final String MyPREFERENCES = "MyPrefs" ;
    EditText etusername;
    private TextView sClick;
    EditText etpassword;
    public void init() {
        etusername=(EditText) findViewById(R.id.emailEt);
        etpassword=(EditText) findViewById(R.id.ff);

        Button imgbtn = (Button) findViewById(R.id.mainbt);

        imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // TODO: show indicator
                // TODO: disable login button

                String vuser = etusername.getText().toString();
                String vpass = etpassword.getText().toString();
                //


                (new LoginAsyncTask(LoginScreen.this)).execute(new String[]{vuser, vpass});


            }
        });


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        init();

        TextView sClick = (TextView)findViewById(R.id.sClick);
        sClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),RegisterScreen.class);
                startActivity(intent);
            }
        });
    }




    @Override
    public void onSuccessfulLogin() {
        Intent intent = new Intent (getApplicationContext(), MainScreen.class);
        startActivity(intent);

        finish();
    }

    @Override
    public void onFailedLogin() {
        Toast.makeText(this, "Login failed! Please check your user name and password.", Toast.LENGTH_LONG).show();
    }




}
