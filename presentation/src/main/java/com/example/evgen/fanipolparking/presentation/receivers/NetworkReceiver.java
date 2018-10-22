package com.example.evgen.fanipolparking.presentation.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.example.evgen.fanipolparking.presentation.base.BaseViewModel;


public class NetworkReceiver extends BroadcastReceiver{

    private boolean isNetworkOn = false;
    private BaseViewModel viewModel;

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
