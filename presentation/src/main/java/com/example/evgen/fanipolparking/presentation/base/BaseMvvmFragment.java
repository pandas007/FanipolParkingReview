package com.example.evgen.fanipolparking.presentation.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.evgen.fanipolparking.BR;


public abstract class BaseMvvmFragment <Binding extends ViewDataBinding, ViewModel extends BaseViewModel> extends Fragment {

    protected Binding binding;
    protected ViewModel viewModel;

    public abstract int provideLayoutId();
    public abstract ViewModel provideViewModel();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewModel = provideViewModel();
        binding = DataBindingUtil.inflate(inflater, provideLayoutId(), container, false);
        binding.setVariable(BR.viewmodel, viewModel);
        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        viewModel.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        viewModel.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        viewModel.onStop();
    }

    @Override
    public void onStart() {
        super.onStart();
        viewModel.onStart();
    }
}
