package com.bandarproperti.adapters;

import android.annotation.SuppressLint;
import android.arch.paging.PagedListAdapter;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bandarproperti.databinding.NetworkItemBinding;
import com.bandarproperti.databinding.PropertyItemBinding;
import com.bandarproperti.helper.CurrencyFormatHelper;
import com.bandarproperti.helper.MyHelper;
import com.bandarproperti.helper.NetworkState;
import com.bandarproperti.models.Property;

public class PropertyAdapter extends PagedListAdapter<Property, RecyclerView.ViewHolder> {

    private static final int TYPE_PROGRESS = 0;
    private static final int TYPE_ITEM = 1;

    private Context context;
    private NetworkState networkState;
    private MyHelper helper;

    public PropertyAdapter(Context context) {
        super(DIFF_CALLBACK);
        this.context = context;

        helper = new MyHelper();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        if(viewType == TYPE_PROGRESS) {
            NetworkItemBinding headerBinding = NetworkItemBinding.inflate(layoutInflater, parent, false);
            NetworkStateItemViewHolder viewHolder = new NetworkStateItemViewHolder(headerBinding);
            return viewHolder;

        } else {
            PropertyItemBinding itemBinding = PropertyItemBinding.inflate(layoutInflater, parent, false);
            PropertyViewHolder viewHolder = new PropertyViewHolder(itemBinding);
            return viewHolder;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        if(viewHolder instanceof PropertyViewHolder) {
            ((PropertyViewHolder)viewHolder).bindTo(getItem(position));
        } else {
            ((NetworkStateItemViewHolder) viewHolder).bindView(networkState);
        }
    }

    private static DiffUtil.ItemCallback<Property> DIFF_CALLBACK = new DiffUtil.ItemCallback<Property>() {
        @Override
        public boolean areItemsTheSame(@NonNull Property property, @NonNull Property t1) {
            return property.id == t1.id;
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(@NonNull Property property, @NonNull Property t1) {
            return property.equals(t1);
        }
    };

    /*
     * Default method of RecyclerView.Adapter
     */
    @Override
    public int getItemViewType(int position) {
        if (hasExtraRow() && position == getItemCount() - 1) {
            return TYPE_PROGRESS;
        } else {
            return TYPE_ITEM;
        }
    }


    private boolean hasExtraRow() {
        if (networkState != null && networkState != NetworkState.LOADED) {
            return true;
        } else {
            return false;
        }
    }

    public void setNetworkState(NetworkState newNetworkState) {
        NetworkState previousState = this.networkState;
        boolean previousExtraRow = hasExtraRow();
        this.networkState = newNetworkState;
        boolean newExtraRow = hasExtraRow();
        if (previousExtraRow != newExtraRow) {
            if (previousExtraRow) {
                notifyItemRemoved(getItemCount());
            } else {
                notifyItemInserted(getItemCount());
            }
        } else if (newExtraRow && previousState != newNetworkState) {
            notifyItemChanged(getItemCount() - 1);
        }
    }

    /*
     * We define A custom ViewHolder for the list item
     */
    public class PropertyViewHolder extends RecyclerView.ViewHolder {

        private PropertyItemBinding binding;
        public PropertyViewHolder(PropertyItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindTo(Property property) {
            helper.loadImage(context, property.getImage(), binding.propertyImage);
            binding.propertyId.setText(String.valueOf(property.getId()));
            binding.propertyName.setText(property.getName());
            binding.propertyType.setText(property.getType());
            binding.propertyPrice.setText("Rp. " + new CurrencyFormatHelper().localFormatView(property.getPrice()));
            binding.propertyBed.setText(String.valueOf(property.getBedrooms()));
            binding.propertyBath.setText(String.valueOf(property.getBathrooms()));
            binding.propertyGerage.setText(String.valueOf(property.getGerages()));
            binding.propertyAddress.setText(String.valueOf(property.getAddress()));
        }
    }


    /*
     * We define A custom ViewHolder for the progressView
     */
    public class NetworkStateItemViewHolder extends RecyclerView.ViewHolder {

        private NetworkItemBinding binding;
        public NetworkStateItemViewHolder(NetworkItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindView(NetworkState networkState) {
            if (networkState != null && networkState.getStatus() == NetworkState.Status.RUNNING) {
                binding.progressBar.setVisibility(View.VISIBLE);
            } else {
                binding.progressBar.setVisibility(View.GONE);
            }

            if (networkState != null && networkState.getStatus() == NetworkState.Status.FAILED) {
                binding.errorMsg.setVisibility(View.VISIBLE);
                binding.errorMsg.setText(networkState.getMsg());
            } else {
                binding.errorMsg.setVisibility(View.GONE);
            }
        }
    }
}
