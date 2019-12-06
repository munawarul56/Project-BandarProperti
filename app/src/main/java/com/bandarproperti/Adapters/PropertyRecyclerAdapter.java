package com.bandarproperti.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import com.bandarproperti.ModelClasses.PropertyRecyclerModel;
import com.bandarproperti.PropertyDetailsActivity;
import com.bandarproperti.R;


public class PropertyRecyclerAdapter  extends RecyclerView.Adapter<PropertyRecyclerAdapter.MyViewHolder> {

        Context context;


        private List<PropertyRecyclerModel> OfferList;


        public class MyViewHolder extends RecyclerView.ViewHolder {


            TextView propertyName,street1,street2,amount,bedCount,carParking,swimmingpool;

            public MyViewHolder(View view) {
                super(view);

                propertyName=(TextView) view.findViewById(R.id.propertyName);
                street1=(TextView)view.findViewById(R.id.street1);
                street2=(TextView)view.findViewById(R.id.street2);
                amount=(TextView) view.findViewById(R.id.amount);
                bedCount=(TextView) view.findViewById(R.id.bedCount);
                carParking=(TextView) view.findViewById(R.id.carParking);
                swimmingpool=(TextView) view.findViewById(R.id.swimmingPool);
            }

        }


        public PropertyRecyclerAdapter(Context mainActivityContacts, List<PropertyRecyclerModel> offerList) {
            this.OfferList = offerList;
            this.context = mainActivityContacts;
        }

        @Override
        public PropertyRecyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.recycler_view, parent, false);


            return new PropertyRecyclerAdapter.MyViewHolder(itemView);


        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            PropertyRecyclerModel lists = OfferList.get(position);

            holder.propertyName.setText(lists.getPropertyName());
            holder.street1.setText(lists.getStreet1());
            holder.street2.setText(lists.getStreet2());
            holder.amount.setText(lists.getAmount());
            holder.bedCount.setText(lists.getBedCount());
            holder.carParking.setText(lists.getCarParking());
            holder.swimmingpool.setText(lists.getSwimmingpool());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, PropertyDetailsActivity.class);
                    context.startActivity(intent);
                }
            });

        }


        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)


        @Override
        public int getItemCount() {
            return OfferList.size();

        }

    }


