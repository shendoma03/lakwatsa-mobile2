package com.example.rhendel03.webservices;

import android.os.AsyncTask;

import com.example.rhendel03.LakwatsaConfig;
import com.example.rhendel03.util.WebServiceUtil;

import org.json.JSONObject;

import java.io.InputStream;

/**
 * Created by rhendel03 on 12/13/2015.
 */
public class LoginAsyncTask extends AsyncTask<String, Void, JSONObject> {
    @Override
    protected JSONObject doInBackground(String... strings) {
        String url = LakwatsaConfig.WEBSERVICE_URL + "/Login";
        InputStream inputStream = null;
        String result = "";

        try {
            JSONObject input = new JSONObject();
            input.accumulate("username", strings[0]);
            input.accumulate("password", strings[1]);
            return WebServiceUtil.callWS(url, input);
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void onPostExecute(JSONObject jsonObject) {
        super.onPostExecute(jsonObject);

        // if we called the AsyncTask with the activity object as the constructor parameter
        // call the appropriate methods based on the status
        if(this.activity != null) {
            if (jsonObject != null && jsonObject.optString("status", "error").equals("success")) {
                this.activity.onSuccessfulLogin();
            }
            else {
                this.activity.onFailedLogin();
            }
        }
    }

    public LoginAsyncTask() {
        super();
    }

    private LoginAsyncInterface activity;

    public LoginAsyncTask(LoginAsyncInterface activity) {
        this.activity = activity;
    }
}

