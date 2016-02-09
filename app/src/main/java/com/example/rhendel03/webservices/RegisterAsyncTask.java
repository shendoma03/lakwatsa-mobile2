package com.example.rhendel03.webservices;

import android.os.AsyncTask;

import com.example.rhendel03.LakwatsaConfig;
import com.example.rhendel03.util.WebServiceUtil;

import org.json.JSONObject;

import java.io.InputStream;

/**
 * Created by rhendel03 on 12/13/2015.
 */
public class RegisterAsyncTask extends AsyncTask<String, Void, JSONObject> {



    @Override
    protected JSONObject doInBackground(String... strings) {
        String url = LakwatsaConfig.WEBSERVICE_URL + "/Register";
        InputStream inputStream = null;
        String result = "";
        try {
            JSONObject input = new JSONObject();
            input.accumulate("fname", strings[0]);
            input.accumulate("lname", strings[1]);
            input.accumulate("email", strings[2]);
            input.accumulate("password", strings[3]);
            return WebServiceUtil.callWS(url, input);
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }

    }

    public void onPostExecute(JSONObject jsonObject){

        super.onPostExecute(jsonObject);

        if(this.activity != null){
            if(jsonObject != null && jsonObject.optString("status", "error").equals("success")) {
                this.activity.onSuccessfulRegister();


            }
            else {
                this.activity.onFailedRegister();
            }
        }


    }
    public RegisterAsyncTask() {
        super();
    }
    private RegisterAsyncInterface activity;

    public RegisterAsyncTask(RegisterAsyncInterface activity) {
        this.activity = activity;
    }
}
