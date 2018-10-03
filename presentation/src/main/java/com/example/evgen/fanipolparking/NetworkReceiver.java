package com.example.evgen.fanipolparking;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class NetworkReceiver extends BroadcastReceiver {

    Button button; //check or enter button
    TextView warningInternet; //textView warnings

    public NetworkReceiver(Button button, TextView textView) {
        this.button = button;
        warningInternet = textView;
    }

    /**
     Turns off/on check/enter buttons and warning messages in driver and admin fragments,
     depends on the Network connection
     */
    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo == null || !(networkInfo.isConnected()) ){
            button.setEnabled(false);
            warningInternet.setVisibility(View.VISIBLE);
        }else{
            button.setEnabled(true);
            warningInternet.setVisibility(View.INVISIBLE);
        }
    }
}
