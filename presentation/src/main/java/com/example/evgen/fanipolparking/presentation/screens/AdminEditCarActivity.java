package com.example.evgen.fanipolparking.presentation.screens;


import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.arch.lifecycle.ViewModelProviders;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.EditText;
import android.widget.Toast;

import com.example.evgen.domain.entity.DriverEntity;
import com.example.evgen.fanipolparking.R;
import com.example.evgen.fanipolparking.adapters.BindingAdapters;
import com.example.evgen.fanipolparking.databinding.AdminEditCarScreenBinding;
import com.example.evgen.fanipolparking.presentation.base.BaseMvvmActivity;
import com.example.evgen.fanipolparking.presentation.screens.viewmodels.AdminEditCarViewModel;

import butterknife.BindView;
import butterknife.OnClick;

public class AdminEditCarActivity extends BaseMvvmActivity<AdminEditCarScreenBinding, AdminEditCarViewModel>{

    private static final String SAVE_CHANGES_MESSAGE = "Изменения сохранены";
    private static final String DAYS_EXTENDED_MESSAGE = "Стоянка продлена";

    @BindView(R.id.addDays)
    EditText addDaysEditText;

    private int[] addDaysEditTextLocation = new int[2];



    @Override
    public int provideLayoutId() {
        return R.layout.admin_edit_car_screen;
    }
    @Override
    public AdminEditCarViewModel provideViewModel() {
        return ViewModelProviders.of(this).get(AdminEditCarViewModel.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel.driverEntity = (DriverEntity) getIntent().getSerializableExtra(BindingAdapters.INTENT_EXTRA_KEY);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        addDaysEditText.getLocationOnScreen(addDaysEditTextLocation);
    }

    @OnClick(R.id.extendPayDayButton)
    void onClickExtendPayDayButton(){
        boolean isPressed = viewModel.isExtendButtonPressed.get();
        if (isPressed == false){
            showAddDaysEditText(addDaysEditText);
        }else{
            hideAddDaysEditText(addDaysEditText);
            Toast.makeText(this, DAYS_EXTENDED_MESSAGE, Toast.LENGTH_LONG).show();
        }
        viewModel.isExtendButtonPressed.set(!isPressed);
        viewModel.extendDaysToPayDay();
    }


    @OnClick(R.id.saveChangesButton)
    void onClickSaveChangesButton(){
        viewModel.editDriver();
        Toast.makeText(this, SAVE_CHANGES_MESSAGE, Toast.LENGTH_LONG).show();
    }

    @OnClick(R.id.deleteCarButton)
    void onClickDeleteButton(){
        createDialog().show();
    }

    private void showAddDaysEditText(EditText editText){
        ObjectAnimator animY = ObjectAnimator.ofFloat(editText, View.X
                ,addDaysEditTextLocation[0] + 800F, addDaysEditTextLocation[0]);
        ObjectAnimator alpha = ObjectAnimator.ofFloat(editText, View.ALPHA, 0F, 1F);
        animY.setInterpolator(new OvershootInterpolator());
        animY.setDuration(700);
        alpha.setDuration(500);
        AnimatorSet set = new AnimatorSet();
        set.playTogether(animY, alpha);
        editText.setVisibility(View.VISIBLE);
        set.start();
    }
    private void hideAddDaysEditText(EditText editText){
        ObjectAnimator animY = ObjectAnimator.ofFloat(editText, View.X
                , addDaysEditTextLocation[0], addDaysEditTextLocation[0] + 500F);
        ObjectAnimator alpha = ObjectAnimator.ofFloat(editText, View.ALPHA, 1F, 0F);
        animY.setDuration(700);
        alpha.setDuration(500);
        AnimatorSet set = new AnimatorSet();
        set.playTogether(animY, alpha);
        set.start();
    }

    private AlertDialog createDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.remove_car_title)
                .setMessage(R.string.remove_confirm)
                .setNegativeButton(R.string.remove_no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .setPositiveButton(R.string.remove_yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        viewModel.deleteDriver();
                        dialog.cancel();
                        AdminEditCarActivity.this.finish();
                    }
                });
        return builder.create();
    }
}
