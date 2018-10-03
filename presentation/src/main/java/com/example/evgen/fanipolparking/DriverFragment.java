package com.example.evgen.fanipolparking;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.evgen.domain.entity.DriverEntity;
import com.example.evgen.domain.interactors.FindDriverByNumberUseCase;
import com.example.evgen.fanipolparking.app.App;
import com.example.evgen.fanipolparking.presentation.screens.DriverInfoScreen;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


public class DriverFragment extends Fragment implements View.OnClickListener{

    private EditText editText1;
    private EditText editText2;
    private EditText editText3;
    private Button button;
    private TextView warningMatchCar;
    private TextView warningInternet;

    private String fullNumber;

    private NetworkReceiver networkReceiver;

    @Inject
    public FindDriverByNumberUseCase findDriverUseCase;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getAppComponent().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = getLayoutInflater().inflate(R.layout.driver_fragment, container, false);

        editText1 = view.findViewById(R.id.carNumberEdit1);
        editText2 = view.findViewById(R.id.carNumberEdit2);
        editText3 = view.findViewById(R.id.carNumberEdit3);
        button = view.findViewById(R.id.driverCheckButton);
        warningMatchCar = view.findViewById(R.id.warningMatchCar);
        warningInternet = view.findViewById(R.id.warningNoInternetDriver);

        button.setOnClickListener(this);

        initNetworkReceiver();

        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        getContext().unregisterReceiver(networkReceiver);
    }

    private void initNetworkReceiver(){
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        networkReceiver = new NetworkReceiver(button, warningInternet);
        getContext().registerReceiver(networkReceiver, intentFilter);
    }

    @Override
    public void onClick(View v) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(editText1.getText().toString().toLowerCase())
                .append(editText2.getText().toString().toLowerCase())
                .append(editText3.getText().toString().toLowerCase());

        fullNumber = stringBuilder.toString();

        findDriverUseCase.findDriver(fullNumber)
                .subscribe(new Observer<DriverEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("AAA", "START finddriverbynumUseCase");
                    }

                    @Override
                    public void onNext(DriverEntity driverEntity) {
                        if (driverEntity != null){
                            Intent intent = new Intent(getContext(), DriverInfoScreen.class);
                            intent.putExtra("Car", driverEntity.getCar());
                            startActivity(intent);
                        }
                        else Toast.makeText(getContext(), "ASDDASDASDSA", Toast.LENGTH_SHORT);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("AAA", e.toString());
                    }

                    @Override
                    public void onComplete() {
                        Log.e("AAA", "Complete");
                    }
                });
    }
}
