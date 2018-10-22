package com.example.evgen.fanipolparking;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.evgen.fanipolparking.presentation.base.BaseViewModel;


public class NetworkReceiver extends BroadcastReceiver{

    Button button; //check or enter button
    TextView warningInternet;//textView warnings

    private boolean isNetworkOn = false;
    private BaseViewModel viewModel;

    public boolean isNetworkOn() {
        return isNetworkOn;
    }

    public void setNetworkOn(boolean networkOn) {
        isNetworkOn = networkOn;
    }

    public NetworkReceiver(Button button, TextView textView) {
        this.button = button;
        warningInternet = textView;
    }

    public NetworkReceiver(BaseViewModel viewModel) {
        this.viewModel = viewModel;
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

        if (networkInfo != null && networkInfo.isConnected() ){
            viewModel.isOnline.set(true);
        }else{
            viewModel.isOnline.set(false);
        }
    }
}
