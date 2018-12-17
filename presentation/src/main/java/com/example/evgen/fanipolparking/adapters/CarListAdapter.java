package com.example.evgen.fanipolparking.adapters;


import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.android.databinding.library.baseAdapters.BR;
import com.example.evgen.domain.entity.DriverEntity;
import com.example.evgen.fanipolparking.presentation.screens.viewmodels.AdminCarListViewModel;

import java.util.ArrayList;
import java.util.List;

public class CarListAdapter extends RecyclerView.Adapter<CarListAdapter.Holder>{

    private int layoutId;
    private List<DriverEntity> carList = new ArrayList<>();
    private AdminCarListViewModel viewModel;

    public CarListAdapter(int layoutId, AdminCarListViewModel viewModel) {
        this.layoutId = layoutId;
        this.viewModel = viewModel;
    }

    public void setCarList(List<DriverEntity> carList) {
        if (!this.carList.isEmpty()) {
            this.carList.clear();
        }
        this.carList.addAll(carList);
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, layoutId, parent, false);
        return new Holder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.bind(viewModel, position);
    }

    @Override
    public int getItemCount() {
        return carList == null ? 0 : carList.size();
    }

    static class Holder extends RecyclerView.ViewHolder{

        ViewDataBinding binding;


        public Holder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(AdminCarListViewModel viewModel, int position){
            binding.setVariable(BR.viewmodel, viewModel);
            binding.setVariable(BR.position, position);
            binding.executePendingBindings();

        }
    }
}
