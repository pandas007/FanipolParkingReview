package com.example.evgen.fanipolparking.presentation.screens;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;

import com.example.evgen.fanipolparking.R;
import com.example.evgen.fanipolparking.databinding.AdminFragmentBinding;
import com.example.evgen.fanipolparking.presentation.base.BaseMvvmFragment;
import com.example.evgen.fanipolparking.presentation.receivers.NetworkReceiver;
import com.example.evgen.fanipolparking.presentation.screens.viewmodels.AdminViewModel;


public class AdminFragment extends BaseMvvmFragment<AdminFragmentBinding, AdminViewModel> {

    NetworkReceiver networkReceiver;

    @Override
    public int provideLayoutId() {
        return R.layout.admin_fragment;
    }

    @Override
    public AdminViewModel provideViewModel() {
        return ViewModelProviders.of(this).get(AdminViewModel.class);
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
