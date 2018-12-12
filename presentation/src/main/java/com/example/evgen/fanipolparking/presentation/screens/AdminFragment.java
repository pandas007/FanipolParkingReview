package com.example.evgen.fanipolparking.presentation.screens;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.util.Log;

import com.example.evgen.fanipolparking.R;
import com.example.evgen.fanipolparking.databinding.AdminFragmentBinding;
import com.example.evgen.fanipolparking.presentation.base.BaseMvvmFragment;
import com.example.evgen.fanipolparking.presentation.receivers.NetworkReceiver;
import com.example.evgen.fanipolparking.presentation.screens.viewmodels.AdminViewModel;

import butterknife.OnClick;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.subjects.CompletableSubject;


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
        enterAdminActivity(viewModel.completable);
    }

    @Override
    public void onPause() {
        super.onPause();
        if (networkReceiver != null) {
            getContext().unregisterReceiver(networkReceiver);
            networkReceiver = null;
        }
    }

    @OnClick(R.id.adminEnterButton)
    void onClickEnterButton() {
        viewModel.onClickEnterAdmin();
    }

    private void initReceiver(NetworkReceiver receiver, Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        context.registerReceiver(receiver, intentFilter);
    }


    /**
     * Subscribe on completable and listen for a click event in the AdminViewModel.
     * Start AdminCarListActivity if pressed.
     * @param completable = CompletableSubject in VM
     */
    private void enterAdminActivity(CompletableSubject completable) {
        completable.subscribe(new Action() {
            @Override
            public void run() throws Exception {
                startActivity(new Intent(getActivity(), AdminCarListActivity.class));
            }
        });
    }
}
