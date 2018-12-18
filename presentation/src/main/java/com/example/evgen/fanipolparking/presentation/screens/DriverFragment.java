package com.example.evgen.fanipolparking.presentation.screens;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;

import com.example.evgen.fanipolparking.R;

import com.example.evgen.fanipolparking.databinding.DriverFragmentBinding;
import com.example.evgen.fanipolparking.presentation.base.BaseMvvmFragment;

import com.example.evgen.fanipolparking.presentation.receivers.NetworkReceiver;
import com.example.evgen.fanipolparking.presentation.screens.viewmodels.DriverViewModel;

import butterknife.OnClick;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.Subject;

public class DriverFragment extends BaseMvvmFragment<DriverFragmentBinding, DriverViewModel>{

    NetworkReceiver networkReceiver;

    private Disposable disposable;

    @Override
    public int provideLayoutId() {
        return R.layout.driver_fragment;
    }

    @Override
    public DriverViewModel provideViewModel() {
        return ViewModelProviders.of(this).get(DriverViewModel.class);
    }

    @Override
    public void onResume() {
        super.onResume();
        networkReceiver = new NetworkReceiver(viewModel);
        initReceiver(networkReceiver, getContext());
        showFoundedCarDialog(viewModel.dialogSubject);
    }

    @Override
    public void onPause() {
        super.onPause();
        if (networkReceiver != null) {
            getContext().unregisterReceiver(networkReceiver);
            networkReceiver = null;
        }
        if (disposable != null) {
            disposable.dispose();
        }
    }

    @OnClick(R.id.driverCheckButton)
    void onClickCheckButton(){
        viewModel.onClickCheckButton();
    }



    private void initReceiver(NetworkReceiver receiver, Context context){
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        context.registerReceiver(receiver, intentFilter);
    }

    private void showFoundedCarDialog(Subject<DriverDialog> subject){
        disposable = subject.subscribe(new Consumer<DriverDialog>() {
            @Override
            public void accept(DriverDialog driverDialog) throws Exception {
                driverDialog.show(DriverFragment.this.getFragmentManager(), "AAA");
            }
        });
    }

}
