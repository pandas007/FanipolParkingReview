package com.example.evgen.fanipolparking;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;

import com.example.evgen.fanipolparking.databinding.DriverFragmentBinding;
import com.example.evgen.fanipolparking.presentation.base.BaseMvvmFragment;

import com.example.evgen.fanipolparking.presentation.screens.DriverViewModel;

public class DriverFragment extends BaseMvvmFragment<DriverFragmentBinding, DriverViewModel>{

    NetworkReceiver networkReceiver;

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
    }

    @Override
    public void onPause() {
        super.onPause();
        if (networkReceiver != null) {
            getContext().unregisterReceiver(networkReceiver);
            networkReceiver = null;
        }
    }

    private void initReceiver(NetworkReceiver receiver, Context context){
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        context.registerReceiver(receiver, intentFilter);
    }
}
