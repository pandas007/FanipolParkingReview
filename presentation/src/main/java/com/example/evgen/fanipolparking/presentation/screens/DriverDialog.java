package com.example.evgen.fanipolparking.presentation.screens;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.TextView;

import com.example.evgen.fanipolparking.R;


public class DriverDialog extends DialogFragment {

    private String car;
    private String number;
    private String payDay;

    public void setCar(String car) {
        this.car = car;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setPayDay(String payDay) {
        this.payDay = payDay;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        View view = getActivity().getLayoutInflater().inflate(R.layout.found_driver_dialog, null);

        TextView foundedCar = view.findViewById(R.id.foundedCar);
        TextView foundedCarNumber = view.findViewById(R.id.foundedCarNumber);
        TextView foundedCarPayDay = view.findViewById(R.id.foundedCarPayDay);

        foundedCar.setText(car);
        foundedCarNumber.setText(number);
        foundedCarPayDay.setText(payDay);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(view)
                .setNegativeButton(R.string.ok_button, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        return builder.create();
    }

}
