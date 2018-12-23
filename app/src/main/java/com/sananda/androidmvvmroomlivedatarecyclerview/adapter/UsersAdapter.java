package com.sananda.androidmvvmroomlivedatarecyclerview.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.support.annotation.NonNull;

import com.android.databinding.library.baseAdapters.BR;
import com.sananda.androidmvvmroomlivedatarecyclerview.data.model.User;
import com.sananda.androidmvvmroomlivedatarecyclerview.viewmodels.DashboardViewModel;

import java.util.List;

/**
 * Created by sananda on 20/12/18.
 */

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.GenericViewHolder> {

    private int layoutId;
    private List<User> users;
    private DashboardViewModel viewModel;

    public UsersAdapter(@LayoutRes int layoutId, DashboardViewModel viewModel) {
        this.layoutId = layoutId;
        this.viewModel = viewModel;
    }

    private int getLayoutIdForPosition(int position) {
        return layoutId;
    }

    @Override
    public int getItemCount() {
        return users == null ? 0 : users.size();
    }

    public GenericViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, viewType, parent, false);

        return new GenericViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull GenericViewHolder holder, int position) {
        holder.bind(viewModel, position);
    }

    @Override
    public int getItemViewType(int position) {
        return getLayoutIdForPosition(position);
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    class GenericViewHolder extends RecyclerView.ViewHolder {
        final ViewDataBinding binding;

        GenericViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(DashboardViewModel viewModel, Integer position) {
            binding.setVariable(BR.viewModel, viewModel);
            binding.setVariable(BR.position, position);
            binding.executePendingBindings();
        }

    }
}