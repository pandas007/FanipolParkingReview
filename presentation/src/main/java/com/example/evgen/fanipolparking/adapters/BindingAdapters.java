package com.example.evgen.fanipolparking.adapters;

import android.content.Intent;
import android.databinding.BindingAdapter;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.evgen.domain.entity.DriverEntity;
import com.example.evgen.fanipolparking.R;
import com.example.evgen.fanipolparking.presentation.screens.AdminEditCarActivity;


public class BindingAdapters {

    public static final String INTENT_EXTRA_KEY = "DriverEntity";

    @BindingAdapter("setAdapter")
    public static void bindRecyclerViewAdapter(RecyclerView recyclerView, RecyclerView.Adapter<?> adapter){
        LinearLayoutManager layoutManager = new LinearLayoutManager(recyclerView.getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), layoutManager.getOrientation()));
        recyclerView.setAdapter(adapter);
    }

    /**
     * Start activity with sent DriverEntity.
     * @param view RecyclerView one item
     * @param driverEntity - DriverEntity object
     */
    @BindingAdapter("setOnClick")
    public static void bindOnClickListener(final ViewGroup view, final DriverEntity driverEntity){
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.getContext().startActivity(new Intent(v.getContext(), AdminEditCarActivity.class)
                        .putExtra(INTENT_EXTRA_KEY, driverEntity));
            }
        });
    }

    /**
     * Swap text in button
     * @param button - extendPayDayButton in admin_edit_car_screen.xml
     * @param isPressed - viewmodel`s boolean isPressed extendPayDayButton
     */
    @BindingAdapter("textSwap")
    public static void textSwap(final Button button, boolean isPressed){
        if (isPressed == false){
            button.setText(R.string.pay_day_edit);
        }else {
            button.setText(R.string.ok_button);
        }
    }
}
