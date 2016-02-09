package com.example.rhendel03.nav1;

import android.app.Notification;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class mainMap extends Fragment {
    String location="",destination;
    private static TextView set;
    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mainmap, container, false);
        set = (TextView) view.findViewById(R.id.set);


        //Start Webview
        WebView myWebView = (WebView) view.findViewById(R.id.webView);
        myWebView.setWebViewClient(new WebViewClient());

        myWebView.loadUrl("http://lakwatsaa.mybluemix.net?lat=14.5410067&long=121.0168845");

            myWebView.loadUrl("http://lakwatsaa.mybluemix.net?lat=16.5410067&long=181.0168845");



        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        return view;

    }
    public void sendRoute (String location, String destination){

    }

}
