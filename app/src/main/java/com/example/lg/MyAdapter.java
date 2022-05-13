package com.example.lg;

import static java.lang.String.*;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.lg.models.HostedV;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context context;
    ArrayList<HostedV> hostedVArrayList;

    public MyAdapter(Context context,ArrayList<HostedV> hostedVArrayList) {
        this.context = context;
        this.hostedVArrayList = hostedVArrayList;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent,int viewType) {
         View v= LayoutInflater.from(context).inflate(R.layout.hostedve,parent ,false);


        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder,int position) {
          HostedV hostedV=hostedVArrayList.get(position);
          holder.vtype.setText(hostedV.vtype);
          holder.brandModel.setText(hostedV.brandModel);
          holder.location.setText(hostedV.location);
        // Glide.with(context).load(hostedV.image).into(holder.image);

         holder.fairPerHour.setText(String.valueOf(hostedV.fairPerHour));
//holder.fairPerHour.setText(hostedV.fairPerHour);
      holder.seater.setText(String.valueOf(hostedV.seater));
        holder.username.setText(hostedV.username);
       holder.pnumber.setText(String.valueOf(hostedV.pnumber));
       // holder.pnumber.setText(hostedV.pnumber);
       // holder.seater.setText(hostedV.seater);

    }


    @Override
    public int getItemCount() {
        return hostedVArrayList.size();
    }
  public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView vtype,brandModel,location,fairPerHour,seater,username,pnumber;
      //  ImageView image;
        Button bi;


       public MyViewHolder(@NonNull View itemView) {
           super(itemView);
           vtype = itemView.findViewById(R.id.vehicleType);
           brandModel = itemView.findViewById(R.id.BrandModel);
           location = itemView.findViewById(R.id.locationOfVehicle);
           fairPerHour = itemView.findViewById(R.id.Cost);
          // image = itemView.findViewById(R.id.hostedImage);
             bi=itemView.findViewById(R.id.biq);
           seater = itemView.findViewById(R.id.seaterNo);
           username=itemView.findViewById(R.id.owner);
           pnumber=itemView.findViewById(R.id.pno1);
           bi.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   
               }
           });
       }



  }
}
