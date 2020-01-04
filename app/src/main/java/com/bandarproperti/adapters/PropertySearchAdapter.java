package com.bandarproperti.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bandarproperti.databinding.PropertyItemBinding;
import com.bandarproperti.helper.CurrencyFormatHelper;
import com.bandarproperti.helper.MyHelper;
import com.bandarproperti.models.Property;

import java.util.List;

public class PropertySearchAdapter extends RecyclerView.Adapter<PropertySearchAdapter.PropertyViewHolder> {

    Context context;
    private List<Property> properties;
    private MyHelper myHelper;

    public PropertySearchAdapter(Context context, List<Property> properties) {
        this.context = context;
        this.properties = properties;

        myHelper = new MyHelper();
    }

    @NonNull
    @Override
    public PropertyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());

        PropertyItemBinding itemBinding = PropertyItemBinding.inflate(layoutInflater, viewGroup, false);
        PropertySearchAdapter.PropertyViewHolder viewHolder = new PropertySearchAdapter.PropertyViewHolder(itemBinding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PropertyViewHolder propertyViewHolder, int i) {
        Property property = properties.get(i);

        propertyViewHolder.bindTo(property);
    }

    @Override
    public int getItemCount() {
        return properties.size();
    }

    public class PropertyViewHolder extends RecyclerView.ViewHolder {

        private PropertyItemBinding binding;
        public PropertyViewHolder(PropertyItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindTo(Property property) {
            myHelper.loadImage(context, property.getImage(), binding.propertyImage);
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
}
