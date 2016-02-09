package com.example.rhendel03.sampnavlk;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rhendel03.nav1.MainScreen;
import com.example.rhendel03.nav1.R;
import com.example.rhendel03.webservices.LoginAsyncInterface;
import com.example.rhendel03.webservices.RegisterAsyncInterface;
import com.example.rhendel03.webservices.RegisterAsyncTask;

public class RegisterScreen extends Activity implements RegisterAsyncInterface {
    EditText emailEt,fnameEt,lnameEt,passEt,cpEt;

    public void init(){

        fnameEt=(EditText) findViewById(R.id.fnameEt);
        lnameEt=(EditText) findViewById(R.id.lnameEt);
        emailEt=(EditText) findViewById(R.id.emailEt);
        passEt=(EditText) findViewById(R.id.passEt);
        cpEt=(EditText) findViewById(R.id.cpEt);
        Button regbtn = (Button) findViewById(R.id.btnreg);
        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rEmail = emailEt.getText().toString();
                String rfname = fnameEt.getText().toString();
                String rlfname = lnameEt.getText().toString();
                String rpass = passEt.getText().toString();
                String rcp = cpEt.getText().toString();

                (new RegisterAsyncTask(RegisterScreen.this)).execute(new String[]{rfname, rlfname, rEmail, rpass, rcp});


            }
        });



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_register_screen);


        Button bbtn = (Button) findViewById(R.id.back);
        bbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (getApplicationContext(), MainScreen.class);
                startActivity(intent);
                finish();
            }
        } );
        init();




    }//onCreate


    @Override
    public void onSuccessfulRegister() {
        Intent intent = new Intent(getApplicationContext(), MainScreen.class);
        startActivity(intent);
        finish();
    }


    @Override
    public void onFailedRegister() {
        Toast.makeText(this, "Fail", Toast.LENGTH_LONG).show();
    }
}
