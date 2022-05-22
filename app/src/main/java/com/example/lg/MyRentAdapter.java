package com.example.lg;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lg.models.HostedV;
import com.example.lg.models.RentedV;

import java.util.ArrayList;

public class MyRentAdapter extends RecyclerView.Adapter<MyRentAdapter.MyViewHolder> {
    Context context;
    ArrayList<RentedV> rentedVArrayList;

    /*public interface onItemClickListener{
        void onDeleteClick(int position);
    }
    public void setOnItemClickListener(onItemClickListener listener){
        mlistener=listener;
    }*/


    public MyRentAdapter(Context context,ArrayList<RentedV> rentedVArrayList) {
        this.context = context;
        this.rentedVArrayList = rentedVArrayList;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent,int viewType) {
        View v=LayoutInflater.from(context).inflate(R.layout.renth,parent,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder,int position) {
        RentedV rentedV = rentedVArrayList.get(position);
        holder.vtype.setText(rentedV.vtype);
        holder.brandModel.setText(rentedV.brandModel);
        holder.location.setText(rentedV.location);
        // Glide.with(context).load(hostedV.image).into(holder.image);
        holder.rno.setText(rentedV.rno);
        holder.fairPerHour.setText(String.valueOf(rentedV.fairPerHour));
        holder.seater.setText(String.valueOf(rentedV.seater));
        holder.username.setText(rentedV.username);
        holder.pnumber.setText(String.valueOf(rentedV.pnumber));


    }


    @Override
    public int getItemCount() {
        return rentedVArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView vtype, brandModel, location, fairPerHour, seater, username, pnumber, rno;
        //  ImageView image;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            vtype = itemView.findViewById(R.id.vehicleType1);
            brandModel = itemView.findViewById(R.id.BrandModel1);
            location = itemView.findViewById(R.id.locationOfVehicle1);
            fairPerHour = itemView.findViewById(R.id.Cost1);
            // image = itemView.findViewById(R.id.hostedImage);
            seater = itemView.findViewById(R.id.seaterNo1);
            username = itemView.findViewById(R.id.owner1);
            pnumber = itemView.findViewById(R.id.pno11);
            rno = itemView.findViewById(R.id.rno11);

        }


    }
}