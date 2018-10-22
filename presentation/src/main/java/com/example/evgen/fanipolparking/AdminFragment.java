package com.example.evgen.fanipolparking;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class AdminFragment extends Fragment {

    private EditText editText;
    private Button button;
    private TextView warningWrongPassword;
    private TextView warningInternet;

    private NetworkReceiver networkReceiver;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = getLayoutInflater().inflate(R.layout.admin_fragment, container, false);

        editText = view.findViewById(R.id.adminPasswordEdit);
        button = view.findViewById(R.id.adminEnterButton);
        warningWrongPassword = view.findViewById(R.id.warningWrongPassword);
        warningInternet = view.findViewById(R.id.warningNoInternetAdmin);

        //initNetworkReceiver();

        return view;
    }

    public void onPause() {
        super.onPause();
        //getContext().unregisterReceiver(networkReceiver);
    }

    private void initNetworkReceiver(){
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        networkReceiver = new NetworkReceiver(button, warningInternet);
        getContext().registerReceiver(networkReceiver, intentFilter);
    }
}
